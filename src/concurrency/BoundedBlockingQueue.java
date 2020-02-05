package concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;

    private int mCapacity;
    private Queue<Integer> mQueue;


    public BoundedBlockingQueue(int capacity) {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        mCapacity = capacity;
        mQueue = new ArrayDeque<>(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (mQueue.size() == mCapacity) {
                notFull.await();
            }
            mQueue.add(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            Integer result = null;

            while (mQueue.isEmpty()) {
                notEmpty.await();
            }
            result = mQueue.poll();
            notFull.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return mQueue.size();
        } finally {
            lock.unlock();
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> list;

    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        int loc = hashMap.get(val);
        if (loc < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(loc, last);
            hashMap.put(last, loc);
        }
        hashMap.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        randomizedSet.remove(2);
        System.out.println(randomizedSet.getRandom());

    }
}


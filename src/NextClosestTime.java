import java.util.Arrays;
import java.util.stream.Stream;

public class NextClosestTime {
    /**
     * Input: "19:34"
     * Output: "19:39"
     * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
     * It is not 19:33, because this occurs 23 hours and 59 minutes later.
     */
    private int diff = Integer.MAX_VALUE;

    public String nextClosestTime(String time) {
        int[] digit = new int[4];
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        digit[0] = hour / 10;
        digit[1] = hour % 10;
        digit[2] = minute / 10;
        digit[3] = minute % 10;

        StringBuilder res = new StringBuilder();
        getNextCloestTime(digit, 0, hour, minute, new int[4], res);
        return res.toString();
    }

    private void getNextCloestTime(int[] digit, int idx, int hour, int minute, int[] tmp, StringBuilder res) {
        if (idx == 4) {
            int curHour = 10 * tmp[0] + tmp[1];
            int curMin = 10 * tmp[2] + tmp[3];
            if (curHour >= 0 && curHour <= 23 && curMin >= 0 && curMin <= 59) {
                int curDiff = getDiff(curHour, curMin, hour, minute);
                if (curDiff < diff) {
                    diff = curDiff;
                    res.replace(0, res.length(), formatTime(curHour) + ":" + formatTime(curMin));
                }
            }

        } else {
            for (int i = 0; i < 4; i++) {
                tmp[idx] = digit[i];
                getNextCloestTime(digit, idx + 1, hour, minute, tmp, res);
            }
        }
    }

    public int getDiff(int curHour, int curMin, int hour, int min) {
        int diff1 = 3600 - (60 * hour + min);
        int diff2 = 3600 - (60 * curHour + curMin);
        return diff2 < diff1 ? diff1 - diff2 : diff1 - diff2 + 3600;
    }


    public String formatTime(int time) {
        if (time >= 0 && time <= 9) {
            return "0" + time;
        }
        return "" + time;
    }


    public static void main(String[] args) {
        NextClosestTime nct = new NextClosestTime();
        System.out.println(nct.nextClosestTime("23:59"));
    }
}

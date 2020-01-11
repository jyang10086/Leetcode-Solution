import java.util.HashMap;
import java.util.Map;

public class LengthLongestPath {
    public int lengthLongestPath(String input) {


        Map<Integer, Integer> map = new HashMap<>();
        String[] strs = input.split("\n");
        int res = 0;
        for (String line : strs) {
            int level = line.lastIndexOf("\t") + 1;
            int len = line.length() - level;
            if (line.contains(".")) {
                res = Math.max(res, map.getOrDefault(level, 0) + len);
            } else {
                // map.getOrDefault(level, 0) + len + 1 means get the len of last level plus the len of current level
                // and plus 1 because of adding "/"
                map.put(level + 1, map.getOrDefault(level, 0) + len + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        LengthLongestPath llp = new LengthLongestPath();
        String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(llp.lengthLongestPath(str));

        String ss = "dir\n\tsubdir1\n\t\tfile.ext";
        System.out.println(ss.length());
    }
}

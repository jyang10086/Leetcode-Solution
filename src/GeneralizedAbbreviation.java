import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralizedAbbreviation {
    //        Input: "word"
//        Output:
//          ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    public List<String> generateAbbreviations(String word) {
        Set<String> result = new HashSet<>();
        getAbbreviations(word, 0, 0, "", result);
        return new ArrayList<>(result);
    }

    private void getAbbreviations(String word, int pos, int cnt, String curStr, Set<String> res) {
//        int cnt = end - start + 1;
//        System.out.println("start:" + start + "  |||   end:" + end);
//        System.out.println("cnt:" + cnt);
//        if(cnt == 0) {
//            res.add(word);
//            return;
//        }
//        String abbreviatedStr = word.substring(0, start) + String.valueOf(cnt) + word.substring(end + 1, word.length());
//        res.add(abbreviatedStr);
        System.out.println("pos: " + pos + " |||| cnt: " + cnt + " |||| curStr: " + curStr);
        if (pos == word.length()) {
            if (cnt > 0) {
                curStr += cnt;
            }
            System.out.println("curStr: " + curStr);
            System.out.println();
            res.add(curStr);
            return;
        }
        getAbbreviations(word, pos + 1, cnt + 1, curStr, res);

        // Keep the current character
        getAbbreviations(word, pos + 1, 0, curStr + (cnt > 0 ? cnt : "") + word.charAt(pos), res);


    }

    public static void main(String[] args) {
        GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
        List<String> res = ga.generateAbbreviations("word");
        System.out.println(res);
    }
}

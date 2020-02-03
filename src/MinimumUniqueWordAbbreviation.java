import java.util.PriorityQueue;

public class MinimumUniqueWordAbbreviation {
    // 411 = 320 + 408
    public String minAbbreviation(String target, String[] dictionary) {
        PriorityQueue<String> targetAbbrs = new PriorityQueue<>((a, b) -> (a.length() - b.length()));
        getAbbreviation(0, 0, "", target, targetAbbrs);
        while (!targetAbbrs.isEmpty()) {
            String curAbbr = targetAbbrs.remove();
            boolean conflict = false;

            for (String word : dictionary) {
                if (isValidateAbbr(word, curAbbr)) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {
                return curAbbr;
            }
        }

        return "";
    }

    private void getAbbreviation(int idx, int cnt, String curStr, String str, PriorityQueue<String> result) {
        if (idx == str.length()) {
            if (cnt > 0) {
                curStr += cnt;
            }
            result.add(curStr);
        }
        getAbbreviation(idx++, cnt++, curStr, str, result);
        getAbbreviation(idx++, 0, curStr + (cnt > 0 ? cnt : "") + str.charAt(idx), str, result);
    }

    private boolean isValidateAbbr(String word, String abbr) {
        int i = 0, j = 0, num = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                    return false;
                }
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            }
        }
        return i == word.length() && j == abbr.length();
    }


    public static void main(String[] args) {
        MinimumUniqueWordAbbreviation muwa = new MinimumUniqueWordAbbreviation();
//        muwa.minAbbreviation("apple", new ArrayList<>({"));
    }
}

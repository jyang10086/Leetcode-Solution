public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        //int len = word.length();
        int i = 0;
        int j = 0;
        //int num = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (!Character.isDigit(abbr.charAt(j))) return false;
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int num = Integer.valueOf(abbr.substring(start, j));
                i += num;
            }
        }
        System.out.println("i:" + i + "   j:" + j);
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        ValidWordAbbreviation vwa = new ValidWordAbbreviation();
        boolean res = vwa.validWordAbbreviation("hi",
                "hi1");
        System.out.println(res);
        boolean res2 = vwa.validWordAbbreviation("internationalization",
                "i5a11o1");
        System.out.println(res2);

    }
}

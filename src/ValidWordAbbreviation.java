public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0') return false;
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

        boolean res3 = vwa.validWordAbbreviation("internationalization",
                "i12iz4n");
        System.out.println(res3);
        boolean res4 = vwa.validWordAbbreviation("a",
                "01");
        System.out.println(res4);


    }
}

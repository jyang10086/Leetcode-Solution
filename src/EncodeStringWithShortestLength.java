import java.util.Arrays;

public class EncodeStringWithShortestLength {

    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.substring(i, i + len);
                if (len <= 3) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];
                    if (left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                String consecutiveSubStr = findConsecutiveSubStr(dp, s.substring(i, i + len), i);
                if (consecutiveSubStr.length() < dp[i][j].length()) {
                    dp[i][j] = consecutiveSubStr;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    private String findConsecutiveSubStr(String[][] dp, String str, int start) {
        String doubleStr = str + str;
        int index = doubleStr.indexOf(str, 1);
        if (index >= str.length()) {
            return str;
        } else {
            return (str.length() / index) + "[" + dp[start][start + index - 1] + "]";
        }
    }

    public static void main(String[] args) {
        String str = "bbbbbbbbb";
        String doubleStr = str + str;
        int pos = doubleStr.indexOf(str, 1);
        if (pos >= str.length()) {
            System.out.println("无连续重复子串");
        } else {
            String sub = str.substring(0, pos);
            int cnt = str.length() / pos;

            System.out.println("sub:" + sub);
            System.out.println("cnt:" + cnt);
        }
        EncodeStringWithShortestLength eswsl = new EncodeStringWithShortestLength();
        String ans = eswsl.encode("aaaaab");
        System.out.println(ans);
    }
}

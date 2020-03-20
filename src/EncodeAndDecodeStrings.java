import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(parseLen(str.length()));
            sb.append(str);
        }
        return sb.toString();
    }

    //int 32bits
    //byte 8bits
    private String parseLen(int len) {
        char[] bytes = new char[4];
        for (int i = 3; i >= 0; i--) {
            bytes[3 - i] = (char) (len >>> (i * 8) & 0xff);
        }
        return String.valueOf(bytes);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> ans = new ArrayList<>();
        while (i < n) {
            int length = parseStr(s.substring(i, i + 4));
            i += 4;
            ans.add(s.substring(i, i + length));
            i += length;
        }
        return ans;
    }

    private int parseStr(String str) {
        int result = 0;
        for (char ch : str.toCharArray()) {
            result = (result << 8) + (int) ch;
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings eads = new EncodeAndDecodeStrings();
        List<String> strings = new ArrayList<>();
        strings.add("abcd");
        String encode = eads.encode(strings);
        eads.decode(encode);
    }
}

import java.util.*;

public class AlienDictionary {
    /**
     * Input:
     * [
     * "wrt",
     * "wrf",
     * "er",
     * "ett",
     * "rftt"
     * ]
     * <p>
     * Output: "wertf"
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String curWord = words[i];
            String preWord = words[i - 1];
            for (int j = 0; j < Math.min(curWord.length(), preWord.length()); j++) {
                char curCh = curWord.charAt(j);
                char preCh = preWord.charAt(j);
                if (curCh != preCh) {
                    Set<Character> set = map.getOrDefault(preCh, new HashSet<>());
                    if (!set.contains(curCh)) {
                        set.add(curCh);
                        map.put(preCh, set);
                    }
                    break;
                }
            }
        }

        // map.entrySet().forEach(entry-> {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // });

        int[] degrees = new int[26];
        Arrays.fill(degrees, -1);
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                degrees[ch - 'a'] = 0;
            }
        }
        for (char keySet : map.keySet()) {
            for (char val : map.get(keySet)) {
                degrees[val - 'a']++;
            }
        }

        //Arrays.stream(degrees).forEach(num  -> System.out.print(num + " "));
        Queue<Character> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (degrees[i] != -1) cnt++;
            if (degrees[i] == 0) {
                queue.add((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curValue = queue.poll();
            result.append(curValue);
            if (map.containsKey(curValue)) {
                Set<Character> set = map.get(curValue);
                for (char ch : set) {
                    degrees[ch - 'a']--;
                    if (degrees[ch - 'a'] == 0) queue.add(ch);
                }
            }
        }
        return cnt == result.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        String res = ad.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println("result: " + res);
    }
}

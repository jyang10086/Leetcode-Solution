import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
    private int match(String guess, String w) {
        int match = 0;
        for (int i = 0; i < w.length(); i++) {
            if (guess.charAt(i) == w.charAt(i)) {
                match++;
            }
        }
        return match;
    }

    //Solution one
    // If we guess a word, we're given its distance from the secret,
    // which allows us to eliminate words whose distance from the guess is different.
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            String word = wordlist[new Random().nextInt(wordlist.length)];
            int guessValue = master.guess(word);
            if (guessValue == 6) return;
            if (guessValue < 6) {
                List<String> newWordlist = new ArrayList<>();
                for (String w : wordlist) {
                    if (match(word, w) == guessValue) {
                        newWordlist.add(w);
                    }
                }
                wordlist = newWordlist.toArray(new String[0]);
            }
        }
    }

    //Solution Two
    //assume always run into the worst case (0 matches)
    //guess the word with minimum words of 0 matches.
    public void findSecretWord2(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            String guess = null;
            int minMatch = Integer.MAX_VALUE;
            // find the word with minimum words of 0 matches.
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < minMatch) {
                    guess = w;
                    minMatch = count.getOrDefault(w, 0);
                }
            }
            int guessValue = master.guess(guess);
            List<String> newWordlist = new ArrayList<>();
            for (String w : wordlist) {
                if (match(guess, w) == guessValue) {
                    newWordlist.add(w);
                }
            }
            wordlist = newWordlist.toArray(new String[0]);
            if (guessValue == 6) {
                return;
            }
        }
    }


    //Solution Three
    //guess the word based on the most frequent character on the position
    public void findSecretWord3(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            int count[][] = new int[6][26];
            // count the occurrence for each character on each position.
            for (String w : wordlist) {
                for (int j = 0; j < 6; j++) {
                    count[j][w.charAt(j) - 'a']++;
                }
            }
            int best = 0;
            String guess = null;
            //guess the word based on the most frequent character on the position
            for (String w : wordlist) {
                int score = 0;
                for (int k = 0; k < 6; ++k) {
                    score += count[k][w.charAt(k) - 'a'];
                    if (score > best) {
                        guess = w;
                        best = score;
                    }
                }
            }
            int guessValue = master.guess(guess);
            List<String> newWordlist = new ArrayList<>();
            for (String w : wordlist) {
                if (match(guess, w) == guessValue) {
                    newWordlist.add(w);
                }
            }
            wordlist = newWordlist.toArray(new String[0]);
            if (guessValue == 6) {
                return;
            }
        }
    }
}

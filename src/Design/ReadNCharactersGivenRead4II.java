package Design;

public class ReadNCharactersGivenRead4II {
    class Reader4 {
        public int read4(char[] buf) {
            return 4;
        }
    }

    public class Solution extends Reader4 {
        int cacheSize = 0;
        int fp = 0; // pointer for cache
        char[] tmp = new char[4];

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int index = 0;

            while (index < n) {
                if (cacheSize == 0) {
                    cacheSize = read4(tmp);
                    if (cacheSize == 0) {
                        break;
                    }
                }

                while (index < n && fp < cacheSize) {
                    buf[index++] = tmp[fp++];
                }

                if (fp == cacheSize) {
                    // tmp has read out, need to be empty
                    fp = 0;
                    cacheSize = 0;
                }
            }

            return index;
        }


    }
}

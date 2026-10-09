class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // If need is odd, insert one ')'
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                // Each '(' requires two ')'
                need += 2;
            } else {
                need--;

                // No matching '(' available
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        // Insert any remaining required ')'
        return insertions + need;
    }
}
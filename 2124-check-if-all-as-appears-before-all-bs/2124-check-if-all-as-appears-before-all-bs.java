class Solution {
    public boolean checkString(String s) {
        boolean B = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'b') {
                B = true;
            } else if (B) {
                return false;
            }
        }
        return true;
    }
}
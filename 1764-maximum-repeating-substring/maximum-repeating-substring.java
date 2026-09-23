class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String current = "";
        while (true) {
            current += word;
            if (sequence.contains(current)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
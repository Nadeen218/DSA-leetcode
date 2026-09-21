class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

            int number = entry.getKey();
            int count = entry.getValue();

            minHeap.offer(new int[]{number, count});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}
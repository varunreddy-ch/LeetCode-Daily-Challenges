class Solution {
    public long putMarbles(int[] weights, int k) {
        // Think the solution with diffrent pairs
        
        int[] arr = new int[weights.length-1];
        
        for(int i=0;i<weights.length-1;i++) {
            arr[i] = weights[i] + weights[i+1];
        }
        
        Arrays.sort(arr);
        
        long max = weights[0] + weights[weights.length-1];
        
        int temp_k = k;
        
        int pointer = arr.length-1;
        while(temp_k > 1) {     // For k=2, we will get 1 partition line
            max += arr[pointer--];
            temp_k--;
        }
        
        long min = weights[0] + weights[weights.length-1];
        
        temp_k = k;
        pointer = 0;
        
        while(temp_k > 1) {
            min += arr[pointer++];
            temp_k--;
        }
        
        return max - min;
    }
}

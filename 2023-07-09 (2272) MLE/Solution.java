// Memory Limit Exceeded

class Solution {
    char[] str;
    boolean[][] isVisited;
    
    int max = 0;
    public int largestVariance(String s) {
        this.str = s.toCharArray();
        
        int length = str.length;
        
        int[][][] dp = new int[length][length][26];
        this.isVisited = new boolean[length][length];
        
        for(int i=0; i< this.str.length; i++) {
            int[] temp = helper(i, this.str.length-1, dp);
        }
        return max;
    }
    
    void getVariance(int[] arr) {
        int max1 = arr[0];
        int min1 = Integer.MAX_VALUE;
        
        for(int i=0;i<26;i++) {
            if(max1 < arr[i]) {
                max1 = arr[i];
            }
            if(min1 > arr[i] && arr[i] != 0) {
                min1 = arr[i];
            }
        }
        // System.out.println(max1 - min1);
        this.max = Math.max(this.max, max1 - min1);
    }
    
    int[] helper(int start, int end, int[][][] dp) {
        
        if(isVisited[start][end]) {
            return dp[start][end];
        }
        else if( start == end) {
            int[] temp = new int[26];
            temp[this.str[start] - 97]++;
            
            isVisited[start][start] = true;
            return dp[start][start] = temp;
        }
        else {
            int[] temp1 = helper(start, end-1, dp);
            int[] temp2 = helper(end, end, dp);
            
            for(int i=0; i< 26;i++) {
                temp1[i] += temp2[i];
            }
            
            // System.out.print("Start:" + start + " End:" + end + " ");
            getVariance(temp1);
            return temp1;
        }
    }
}

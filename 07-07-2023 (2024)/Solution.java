class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'),
                        helper(answerKey, k, 'F'));
        
    }
    int helper(String key, int k, char ch) {
        int start = 0;
        int end = 0;
        int length = key.length();
        
        int max = 0;
        
        while(end < length) {
            if(key.charAt(end) == ch) {
                end++;
            }
            else {
                if( k > 0) {
                    k--;
                    end++;
                }
                else {
                    while(k == 0) {
                        if(key.charAt(start) != ch) k++;
                        start++;
                    }
                }
            }
            
            max = Math.max(max, end - start);
            // System.out.println(start+ " "+ end+ " "+ k +" "+ max);
        }
        
        // System.out.println("\n\n\n");
        return max;
    }
}

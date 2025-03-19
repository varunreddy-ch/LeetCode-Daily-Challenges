class Solution {
    public int longestNiceSubarray(int[] nums) {
    int start = 0;
    int end = 1;

    int ans = 1;

    while(start <= end && end < nums.length) {
        // System.out.println(start + " " + end);
        if(start == end) {
            end++;
            continue;
        }
        if(end >= nums.length)  break;
        // Try adding next element
        int next_ele = nums[end];
        boolean isValid = true;

        for(int i= start; i < end; i++) {
            // System.out.println(nums[i] & next_ele);
            if( (nums[i] & next_ele) != 0) {
                isValid = false;
                break;
            }
        }

        if(isValid) {
            ans = Math.max(ans, end - start + 1);
            end++;
            continue;
        }
        else if(!isValid) {
            start++;
            continue;
        }
    }
        return ans;
    }
}

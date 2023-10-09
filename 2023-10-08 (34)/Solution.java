class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0) {
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length-1;
        
        int index = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            // System.out.println(nums[mid]);
            
            if(nums[mid] == target) {
                index = mid;
                break;
            }
            else if(nums[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        
        if(index == -1) {
            return new int[]{-1,-1};
        }
        
        
        int left = index;
        
        // System.out.println(index);
        
        while(left > 0 && nums[left-1]== target) {
            left--;
        }
        int right = index;
        while(right < nums.length-1 && nums[right+1] == target) {
            right++;
        }
        
        
        return new int[]{left, right};
    }
}

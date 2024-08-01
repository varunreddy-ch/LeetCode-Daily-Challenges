class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s: details) {
            int val = Integer.parseInt(""+s.charAt(11))*10 + Integer.parseInt(""+s.charAt(12));
            
            if(val > 60) {
                count++;
            }
        }
        
        return count;
    }
}
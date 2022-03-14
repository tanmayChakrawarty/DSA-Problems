class Solution {
    public int Sevenish(int num) {
        int last_pow_idx = 0;
        int add_idx = 0;

        int[] dp = new int[num];
        for(int i=0 ; i<num ; i++) {
            dp[i] = 1;
        }

        for(int i=1 ; i<num ; i++) {
            if(add_idx == last_pow_idx) {
                add_idx = 0;
                dp[i] = dp[last_pow_idx] * 7;
                last_pow_idx = i;
            }
            else {
                dp[i] = dp[last_pow_idx] + dp[add_idx];
                add_idx += 1;
            }
        }

        return dp[num-1];
    }
}
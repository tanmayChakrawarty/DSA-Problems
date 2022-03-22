/*

1. Brute Force
Using three for loops, we will get all possible subarrays in two loops and their sum in another loop, 
and then return the maximum of them.

Time Complexity:- O(N^3)
Space Complexity:- O(1)

*/
class Solution {
    public int maxSubarraySum(int[] nums, ArrayList<Integer> subarray) {
        int n = nums.length;
        int max_sum = Integer.MIN_VALUE;

        if(n == 1) {
            return nums[0];
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=i ; j<n ; j++) {
                int cur_sum = 0;
                for(int k=i ; k<=j ; k++) {
                    cur_sum += nums[k];
                }
                if(cur_sum > max_sum) {
                    max_sum = cur_sum;

                    subarray.clear(); // clear the previous subarray
                    subarray.add(i); // starting index of subarray
                    subarray.add(j); // end index of subarray

                    // this will help in printing the subarray itself
                    // traverse from i to j and print elements.

                }
            }
        }

        return max_sum; 
    }
}

/*

2. Optimization of the above approach
Eliminate the third loop.

Time Complexity:- O(N^2)
Space Complexity:- O(1)

*/
class Solution {
    public int maxSubarraySum(int[] nums, ArrayList<Integer> subarray) {
        int n = nums.length;
        int max_sum = Integer.MIN_VALUE;

        if(n == 1) {
            return nums[0];
        }

        for(int i=0 ; i<n ; i++) {
            int cur_sum = 0;
            for(int j=i ; j<n ; j++) {
                cur_sum += nums[j];
                if(cur_sum > max_sum) {
                    max_sum = cur_sum;

                    subarray.clear(); // clear the previous subarray
                    subarray.add(i); // starting index of subarray
                    subarray.add(j); // end index of subarray

                    // this will help in printing the subarray itself
                    // traverse from i to j and print elements.

                }
            }
        }

        return max_sum; 
    }
}

/*

3. Kadane's Algorithm

Time Complexity:- O(N)
Space Complexity:- O(1)

*/
class Solution {
    public int maxSubarraySum(int[] nums, ArrayList<Integer> subarray) {
        int n = nums.length;
        int max_sum = nums[0];
        int cur_sum = 0;
        int start_idx = 0;

        for(int i=0 ; i<n ; i++) {
            cur_sum += nums[i];

            if(cur_sum > max_sum) {
                max_sum = cur_sum;
                
                subarray.clear(); // clear the previous subarray
                subarray.add(i); // starting index of subarray
                subarray.add(j); // end index of subarray

                // this will help in printing the subarray itself
                // traverse from i to j and print elements.
            }
            
            if(cur_sum < 0) {
                cur_sum = 0;
                start_idx = i+1;
            }

        }

        return max_sum;
    }
}
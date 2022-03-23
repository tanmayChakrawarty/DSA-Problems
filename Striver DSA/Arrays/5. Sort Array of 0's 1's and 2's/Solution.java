/*

1. Sorting (Not recommended)
Simple sorting of array.

Time Complexity:- O(N logN)
Space Complexity:- O(1)

*/

/*

2. Keep count of elements
Array contains onlt 1,2 and 3.
keep count of them in three variables and overwrite the array based on count.

Time Complexity:- O(N)+O(N)
Space Complexity:- O(1)

*/

/*

3. 3-Pointer approach
In this approach, we will be using 3 pointers named low, mid, and high. 
We will be using these 3 pointers to move around the values. 
The primary goal here is to 
1. move 0s to the left of the array
2. move 2s to the right of the array 
3. 1s shall be in the middle region of the array i.e. don't move them
and hence the array will be sorted.

Time Complexity:- O(N)
Space Complexity:- O(1)

*/
class Solution {
    public void sortNumbers(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high) {
            switch(nums[mid]) {
                case 0: {
                    int temp = nums[low]; 
                    nums[low] = nums[mid]; 
                    nums[mid] = temp; 
                    low++; 
                    mid++; 
                    break; 
                }
                case 1: {
                    mid++; 
                    break;
                } 
                case 2: {
                    int temp = nums[mid]; 
                    nums[mid] = nums[high]; 
                    nums[high] = temp; 
                    high--; 
                    break;
                }
            }
        }
    }
}
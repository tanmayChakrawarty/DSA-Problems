/* 

1. Brute Force

Finding all possible permutations. 

Approach :

Step 1: Find all possible permutations of elements present and store them.

Step 2: Search input from all possible permutations.

Step 3: Print the next permutation present right after it.

Time Complexity:- O(N!xN)
Space Complexity:- O(1)

*/

/*

2. C++ built in next_permutaion function.

*/

/*

3. Find incresing sequence

There will always be an increasing sequence of all possible permutations when observed.

{1,2,3} -> {1,3,2} -> {2,1,3} -> {2,3,1} -> {3,1,2} -> {3,2,1}
----------------- Increasing ---------------------------------->

*/

class Solution {
    public void nextPermutation(int[] a) {
        //if a is null or size == 1;
        if(a == null || a.length <= 1) {
            return;
        }

        //take a pointer at second last element of array
        int i = a.length-2;

        // decrease the pointer till ith element become strictly less than (i+1)th element.
        while(i >= 0 && a[i] >= a[i+1]) {
            i--;
        }

        if(i >= 0) {
            // take second pointer and point it to last element of array.
            int j = a.length - 1;

            // decrease the jth pointer till jth element become strictly greater than ith element
            while(a[j] <= a[i]) {
                j--;
            }

            // swap the ith and jth element
            swap(a, i, j);
        }

        // reverse the array from i+1 th element till end
        reverse(a, i+1, a.length-1);
    }

    // swap method
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // reverse method
    private void reverse(int[] a, int i, int j) {
        while(i < j) {
            swap(a, i++, j--);
        }
    }
}

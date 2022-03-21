/*

When you see the image above, you get a pretty good idea of what you are supposed to do here. 
Think about the image as a matrix now where each line is basically a row in the matrix. 
So, first things first, if you are at the edge of the matrix, the value is 1, that’s for sure. 
Now, what about the inner elements? Well, any inner element is obtained by doing the sum of the 2 values 
present in the row just above it, i.e., 
if the element is at index (i, j), then matrix[i][j] can be obtained by doing 
matrix[i – 1][j – 1] + matrix[i – 1][j].

Time Complexity:- O(numRows^2)
Space Complexity:- O(numRows^2)

*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int dp[][] = new int[numRows][numRows];
        for(int i=0 ; i<numRows ; i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0 ; j<=i ; j++){
                if(j==0 || i==j){
                    dp[i][j] = 1;
                    sub.add(dp[i][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    sub.add(dp[i][j]);
                }
            }
            list.add(sub);
        }
        return list;
    }
}
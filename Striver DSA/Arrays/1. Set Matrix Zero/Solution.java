/* 

1. Brute Force Solution

Traverse through the matrix and if you find an element with value 0, then change all the elements in its row and column to -1, 
except when an element is 0. The reason for not changing other elements to 0, but -1, is because that might affect other columns and rows. 
Now traverse through the matrix again and if an element is -1 change it to 0, which will be the answer.

Time Complexity:- O((N*M)*(N + M))
Space Complexity:- O(1)

*/

class Solution {
    public void setMatrixZero(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // start traversing
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                
                int idx = i - 1;
                while(i >= 0) {
                    if(matrix[idx][j] != 0) {
                        matrix[idx][j] = -1;
                    }
                    idx--;
                }

                idx = i + 1;
                while(i < rows) {
                    if(matrix[idx][j] != 0) {
                        matrix[idx][j] = -1;
                    }
                    idx++;
                }

                idx = j - 1;
                while(idx >= 0) {
                    if(matrix[i][idx] != 0) {
                        matrix[i][idx] = -1;
                    }
                    idx--;
                }

                idx = j + 1;
                while(idx < cols) {
                    if(matrix[i][idx] != 0) {
                        matrix[i][idx] = -1;
                    }
                    idx++;
                }
            }
        }

        // set the matrix
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                if(matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*

2. Better Soluion

Take two dummy array one of size of row and other of size of column.Now traverse through the array.
If matrix[i][j]==0 then set dummy1[i]=0(for row) and dummy2[j]=0(for column).
Now traverse through the array again and if dummy1[i]==0  || dummy2[j]==0 then matrix[i][j]=0, else continue.

Time Complexity:- O(N*M + N*M)
Space Complexity:- O(N)

*/

class Soluion {
    public void setMatrixZero(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dummy_row = new int[rows];
        Arrays.fill(dummy_row, -1); 

        int[] dummy_col = new int[cols];
        Arrays.fill(dummy_col, -1);

        // start traversing
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                if(matrix[i][j] == 0) {
                    dummy_row[i] = 0;
                    dummy_col[j] = 0;
                }
            }
        }

        // set the matrix
        for(int i=0 ; i<rows ; i++) {
            for(int j=0 ; j<cols ; j++) {
                if(dummy_row[i] == 0 || dummy_col[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/* 

3. Optimized solution of above solution

Instead of taking two separate dummy array,take first row and column of the matrix as the array for checking whether the particular column or row has the value 0 or not.
Since matrix[0][0] are overlapping.Therefore take separate variable col0(say) to check if the 0th column has 0 or not and use matrix[0][0] to check if the 0th row has 0 or not.
Now traverse from last element to the first element and check if matrix[i][0]==0 || matrix[0][j]==0 and if true set matrix[i][j]=0,else continue.

Time Complexity:- O(2*(N*M))
Space Complexity:- O(1)

*/

class Soluion {
    public void setMatrixZero(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col_0 = 1;

        for(int i=0 ; i<rows ; i++) {

            // check matrix[0][0] = 0 or not
            // if zero then set col_0 = 0;
            if(matrix[i][0] == 0) {
                col_0 = 0;
            }

            for(int j=0 ; j<cols ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }

            // as first row and column is used instead of dummy arrays so 
            // we start traversing from end or reverse way.

            for(int i=rows-1 ; i>=0 ; i--) {
                for(int j=cols-1 ; j>=1 ; j--) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                if(col_0 == 0) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
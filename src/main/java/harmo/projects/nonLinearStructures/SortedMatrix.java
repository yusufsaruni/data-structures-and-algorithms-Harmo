package harmo.projects.nonLinearStructures;

public class SortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        search(matrix, matrix.length, 100);
        spiralPrint(matrix, 4, 4);
    }

    public static void spiralPrint(int[][] matrix, int row, int col) {
        int i, r=0, c = 0;
        while(r < row && c < col) {
            //Printing left to right, keeping r(row) constant.
            for(i = c; i < col; i++) {
                System.out.print(matrix[r][i] + " ");
            }
            r++;// going to the next row.
            //Printing from Top to Bottom, keeping c(column) constant.
            for(i = r; i < row; i++){
                //getting the last column index(col - 1)
                System.out.print(matrix[i][col - 1] + " ");
            }
            col --;

            //right to left.
            if(r < row){
                for(i = col - 1; i >= c; i--){
                    System.out.print(matrix[row - 1][i] + " ");
                }
                row --;
            }
            //Bottom to top
            if(c < col){
                for(i = row - 1; i >= r; i--){
                    System.out.print(matrix[i][c] + " ");
                }
                c++;
            }
        }
    }

    public static void search(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n -1;
        while(i < n && j >= 0) {
            if(matrix[i][j] == x) {
                System.out.println("X found at [" + i+","+j+"]");
                return;
            }
            if(matrix[i][j] > x) {
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Value not found");
    }
}

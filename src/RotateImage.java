import java.util.*;

public class RotateImage {

    public void rotate(int[][] matrix) {
        printArray(matrix);
        for(int i = 0, j = matrix.length; i <= j ; i++, j-- ){
            int from = i;
            int to = j;
            List<Integer> perimeter = buildPerimeter(matrix, from, to);

            for(int k = 1; k < (to - from); k++){
                perimeter = advanceList(perimeter);
            }
            matrix = replacePerimeter(matrix, perimeter, from , to);
        }
        printArray(matrix);

    }

    private List<Integer> buildPerimeter(int[][] matrix, int from, int to) {

        List<Integer> perimeter = new ArrayList<Integer>();

        perimeter.addAll(getFirstSide(matrix, from, to));
        perimeter.addAll(getSecondSide(matrix, from, to));
        perimeter.addAll(getThirdSide(matrix, from, to));
        perimeter.addAll(getFourthSide(matrix, from, to));


        return perimeter;
    }

    private int[][] replacePerimeter(int[][] matrix, List<Integer> perimeter, int from , int to) {
        Queue<Integer> queue = new LinkedList<Integer>(perimeter);

        for(int i = from; i < to; i++){
            matrix[from][i] = queue.poll();
        }
        for(int i = from + 1; i < to; i++){
            matrix[i][to-1] = queue.poll();
        }
        for(int i = to - 1; i > from && queue.size() > 0; i--){
            matrix[to - 1][i - 1] = queue.poll();
        }
        for(int i = to - 2; i > from && queue.size() > 0; i--){
            matrix[i][from] = queue.poll();
        }

        return matrix;
    }

    private List<Integer> advanceList(List<Integer> originalList){
        Integer[] rotatedList = new Integer[originalList.size()];
        for (int i = 0; i < originalList.size() - 1; i++) {
            rotatedList[i+1] = originalList.get(i);
        }
        rotatedList[0] = originalList.get(originalList.size() -1);
        return Arrays.asList(rotatedList);

    }
    private List<Integer> getFirstSide(int[][] matrix, int from, int to) {

        List<Integer> side = new ArrayList<Integer>();
        for(int i = from; i<to; i++ ){
            side.add(matrix[from][i]);
        }

        return side;
    }

    private List<Integer> getSecondSide(int[][] matrix, int from, int to) {

        List<Integer> side = new ArrayList<Integer>();
        for(int i = from + 1; i < to; i++ ){
            side.add(matrix[i][to - 1]);
        }

        return side;
    }

    private List<Integer> getThirdSide(int[][] matrix, int from, int to) {

        List<Integer> side = new ArrayList<Integer>();
        for(int i = to - 2; i >= from; i-- ){
            side.add(matrix[to - 1][i]);
        }

        return side;
    }

    private List<Integer> getFourthSide(int[][] matrix, int from, int to) {

        List<Integer> side = new ArrayList<Integer>();
        for(int i = to  - 2; i > from; i-- ){
            side.add(matrix[i][from]);
        }

        return side;
    }


    private void printArray(int[][] matrix) {
        System.out.println("====================================================");
        System.out.println(Arrays.deepToString(matrix).replace(" [","\n ["));
    }


    public static void main(String[] args) {

        int array[][] = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int array4[][] = new int[][]{
                {1,2},
                {7,8}
        };

        int array1[][] = new int[][]{
                {1}
        };
        int array2[][] = new int[][]{
                {1,2,3,-1},
                {4,5,6,-2},
                {7,8,9,-3},
                {-4,-5,-6,-7}
        };
        int array3[][] = new int[][]{
                {1,2,3,-1,5},
                {4,5,6,-2,9},
                {7,8,9,-3,1},
                {-4,-5,-6,-7,5},
                {-24,-45,-16,-71,50}
        };
        new RotateImage().rotate(array4);
    }
}

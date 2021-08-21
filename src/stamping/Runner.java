package stamping;

public class Runner {

    public static void main(String[]args){
        Stamp stamp = new Stamp();

        char[][] matrix = new char[][]{{'#', '#', '*', '*'}, {'#', '*', '*', '*'}, {'#', '*', '*', '*'}, {'#', '*', '*', '*'}};
        System.out.println(stamp.canBeStamped(matrix,1,3));
    }
}

package stamping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stamp {


    public Boolean canBeStamped(char [][]matrix, int stampLength, int stampWidth){
        int matrixLength= matrix.length;
        if(matrixLength==0)return false;
        int matrixWidth= matrix[0].length;
        int [][]consecutiveEmptyCells = new int[matrixLength+1][matrixWidth+1];

        for(int i=1;i<=matrixLength;i++){
            for(int j=1;j<=matrixWidth;j++){
                if(matrix[i-1][j-1]=='*'){
                    consecutiveEmptyCells[i][j]=consecutiveEmptyCells[i][j-1]+1;
                }else{
                    consecutiveEmptyCells[i][j]=0;
                }
            }
        }


       List<List<Integer>>canBeStamped = new ArrayList<>();

        for(int i=stampLength-1;i<matrixLength;i++){
            for(int j=stampWidth-1;j<matrixWidth;j++){
                int k=i;
                for(;k>i-stampLength;k--){
                    if(consecutiveEmptyCells[k+1][j+1]<stampWidth){
                        break;
                    }
                }
                if(k==i-stampLength){
                   canBeStamped.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        for(List<Integer>pair: canBeStamped){
            int m=pair.get(0);
            int n=pair.get(1);
            for(int i=m+1-stampLength;i<=m;i++){
                for(int j=n+1-stampWidth;j<=n;j++){
                    matrix[i][j]='#';
                }
            }
        }


        for (char[] chars : matrix) {
            for (int j = 0; j < matrixWidth; j++) {
                if (chars[j] == '*') return false;
            }
        }

        return true;
    }
}

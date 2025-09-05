package example.corejava.perci2;

import java.util.ArrayList;
import java.util.Collections;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1}
        };

        int count = 0;
        for(int i=0; i < arr.length; i++) {
            for(int j=0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
                System.out.println("====print i and j :" + arr[i][j]);
            }
        }
        System.out.println("count ==="+ count);
    }
}

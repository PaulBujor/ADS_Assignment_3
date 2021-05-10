import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueensTest {
    private int[][] testArray;
    private Queens queens;

    @BeforeEach
    void setup(){
        testArray = new int[4][4];
        queens = new Queens(5);
    }

    @AfterEach
    void tearDown(){
        testArray = null;
    }

    private int[][] buildBoard(){
        testArray = new int [][]{{1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0}};
        return testArray;
    }

    @Test
    void checkBoard(){
        queens.calculate();
        System.out.println(queens);
        assertTrue(Arrays.deepEquals(buildBoard(), queens.calculate()));
        printBoard(queens.calculate());
    }


    void printBoard(int array[][]){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}

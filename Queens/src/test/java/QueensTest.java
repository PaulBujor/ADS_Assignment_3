import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class QueensTest {
    private int[][] testArray;

    @BeforeEach
    void setup(){
        testArray = new int[3][3];
    }

    @AfterEach
    void tearDown(){
        testArray = null;
    }
    
    void printBoard(){
        for(int i = 0; i < testArray.length; i++){
            for (int j = 0; j < testArray.length; j++) {
                System.out.println(testArray[i][j]);
            }
        }
    }
}

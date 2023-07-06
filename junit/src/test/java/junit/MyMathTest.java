package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath math = new MyMath();
    @Test
    void calculateSum_SixMemberArray(){
        int expectedResult = 20;
        assertEquals(expectedResult, math.calculateSum(new int[]{1,2,3,4,5,5}));
    }
    @Test
    void calculateSum_EmptyArray(){
        int expectedResult = 0;
        assertEquals(expectedResult, math.calculateSum(new int[]{}));
    }
}
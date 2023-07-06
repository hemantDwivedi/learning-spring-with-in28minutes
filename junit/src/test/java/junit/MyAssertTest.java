package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {


    List<String> todos = Arrays.asList("aws", "spring", "devops");
    @Test
    void test(){
        boolean test = todos.contains("devops");
        assertTrue(todos.contains("spring"));
        assertTrue(test);
        assertEquals(3, todos.size());

        assertArrayEquals(new int[] {1,2}, new int[] {1,2});
    }
}
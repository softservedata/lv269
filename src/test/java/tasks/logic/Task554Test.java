package tasks.logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test logic task 554.
 */
public class Task554Test {
    @Test
    public void calc() throws Exception {
        Task554 task554 = new Task554();
        ArrayObject obj = new ArrayObject(4, 3, 5);
        ArrayObject obj2 = new ArrayObject(8, 6, 10);

        assertEquals(obj, task554.calc(10).get(0));
        assertEquals(obj2, task554.calc(10).get(1));
    }

    @Test
    public void calcNotPossible() throws Exception {
        Task554 task554 = new Task554();
        assertTrue(task554.calc(4).size() == 0);
    }
}
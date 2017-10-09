package tasks.logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test logic task 331.
 */
public class Task331Test {
    @Test
    public void calc() throws Exception {
        Task331 task331 = new Task331();
        ArrayObject obj = new ArrayObject(4, 2, 2);
        assertEquals(obj, task331.calc(24).get(0));
    }

    @Test
    public void calcNotPossible() throws Exception {
        Task331 task331 = new Task331();
        assertTrue(task331.calc(15).size() == 0);
    }
}
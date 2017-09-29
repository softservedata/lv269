package tasks.logic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test logic task 108.
 */
public class Task108Test {
    @Test
    public void calc() {
        Task108 task108 = new Task108();
        assertEquals(4, task108.calc(3));
    }

}
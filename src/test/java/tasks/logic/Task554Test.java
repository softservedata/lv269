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
        Integer[] mas = new Integer[]{4, 3, 5};
        Integer[] mas2 = new Integer[]{8, 6, 10};
        List<Integer[]> arr = new ArrayList<Integer[]>();
        arr.add(mas);
        arr.add(mas2);
        assertArrayEquals(arr.get(0), task554.calc(10).get(0));
        assertArrayEquals(arr.get(1), task554.calc(10).get(1));
    }

    @Test
    public void calcNotPossible() throws Exception {
        Task554 task554 = new Task554();
        assertTrue(task554.calc(4).size() == 0);
    }
}
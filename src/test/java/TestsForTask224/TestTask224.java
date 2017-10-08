package TestsForTask224;

import Task224.Models.Task224;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class TestTask224 {

    @Test
    public void testNumberOperation() {
        Task224 task224 = new Task224();
        List<Integer> actual = task224.numberOperation(50);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        expected.add(10);
        expected.add(25);
        expected.add(50);

        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected= new ArrayList<Integer>();
        actual=task224.numberOperation(0);
        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected = new ArrayList<Integer>();
        actual = task224.numberOperation(-2);
        assertArrayEquals(new List[]{actual}, new List[]{expected});


    }

}

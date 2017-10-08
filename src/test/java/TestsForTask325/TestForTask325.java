package TestsForTask325;

import Task325.Models.Task325;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class TestForTask325 {

    @Test
    public void testNumberOperation() {
        Task325 task224 = new Task325();
        List<Integer> actual = task224.numberOperation(30);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(3);
        expected.add(5);

        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected = new ArrayList<Integer>();
        actual = task224.numberOperation(0);
        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected = new ArrayList<Integer>();
        actual = task224.numberOperation(-2);
        assertArrayEquals(new List[]{actual}, new List[]{expected});


    }

}

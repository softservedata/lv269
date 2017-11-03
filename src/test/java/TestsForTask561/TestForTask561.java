package TestsForTask561;

import Task561.Models.Task561;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestForTask561 {

    @Test
    public void testReturnLastTwoNumbers() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Task561 task224 = new Task561();
        Method method = task224.getClass().getDeclaredMethod("returnLastTwoNumbers", Integer.class);
        method.setAccessible(true);
        Integer actual = (Integer) method.invoke(task224, 25);
        Integer act = actual;
        Integer expected = 25;
        assertEquals(actual,expected);

        actual = (Integer) method.invoke(task224, 6);
        act = actual;
        expected = 6;
        assertEquals(actual,expected);

        actual = (Integer) method.invoke(task224, 7);
        act = actual;
        expected = 9;
        assertEquals(actual,expected);
        actual = (Integer) method.invoke(task224, -8);
        act = actual;
        expected = -1;
        assertEquals(actual,expected);

    }

    @Test
    public void testNumberOperation() {
        Task561 task224 = new Task561();
        List<Integer> actual = task224.numberOperation(30);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(25);

        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected = new ArrayList<Integer>();
        expected.add(0);
        actual = task224.numberOperation(0);

        assertArrayEquals(new List[]{actual}, new List[]{expected});

        expected = new ArrayList<Integer>();
        actual = task224.numberOperation(-2);
        assertArrayEquals(new List[]{actual}, new List[]{expected});


    }

}

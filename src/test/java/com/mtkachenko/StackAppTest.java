package com.mtkachenko;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackAppTest {
    @Test
    public void creationViaConstructorWithSize () {
        StackApp stackApp = new StackApp(2);
        assertEquals(2, stackApp.getSize());
    }
    @Test
    public void isEmptyArrayCheck () {
        StackApp stackApp = new StackApp(1);
        assertTrue(stackApp.isEmpty());
    }
    @Test
    public void pushWithNewElementsTypeString () {

        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        List<Object> arr2 = new ArrayList<>();
        for (Object ff:s.getArray()){
            arr2.add(ff);
        }
        System.out.println();
        for (Object ff2: arr2){
            System.out.println(ff2);
        }

        List<Object> actual = new ArrayList<>();
        actual.add("Привет");
        actual.add(10);
        actual.add('h');

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(arr2, actual);
    }
    @Test
    public void popWithNewElementsDifferentTypes () {
        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        assertEquals('h', s.pop());
    }
    @Test
    public void popWithoutElements () {
        StackApp s = new StackApp(3);
        assertEquals(null, s.pop());
    }
    @Test
    public void pickWithNewElementsDifferentTypes () {
        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        assertEquals('h', s.pick());
    }
    @Test
    public void pickWithoutElements () {
        StackApp s = new StackApp(3);
        assertEquals(null, s.pick());
    }
    @Test
    public void testEqualsTrue () {
        StackApp s = new StackApp(2);
        s.push("Привет");
        s.push(10);
        StackApp p = new StackApp(2);
        p.push("Привет");
        p.push(10);
        assertTrue(s.equals(p));
    }
    @Test
    public void testHashcode () {
        StackApp s = new StackApp(1);
        s.push("Привет");
        int result = s.hashCode();
        assertEquals(1177014983, result);
    }
    @Test
    public void toStringWithNewElements () {
        StackApp s = new StackApp(1);
        s.push("Привет");
        assertEquals("StackApp{array=[Привет]}", s.toString());
    }
    @Test
    public void getSize() {
        StackApp s = new StackApp(1);
        s.push("Привет");
        assertEquals(1, s.getSize());
    }
    @Test
    public void getTop() {
        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        assertEquals(2, s.getTop());
    }
}




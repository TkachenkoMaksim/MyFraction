package com.mtkachenko;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListAppTest {

    @Test
    public void addLast () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addLast("abc");
        List<String> arr = new ArrayList<>();
        for (String f : sl){
            System.out.println(f);
        }
        for (String ff:sl){
            arr.add(ff);
        }
        List<String> actual = new ArrayList<>();
        actual.add("abc");
        Assert.assertEquals(arr, actual);
    }

    @Test
    public void addFirst () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("cd");
        List<String> arr = new ArrayList<>();
        for (String f : sl){
            System.out.println(f);
        }
        for (String ff:sl){
            arr.add(ff);
        }
        List<String> actual = new ArrayList<>();
        actual.add("cd");
        Assert.assertEquals(arr, actual);
    }

    @Test
    public void descendingIterator () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("cdc");
        sl.addFirst("cd");
        sl.addFirst("d");
        List<String> arr = new ArrayList<>();
        Iterator iterator = sl.descendingIterator();
        while (iterator.hasNext()){
            arr.add((String) iterator.next());
        }
        List<String> actual = new ArrayList<>();
        actual.add("cdc");
        actual.add("cd");
        actual.add("d");
        Assert.assertEquals(arr, actual);
    }

    @Test
    public void iterator () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addLast("d");
        sl.addLast("cd");
        sl.addLast("cdc");
        List<String> arr = new ArrayList<>();
        Iterator it = sl.iterator();
        while (it.hasNext()){
            arr.add((String) it.next());
        }
        List<String> actual = new ArrayList<>();
        actual.add("d");
        actual.add("cd");
        actual.add("cdc");
        Assert.assertEquals(arr, actual);
    }

    @Test
    public void getElementByIndex () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dfg");
        sl.addFirst("cd");
        assertEquals("hgfg", sl.getElementByIndex(2));
    }

    @Test
    public void getSize () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dfg");
        sl.addFirst("cd");
        assertEquals(3, sl.size());
    }

    @Test
    public void hashCodeWithNonEmptyCollection () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dfg");
        sl.addFirst("cd");
        assertEquals(3303139, sl.hashCode());
    }

    @Test
    public void hashCodeWithEmptyCollection () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        assertEquals(0, sl.hashCode());
    }

    @Test
    public void equalsWithTheSameCollections () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dfg");
        sl.addFirst("cd");
        LinkedListApp<String> s2 = new LinkedListApp<>();
        s2.addFirst("hgfg");
        s2.addFirst("dfg");
        s2.addFirst("cd");
        assertTrue(sl.equals(s2));
    }

    @Test
    public void equalsWithTheDifferentCollections () {
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dg");
        sl.addFirst("cd");
        LinkedListApp<String> s2 = new LinkedListApp<>();
        s2.addFirst("hgfg");
        s2.addFirst("dfg");
        s2.addFirst("cd");
        assertFalse(sl.equals(s2));
    }

    @Test
    public void testToString () {
        LinkedListApp<String> stringLinked1 = new LinkedListApp<>();
        stringLinked1.addFirst("abc");
        stringLinked1.addFirst("bdc");
        stringLinked1.addFirst("hgfg");
        stringLinked1.addFirst("dfg");
        stringLinked1.addFirst("cd");
        stringLinked1.addFirst("abc");
        stringLinked1.addFirst("bdc");
        stringLinked1.addFirst("abc");
        stringLinked1.addFirst("bdc");
        assertEquals(" bdc abc bdc abc cd dfg hgfg bdc abc ",stringLinked1.toString());
    }
}

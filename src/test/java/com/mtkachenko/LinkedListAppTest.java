package com.mtkachenko;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

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
}

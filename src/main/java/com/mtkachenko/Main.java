package com.mtkachenko;


public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3,5);
        Fraction f2 = new Fraction(3,8);
        System.out.println(f1.equals(f2));
        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        System.out.println(s.getArray());
        LinkedListApp<String> stringLinked = new LinkedListApp<>();
        stringLinked.addLast("abc");
        stringLinked.addLast("de");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(1));
        stringLinked.addFirst("abc");
        stringLinked.addFirst("de");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(1));
        stringLinked.addLast("abc");
        stringLinked.addLast("de");
        stringLinked.addLast("hpo");
        stringLinked.addLast("dre4");
        for (String f : stringLinked){
            System.out.println(f);
        }
        System.out.println();
        LinkedListApp<String> sl = new LinkedListApp<>();
        sl.addFirst("hgfg");
        sl.addFirst("dfg");
        sl.addFirst("cd");
        System.out.println(sl.hashCode());
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
        System.out.println(stringLinked1.hashCode());
        System.out.println(stringLinked1.toString());

    }
}

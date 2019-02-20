package com.mtkachenko;


public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3,5);
        Fraction f2 = new Fraction(3,8);
        //System.out.println(f1.equals(f2));
        StackApp s = new StackApp(3);
        s.push("Привет");
        s.push(10);
        s.push('h');
        System.out.println(s.getArray());











    }
}

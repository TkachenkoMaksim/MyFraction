package com.mtkachenko;

public class Fraction implements Comparable{
    private int numerator;
    private int  denominator;
    // в классе должно быть 2 конструктора
    public Fraction(int numerator, int denominator) {//один из которых должен принимать numerator(числитель) и denominator (знаменатель)
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) {throw new ArithmeticException();}/* проверка что числитель не равен нулю, при равенстве вызывается
         исключение*/
    }
    public Fraction(int numerator) { // а другой только числитель.
        this.numerator = numerator;
        this.denominator = 1;
    }
    // В классе должны быть реализованы методы: add
    public Fraction add(Fraction f){
        int numeratorFin = this.numerator*f.denominator + f.numerator*this.denominator;
        int denominatorFin = this.denominator*f.denominator;
        return new Fraction(numeratorFin, denominatorFin);
    }
    // и multiply,которые принимают один аргумент и возвращают новый объект
    //(ни один из объектов участвующих в операциях сложения и умножения изменен не должен быть)
    public Fraction multiply(Fraction f){
        int numeratorFin = this.numerator*f.numerator;
        int denominatorFin = this.denominator*f.denominator;
        return new Fraction(numeratorFin, denominatorFin);
    }
    // По мимо этого класс должен реализовывать методы toString,
    @Override
    public String toString() {
        if(numerator == 0 || denominator == 1)
            return String.valueOf(numerator); // для чисел со знаменателем == 1 (должно выводиться целое число)

        return numerator + "/" + denominator; // для чисел со знаменателем =/= 1 (должно выводиться два числа через "/")
    }
    @Override
    public int hashCode() {
        if(numerator == 0){
            return 0;
        }
        int result = numerator;
        result = 1000 * result + denominator;
        return result;
    }
    @Override
    public boolean equals(Object o) {
        //if (!(o instanceof Fraction))
            //return false;

        Fraction f = (Fraction) o;
        double x = numerator/denominator;
        double y = f.numerator/f.denominator;
        if (x == y) {return true;}
        else {return false;}
    }
    // и он должен наследовать интерфейс Comparable
    @Override
    public int compareTo(Object o) {
        Fraction f = (Fraction) o;
        if (denominator == f.denominator){ // сравнение, когда знаменатели двух дробей равны
            return numerator - f.numerator;
        }
        int compareNumerator = numerator * f.denominator; // сравнение, когда знаменатели двух дробей не равны
        int fNumerator = f.numerator * denominator;
        return compareNumerator - fNumerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
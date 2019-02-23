package com.mtkachenko;

public class Fraction implements Comparable<Fraction> {
    private final int numerator;
    private final int  denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction add(Fraction f){
        if (denominator == 0){
            throw new ArithmeticException("denominator should not be zero");
        }
        int numeratorFin = this.numerator * f.denominator + f.numerator * this.denominator;
        int denominatorFin = this.denominator * f.denominator;
        return new Fraction(numeratorFin, denominatorFin);
    }

    public Fraction multiply(Fraction f){
        if (denominator == 0){
            throw new ArithmeticException("denominator should not be zero");
        }
        int numeratorFin = this.numerator * f.numerator;
        int denominatorFin = this.denominator * f.denominator;
        return new Fraction(numeratorFin, denominatorFin);
    }

    @Override
    public String toString() {
        if (numerator == 0 || denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        if (numerator == 0) {
            return 0;
        }
        int result = numerator;
        result = 1000 * result + denominator;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        Fraction f = (Fraction) o;
        double x = numerator / denominator;
        double y = f.numerator / f.denominator;
        if (x == y) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Fraction o) {
        if (denominator == o.denominator){
            return numerator - o.numerator;
        }
        int compareNumerator = numerator * o.denominator;
        int fNumerator = o.numerator * denominator;
        return compareNumerator - fNumerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
package com.mtkachenko;


public class Fraction implements Comparable<Fraction> {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            if(denominator == 0){
                throw new ArithmeticException();
            }
        }

        public Fraction(int numerator) {
            this.numerator = numerator;
            denominator = 1;
        }

        public Fraction add(Fraction fraction){
            if(denominator == fraction.getDenominator()) {
                int newNumerator = numerator + fraction.getNumerator();
                return Fraction.reduction(newNumerator, denominator);
            }
            int newNumerator = numerator * fraction.getDenominator() + fraction.getNumerator() * denominator;
            int newDenominator = denominator * fraction.getDenominator();
            return Fraction.reduction(newNumerator, newDenominator);
        }


        public Fraction multiply(Fraction fraction){
            int newNumerator = numerator * fraction.getNumerator();
            int newDenominator = denominator * fraction.getDenominator();
            return Fraction.reduction(newNumerator, newDenominator);
        }

        public static int gcd(int a, int b){
            return (b == 0 ? a : gcd(b, a % b));
        }

        public static Fraction reduction(int n, int d){
            int gcd = Fraction.gcd(n, d);
            n /= gcd;
            d /= gcd;
            return new Fraction(n, d);
        }

        @Override
        public int compareTo(Fraction o) {
            if(denominator == o.getDenominator()) {
                return numerator - o.getNumerator();
            }
            int newCurrentNumerator = numerator * o.getDenominator();
            int newObjectNumerator = o.getNumerator() * denominator;
            return newCurrentNumerator - newObjectNumerator;
        }


        @Override
        public String toString() {
            if(denominator == 1 || numerator == 0)
                return String.valueOf(numerator);
            return numerator + "/" + denominator;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fraction fraction = (Fraction) o;

            if (numerator != fraction.numerator) return false;
            return denominator == fraction.denominator;
        }

        @Override
        public int hashCode() {
            if(numerator == 0){
                return 0;
            }
            int result = numerator;
            result = 31 * result + denominator;
            return result;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }


}



package com.mtkachenko;

import org.junit.Test;

import static org.junit.Assert.*;


public class FractionTest {

        @Test
            public void addWithoutDenominators () {
            Fraction fraction1 = new Fraction(2);
            Fraction fraction2 = new Fraction(5);
            Fraction result1 = fraction1.add(fraction2);
            Fraction result2 = fraction2.add(fraction1);
            assertEquals(result1.getNumerator(), result2.getNumerator());
            assertEquals(result1.getDenominator(), result2.getDenominator());
        }

        @Test
        public void addWithNullAndWithoutDenominators () {
            Fraction fraction1 = new Fraction(5);
            Fraction fraction2 = new Fraction(0);
            Fraction result = fraction1.add(fraction2);
            assertEquals(5, result.getNumerator());
        }

        @Test
        public void addWithTheSameDenominators () {
            Fraction fraction = new Fraction(3, 16);
            Fraction fraction2 = new Fraction(5, 16);
            Fraction result = fraction.add(fraction2);
            assertEquals(1, result.getNumerator());
            assertEquals(2, result.getDenominator());
        }

        @Test
        public void addWithTheSimpleValue () {
            Fraction fraction1 = new Fraction(3);
            Fraction fraction2 = new Fraction(4, 5);
            Fraction result = fraction1.add(fraction2);
            assertEquals(19, result.getNumerator());
            assertEquals(5, result.getDenominator());
        }

        @Test
        public void addWithTheDifferentDenominators () {
            Fraction fraction = new Fraction(3, 5);
            Fraction fraction2 = new Fraction(5, 4);
            Fraction fraction3 = fraction.add(fraction2);
            assertEquals(37, fraction3.getNumerator());
            assertEquals(20, fraction3.getDenominator());
        }

        @Test(expected = ArithmeticException.class)
        public void addWithNullDenominators () {
            Fraction fraction = new Fraction(3, 0);
            if (fraction.getDenominator() == 0){
                throw new ArithmeticException("denominator should not be zero");
            }
        }

        @Test(expected = ArithmeticException.class)
        public void multiplyWithNullDenominators () {
            Fraction fraction = new Fraction(3, 0);
            if (fraction.getDenominator() == 0){
                throw new ArithmeticException("denominator should not be zero");
            }
        }

        @Test
        public void creationViaConstructorWithoutDenominator () {
            Fraction fraction = new Fraction(4);
            assertEquals(4, fraction.getNumerator());
            assertEquals(1, fraction.getDenominator());
        }

        @Test
        public void multiplyWithoutDenominators () {
            Fraction fraction1 = new Fraction(2);
            Fraction fraction2 = new Fraction(5);
            Fraction result1 = fraction1.multiply(fraction2);
            Fraction result2 = fraction2.multiply(fraction1);
            assertEquals(result1.getNumerator(), result2.getNumerator());
            assertEquals(result1.getDenominator(), result2.getDenominator());
        }

        @Test
        public void multiplyWithNullAndWithoutDenominators () {
            Fraction fraction1 = new Fraction(5);
            Fraction fraction2 = new Fraction(0);
            Fraction result = fraction1.multiply(fraction2);
            assertEquals(0, result.getNumerator());
        }

        @Test
        public void multiplyWithTheSimpleValue () {
            Fraction fraction1 = new Fraction(3);
            Fraction fraction2 = new Fraction(4, 5);
            Fraction result = fraction1.multiply(fraction2);
            assertEquals(12, result.getNumerator());
            assertEquals(5, result.getDenominator());
        }
        @Test
        public void testReduction(){
            Fraction fraction = Fraction.reduction(15, 20);
            assertEquals(3, fraction.getNumerator());
            assertEquals(4, fraction.getDenominator());
        }

        @Test
        public void testReductionNoNeeded(){
            Fraction fraction = Fraction.reduction(19, 23);
            assertEquals(19, fraction.getNumerator());
            assertEquals(23, fraction.getDenominator());
        }

        @Test
        public void multiplyWithTheDifferentDenominators () {
            Fraction fraction = new Fraction(3, 1);
            Fraction fraction2 = new Fraction(4, 5);
            Fraction fraction3 = fraction.multiply(fraction2);
            assertEquals(12, fraction3.getNumerator());
            assertEquals(5, fraction3.getDenominator());
        }

        @Test
        public void testToString () {
            Fraction fraction = new Fraction(3, 5);
            assertEquals("3/5", fraction.toString());
        }

        @Test
        public void toStringNumeratorIsNull () {
            Fraction fraction = new Fraction(0, 3);
            assertEquals("0", fraction.toString());
        }

        @Test
        public void toStringWithoutDenominators () {
            Fraction fraction = new Fraction(3);
            assertEquals("3", fraction.toString());
        }

        @Test
        public void testHashcode () {
            Fraction fraction = new Fraction(3, 4);
            int result = fraction.hashCode();
            assertEquals(3004, result);
        }

        @Test
        public void hashcodeNullValue () {
            Fraction fraction = new Fraction(0, 6);
            int result = fraction.hashCode();
            assertEquals(0, result);
        }

        @Test
        public void testEqualsTrue () {
            Fraction fraction1 = new Fraction(3, 5);
            Fraction fraction2 = new Fraction(3, 5);
            assertTrue(fraction1.equals(fraction2));
        }

        @Test
        public void testEqualsTrueWithoutDenominators () {
            Fraction fraction1 = new Fraction(6);
            Fraction fraction2 = new Fraction(6);
            assertTrue(fraction1.equals(fraction2));
        }

        @Test
        public void testEqualsFalse () {
            Fraction fraction1 = new Fraction(13, 2);
            Fraction fraction2 = new Fraction(3, 4);
            assertFalse(fraction1.equals(fraction2));
        }

        @Test
        public void testEqualsFalseWithoutDenominators () {
            Fraction fraction1 = new Fraction(5);
            Fraction fraction2 = new Fraction(3);
            assertFalse(fraction1.equals(fraction2));
        }

        @Test
        public void compareToTheSameFractions () {
            Fraction fraction1 = new Fraction(4, 5);
            Fraction fraction2 = new Fraction(4, 5);
            assertEquals(0, fraction1.compareTo(fraction2));
            assertEquals(0, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheDifferentFractions () {
            Fraction fraction1 = new Fraction(1, 2);
            Fraction fraction2 = new Fraction(3, 4);
            assertEquals(-2, fraction1.compareTo(fraction2));
            assertEquals(2, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheSameSimpleValues () {
            Fraction fraction1 = new Fraction(4);
            Fraction fraction2 = new Fraction(4);
            assertEquals(0, fraction1.compareTo(fraction2));
            assertEquals(0, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheSameSimpleValueAndFraction () {
            Fraction fraction1 = new Fraction(4);
            Fraction fraction2 = new Fraction(4, 1);
            assertEquals(0, fraction1.compareTo(fraction2));
            assertEquals(0, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheDifferentFraction () {
            Fraction fraction1 = new Fraction(3, 5);
            Fraction fraction2 = new Fraction(4, 5);
            assertEquals(-1, fraction1.compareTo(fraction2));
            assertEquals(1, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheDifferentSimpleValues () {
            Fraction fraction1 = new Fraction(3);
            Fraction fraction2 = new Fraction(4);
            assertEquals(-1, fraction1.compareTo(fraction2));
            assertEquals(1, fraction2.compareTo(fraction1));
        }

        @Test
        public void compareToTheDifferentSimpleValueAndFraction () {
            Fraction fraction1 = new Fraction(3);
            Fraction fraction2 = new Fraction(4, 1);
            assertEquals(-1, fraction1.compareTo(fraction2));
            assertEquals(1, fraction2.compareTo(fraction1));
        }
}

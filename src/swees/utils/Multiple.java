package swees.utils;

import com.google.common.math.LongMath;

import java.util.*;

public class Multiple {

    public static long lcm(long a, long b) {
        return (a * b) / LongMath.gcd(a, b);
    }

    // Finds the least common denominator for a Double
    public static long findDenominator(double number) {
        final double EPSILON = 1E-9;
        long denominator = 1;
        while (Math.abs(number * denominator - Math.round(number * denominator)) > EPSILON) {
            denominator++;
        }
        return denominator;
    }

    // Computes the LCM of a list of Doubles as a real number
    public static double computeLCMOfDoubleList(List<Double> numbers) {
        List<Long> numerators = new ArrayList<>();
        List<Long> denominators = new ArrayList<>();
        for (double number : numbers) {
            long denom = findDenominator(number);
            denominators.add(denom);
            numerators.add(Math.round(number * denom));
        }
        long lcmNumerators = numerators.stream().reduce(1L, (a, b) -> lcm(a, b));
        long gcdDenominators = denominators.stream().reduce(denominators.get(0), (a, b) -> LongMath.gcd(a, b));
        return (double) lcmNumerators / gcdDenominators;
    }

    // Generates multiples of input values up to either their LCM or 10 times the largest input
    public static List<Double> generateMultiplesUpToLCM(List<Double> numbers) {
        double lcm = computeLCMOfDoubleList(numbers);
        double maxNumber = Collections.max(numbers);
        double limit = Math.min(lcm, maxNumber * 10);
        Set<Double> multiples = new TreeSet<>();
        for (double number : numbers) {
            for (double m = number; m <= limit + 1e-9; m += number) {
                // Round to avoid floating point precision issues
                multiples.add(Math.round(m * 1e9) / 1e9);
            }
        }
        return new ArrayList<>(multiples);
    }
}
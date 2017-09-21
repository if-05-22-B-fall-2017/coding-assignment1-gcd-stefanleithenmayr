package greatest.common.divider;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan Leithenmayr
 * @description The programm calculates the greatest common divisor, with two
 * different algorithms. The first algorithm is just a normal one, and the
 * second one is called the "eucledian algorithm".
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {

        System.out.println("Calculate greatest common divisor!\n");

        System.out.println("Example 1: Solved with normal Algorithm    : " + gcdPrimeFactors(10, 100));
        System.out.println("Example 1: Solved with Eucledian Algorithm : " + gcdEucledian(10, 100));
        System.out.println("\nExample 2: Solved with normal Algorithm    : " + gcdPrimeFactors(480, 1060));
        System.out.println("Example 2: Solved with Eucledian Algorithm : " + gcdEucledian(480, 1060));
        System.out.println("\nExample 3: Solved with normal Algorithm    : " + gcdPrimeFactors(2600, 24000));
        System.out.println("Example 3: Solved with Eucledian Algorithm : " + gcdEucledian(2600, 24000));
        System.out.println("\nExample 4: Solved with normal Algorithm    : " + gcdPrimeFactors(340, 3468));
        System.out.println("Example 4: Solved with Eucledian Algorithm : " + gcdEucledian(340, 3468));
        System.out.println("\nExample 5: Solved with normal Algorithm    : " + gcdPrimeFactors(147, 1540));
        System.out.println("Example 5: Solved with Eucledian Algorithm : " + gcdEucledian(147, 1540));
        System.out.println("\nExample 6: Solved with normal Algorithm    : " + gcdPrimeFactors(11571, 1767));
        System.out.println("Example 6: Solved with Eucledian Algorithm : " + gcdEucledian(11571, 1767));
        System.out.println("\nExample 7: Solved with normal Algorithm    : " + gcdPrimeFactors(378, 3468));
        System.out.println("Example 7: Solved with Eucledian Algorithm : " + gcdEucledian(378, 3468));
    }

    private static int gcdPrimeFactors(int a, int b) {

        List<Integer> dividers = new ArrayList<Integer>();
        int divider = 2, gcd = 1;

        while (a > 1) {
            if (a % divider == 0) {
                dividers.add(divider);
                a /= divider;
            } else {
                divider++;
            }
        }
        divider = 2;

        while (b > 1) {
            if (b % divider == 0) {
                int x = dividers.indexOf(divider);

                if (x != -1) {
                    gcd *= dividers.get(x);
                    dividers.remove(x);
                }
                b /= divider;
            } else {
                divider++;
            }
        }
        return gcd;
    }

    private static int gcdEucledian(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdEucledian(b, a % b);
    }
}

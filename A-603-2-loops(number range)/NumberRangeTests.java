public class NumberRangeTests {
    private long start;
    private long stop;

    public NumberRangeTests(long start, long stop) {
        this.start = start;
        this.stop = stop;
    }

    public static NumberRangeTests create(long start, long stop) {
        return new NumberRangeTests(start, stop);
    }

    public String toString() {
        return String.format("[%d, %d]", this.getStart(), this.getStop());
}

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public long size() {
        return stop - start + 1;
    }

    public boolean includes(long number) {
        return number >= start && number <= stop;
    }

    public NumberRangeTests intersection(NumberRangeTests otherRange) {
        long intersectionStart = Math.max(start, otherRange.getStart());
        long intersectionStop = Math.min(stop, otherRange.getStop());

        if (intersectionStart > intersectionStop) {
            return new NumberRangeTests(0, 0);
        } else {
            return new NumberRangeTests(intersectionStart, intersectionStop);
        }
    }

    public long evenCount() {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public long oddCount() {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public long countPrimes() {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public long countDivisibleBy(long factor1, long factor2, boolean mustBeBoth) {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (mustBeBoth) {
                if (i % factor1 == 0 && i % factor2 == 0) {
                    count++;
                }
            } else {
                if (i % factor1 == 0 || i % factor2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public long countFactorJKZs(long threshold) {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                count++;
            } else {
                long factorJKZ = calculateFactorJKZ(i);
                if (factorJKZ >= threshold) {
                    count++;
                }
            }
        }
        return count;
    }

    public long countFactorRatios(long threshold) {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                count++;
            } else {
                long factorCount = calculateFactorCount(i);
                long primeFactorCount = calculatePrimeFactorCount(i);
                double factorRatio = (double) factorCount / primeFactorCount;
                if (primeFactorCount == 0) {
                    count = -1;
                } else if (factorRatio >= threshold) {
                    count++;
                }
            }
        }
        return count;
    }

    public long countPalindromes() {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isPalindrome(i)) {
                count++;
            }
        }
        return count;
    }
public long countSquareAndCubeNumbers() {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isSquare(i) && isCube(i)) {
                count++;
            }
        }
        return count;
    }

    public long sumPrimes() {
        long sum = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public long largestPrimeGap() {
        long largestGap = 0;
        long previousPrime = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                if (previousPrime != 0 && i - previousPrime > largestGap) {
                    largestGap = i - previousPrime;
                }
                previousPrime = i;
            }
        }
        return largestGap;
    }

    public String largestPrimeGapPair() {
        long largestGap = largestPrimeGap();
        if (largestGap == 0) {
            return "0-0";
        } else {
            long previousPrime = 0;
            long prime1 = 0;
            long prime2 = 0;
            for (long i = start; i <= stop; i++) {
                if (isPrime(i)) {
                    if (previousPrime != 0 && i - previousPrime == largestGap) {
                        prime1 = previousPrime;
                        prime2 = i;
                        break;
                    }
                    previousPrime = i;
                }
            }
            return prime1 + "-" + prime2;
        }
    }

    public void shrink(long factor) {
        long newStop = start + (size() / factor);
        stop = Math.min(stop, newStop);
    }

    public long sumFactorJKZs() {
        long sum = 0;
        for (long i = start; i <= stop; i++) {
            sum += calculateFactorJKZ(i);
        }
        return sum;
    }

    public String getSummary() {
        return "Range: " + start + " to " + stop + "\n" +
                "Size: " + size() + "\n" +
                "Even Count: " + evenCount() + "\n" +
                "Odd Count: " + oddCount() + "\n" +
                "Prime Count: " + countPrimes() + "\n" +
                "Palindrome Count: " + countPalindromes() + "\n" +
                "Square and Cube Count: " + countSquareAndCubeNumbers() + "\n" +
                "Sum of Primes: " + sumPrimes() + "\n" +
                "Largest Prime Gap: " + largestPrimeGap() + "\n" +
                "Largest Prime Gap Pair: " + largestPrimeGapPair() + "\n" +
                "Sum of FactorJKZs: " + sumFactorJKZs();
    }
    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long calculateFactorJKZ(long number) {
        long factorJKZ = isEven(number) ? 2 : 1;
        factorJKZ += isDivisibleBy(number, 3) ? 3 : 0;
        factorJKZ += isDivisibleBy(number, 5) ? 5 : 0;
        factorJKZ = isSquare(number) ? factorJKZ * 2 : factorJKZ;
        factorJKZ = isCube(number) ? factorJKZ * 3 : factorJKZ;
        factorJKZ -= isPalindrome(number) ? 1 : 0;
        if (factorJKZ % number == 0) {
            factorJKZ *= 0;
        }
        return factorJKZ;
    }

    private long calculateFactorCount(long number) {
        long count = 0;
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

    private long calculatePrimeFactorCount(long number) {
        long count = 0;
        for (long i = 1; i <= number; i++) {
            if (number % i == 0 && isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(long number) {
        return number % 2 == 0;
    }

    private boolean isDivisibleBy(long number, long divisor) {
        return number % divisor == 0;
    }

    private boolean isSquare(long number) {
        long squareRoot = (long) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }

    private boolean isCube(long number) {
        long cubeRoot = (long) Math.cbrt(number);
        return cubeRoot * cubeRoot * cubeRoot == number;
    }

    private boolean isPalindrome(long number) {
        String numString = String.valueOf(number);
        int left = 0;
        int right = numString.length() - 1;
        while (left < right) {
            if (numString.charAt(left) != numString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

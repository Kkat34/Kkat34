public class NumberRange {

        private long start;
        private long stop;
        private int number;
    private long factorJKZ;
    private long value;
    private long other;
    private long factor;
    private String sep;
    private String summary;
 
      public NumberRange(long start, long stop) {
          this.start = start;
          this.stop = stop;
      }

/** static factory constructor */
public static NumberRange fromStartStop(long start, long stop) {
	return new NumberRange(start, stop);
}

public String toString() {
	return String.format("[%d, %d]", this.getStart(), this.getStop());
}

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public long size() {
        return stop - start + 1;
    }

    public boolean includes(long value) {
        return value >= start && value <= stop;
    }

    public NumberRange intersection(NumberRange other) {
        long newStart = Math.max(this.start, other.start);
        long newStop = Math.min(this.stop, other.stop);
        if (newStart > newStop) {
            return new NumberRange(0, 0);
        }
        return new NumberRange(newStart, newStop);
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

    public int countPrimes() {
        int count = 0;
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

private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long calculateFactorJKZ(long number) {
        if (isPrime(number)) {
            return number;
        } else {
            long factorJKZ = number % 2 == 0 ? 2 : 1;
            factorJKZ += number % 3 == 0 ? 3 : 0;
            factorJKZ += number % 5 == 0 ? 5 : 0;
            if (isSquare(number)) {
                factorJKZ *= 2;
            }
            if (isCube(number)) {
                factorJKZ *= 3;
            }
            if (isPalindrome(number)) {
                factorJKZ -= 1;
            }
            if (factorJKZ % number == 0) {
                factorJKZ *= 0;
            }
            return factorJKZ;
        }
    }
    private long calculateFactorCount(long num) {
        long count = 0;
        for (long i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    private long calculatePrimeFactorCount(long num) {
        long count = 0;
        for (long i = 1; i <= num; i++) {
            if (num % i == 0 && isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(long num) {
        return num % 2 == 0;
    }

    private boolean isDivisibleBy(long num, long factor) {
        return num % factor == 0;
    }

    private boolean isSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    private boolean isCube(long num) {
        long cbrt = (long) Math.cbrt(num);
        return cbrt * cbrt * cbrt == num;
    }

    private boolean isPalindrome(long num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

  public long countFactorRatios(long threshold) {
        long count = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                continue;
            }
            long factorCount = calculateFactorCount(i);
            long primeFactorCount = calculatePrimeFactorCount(i);
            double factorRatio = (double) factorCount / primeFactorCount;
            if (primeFactorCount == 0) {
                count = -1;
            } else if (factorRatio >= threshold) {
                count++;
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
        for (long num = start; num <= stop; num++) {
            if (isPrime(num)) {
                sum += num;
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
        long largestGap = 0;
        long previousPrime = 0;
        long prime1 = 0;
        long prime2 = 0;
        for (long i = start; i <= stop; i++) {
            if (isPrime(i)) {
                if (previousPrime != 0 && i - previousPrime > largestGap) {
                    largestGap = i - previousPrime;
                    prime1 = previousPrime;
                    prime2 = i;
                }
                previousPrime = i;
            }
        }
        if (largestGap == 0) {
            return "0-0";
        } else {
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
            sum += factorJKZ(i);
        }
        return sum;
    }

    private long factorJKZ(long num) {
        // Calculate factorJKZ for a number
        return num * num - 1;
    }

public String getSummary() {
	String summary = "";
	String sep = System.lineSeparator();
	summary += "Start: " + this.getStart() + sep;
	summary += "Stop: " + this.getStop() + sep;
	summary += "Prime Count: " + this.countPrimes() + sep;
	summary += "Odd Count: " + this.oddCount() + sep;
	summary += "Size: " + this.size() +sep;
        summary += "Includes: " + this.includes(this.value) + sep;
        summary += "Largest Prime Gap Pair: " + largestPrimeGapPair() + sep;
        summary += "Even Count: " + this.evenCount() + sep;
        summary += "Largest Prime Gap: " + largestPrimeGap() + sep;
	return summary;
 
	}
  

 }


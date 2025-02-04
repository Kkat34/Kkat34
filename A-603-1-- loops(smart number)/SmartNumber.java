public class SmartNumber {
         

         private long num;

         public SmartNumber(long aNum) {
                  this.num = aNum;
         }

         /** static factory constructor */
         
         public static SmartNumber from(long aNum) {
	          return new SmartNumber(aNum);
         }

         public boolean isEven() {
                   return num % 2 == 0;
         }

         public boolean isOdd() {
                   return num % 2 != 0;
         }

         public String toString() {
	           return "" + this.getNum();
         }

          public long getNum() {
                   return num;
         }

         public void setNum(long num) {
                   this.num = num;
         }

         public boolean isSquare() {
                  long sqrt = (long) Math.sqrt(num);
                  return sqrt * sqrt == num;
        }

          public long divideAndRound(long divisor) {
                   return Math.round((double) num / divisor);
         }

         public long roundedRatio(long divisor) {
                    return Math.round((double) num / divisor);
         }


         public boolean isCube() {
                    long cbrt = (long) Math.cbrt(num);
                    return cbrt * cbrt * cbrt == num;
         }

         public boolean isSquareAndCube() {
                    return isSquare() && isCube();
         }

         public boolean isDivisibleBy(long factor) {
                    if (factor > 10) {
                       return false;
            }
                    return num % factor == 0;
         }

         public long squared() {
                    return num * num;
         }

          public long cubed() {
                     return num * num * num;
         }

         public long remainder(long divisor) {
                     return num % divisor;
         }

public boolean isPrime() {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

         public boolean isComposite() {
                     return !isPrime() && num > 1;
        }

         public boolean isPalindrome() {
                      String numStr = Long.toString(num);
                      return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

public boolean isAmicablePairWith(long otherNum) {
    long sumDivisorsNum = calculateSumOfDivisors(num);
    long sumDivisorsOtherNum = calculateSumOfDivisors(otherNum);
    return sumDivisorsNum == otherNum && sumDivisorsOtherNum == num;
}

private long calculateSumOfDivisors(long number) {
    long sum = 0;
    for (long i = 1; i <= number / 2; i++) {
        if (number % i == 0) {
            sum += i;
        }
    }
    return sum;
}

public int factorCount() {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

public int primeFactorCount() {
        int count = 0;
        long temp = num;
        for (int i = 2; i <= temp; i++) {
            while (temp % i == 0) {
                count++;
                temp /= i;
            }
        }
        return count;
    }

    public long factorial() {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

public double factorRatio() {
        int factorCount = factorCount();
        int primeFactorCount = primeFactorCount();
        if (primeFactorCount == 0) {
            return -1;
        }
        return (double) factorCount / primeFactorCount;
    }

public long factorJKZ() {
        long factorJKZ = isPrime() ? num : (isEven() ? 2 : 1);
        factorJKZ += factorRatio();
        if (isDivisibleBy(3)) {
            factorJKZ += 3;
        }
        if (isDivisibleBy(5)) {
            factorJKZ += 5;
        }
        if (isSquare()) {
            factorJKZ *= 2;
        }
        if (isCube()) {
            factorJKZ *= 3;
        }
        if (isPalindrome()) {
            factorJKZ -= 1;
        }
        if (factorJKZ % num == 0) {
            factorJKZ *= 0;
        }
        return factorJKZ;
    }

public String getSummary() {
	String summary = "";
	String sep = System.lineSeparator();
	summary += "Number: " + this.getNum() + sep;
	summary += "Prime: " + this.isPrime();
	summary += "Factor Count: " + this.factorCount() + sep;
	summary += "Remainder(/10): " + this.remainder(10) + sep;
        summary += "Composite: " + this.isComposite() + sep;
        summary += "Cube: " + this.isCube() + sep;
        summary += "Square: " + this.isSquare() + sep;
        summary += "Squared: " + this.squared() + sep;
	//TODO
	return summary;
	}
}
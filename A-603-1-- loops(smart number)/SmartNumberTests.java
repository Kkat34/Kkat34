public class SmartNumberTests {
   
    public static void main(String[] args) {
       
        SmartNumber smartNumber = new SmartNumber(16);
        
        System.out.println("Is Even: " + smartNumber.isEven());
        System.out.println("Is Odd: " + smartNumber.isOdd());
        System.out.println("Is Square: " + smartNumber.isSquare());
        System.out.println("Is Cube: " + smartNumber.isCube());
        System.out.println("Is Square and Cube: " + smartNumber.isSquareAndCube());
        System.out.println("Is Divisible by 3: " + smartNumber.isDivisibleBy(3));
        System.out.println("Squared: " + smartNumber.squared());
        System.out.println("Cubed: " + smartNumber.cubed());
        System.out.println("Remainder when divided by 5: " + smartNumber.remainder(5));
        System.out.println("Rounded Ratio: " + smartNumber.roundedRatio(5));
        System.out.println("Is Prime: " + smartNumber.isPrime());
        System.out.println("Is Composite: " + smartNumber.isComposite());
        System.out.println("Is Palindrome: " + smartNumber.isPalindrome());
        System.out.println("Is Amicable Pair with 220: " + smartNumber.isAmicablePairWith(220));
        System.out.println("Factor Count: " + smartNumber.factorCount());
        System.out.println("Prime Factor Count: " + smartNumber.primeFactorCount());
        System.out.println("Factorial: " + smartNumber.factorial());
        System.out.println("Factor Ratio: " + smartNumber.factorRatio());
        System.out.println("Factor JKZ: " + smartNumber.factorJKZ());
        System.out.println("Summary: " + smartNumber.getSummary());
   }
}
	
	
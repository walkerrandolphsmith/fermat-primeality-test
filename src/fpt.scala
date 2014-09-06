import java.math.BigInteger
import java.util.Scanner
;

object fptRunner {

  def fermatTest(n: BigInteger, maxIterations: BigInteger): Boolean = {
    //refactor for k iterations
    var a = maxIterations;
    do{
      //refactor to randomly select a
      val r = a.modPow(maxIterations, n);
      if (!r.equals(BigInteger.ONE)) return false;
      a = a.subtract(BigInteger.ONE);
    }while (a.compareTo(BigInteger.ZERO) > 0)
    return true;
  }

  def main(args: Array[String]) {
    val scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      val theLine = scan.nextLine();
      if (!theLine.equals("")) {
        val scanner = new Scanner(theLine);
        while (scanner.hasNextBigInteger()) {
          val fermatPrime = scanner.nextBigInteger();

          if (fermatPrime.compareTo(BigInteger.ZERO) > 0) {
            val isPrime = fermatTest(fermatPrime, fermatPrime.subtract(BigInteger.ONE));
            if (isPrime) println("Likely Prime") else println("Composite");
          } else {
            println("Positive Integers only, ");
          }
        }
      }
    }
  }

}
import scala.util;
import java.math.BigInteger;

object fptRunner {

  def printHeader(): String = {
    var sb = new StringBuilder();

    sb.append("---------------     --------------      _______________\n");
    sb.append("---------------     ---------------     _______________\n");
    sb.append("---------------     ----       ----     _______________\n");
    sb.append("----                ----       ----          _____     \n");
    sb.append("----                ----       ----          _____     \n");
    sb.append("---------------     ---------------          _____     \n");
    sb.append("---------------     -------------            _____     \n");
    sb.append("---------------     -----------              _____     \n");
    sb.append("----                -----                    _____     \n");
    sb.append("----                -----                    _____     \n");
    sb.append("----                -----                    _____     \n");
    sb.append("----                -----                    _____     \n");
    sb.append("----                -----                    _____     \n");

    sb.append("             Fermat's Primealiy Test                   \n");
    return sb.toString();
  }

  def fermatTest(n:Int): Boolean = {

    var isPrime = false;

    val ZERO = BigInteger.valueOf(0);
    val ONE = BigInteger.valueOf(1);
    val TWO = BigInteger.valueOf(2);

    println("n = " + n);

    val k = 1 << n;	// 2^n
    println("2^n = "+ k);
    val fermat = ONE.shiftLeft(k).add(ONE);	// 2^k + 1
    println("fermat = " + fermat);
    val c = (1 << (n-1)) - 1;	// 2^(n-1) - 1
    println("2^(n-1) - 1 = " + c);
    var s = BigInteger.valueOf(8);
    println("s = " + s);
    var i = 0;
    for (i <- 0 to c) {
      // (s^4 - 4*s^2 + 2) mod fermat
      val b = s.modPow(TWO, fermat);
      println("b = " + b);
      s = b.pow(2).subtract(b.shiftLeft(2)).add(TWO);
      println("s = " + s);
    }
    s = s.mod(fermat);
    println("s:after = " + s);

    if (s.equals(ZERO)) isPrime = true; else isPrime = false;
    
    return isPrime;
  }

  def printResult(isPrime:Boolean): String = {
    var result = "";
    if(isPrime) result = "Likely Prime" else result = "Composite";
    return result;
  }

  def main(args: Array[String]) {
    println(printHeader());

    val time = System.currentTimeMillis();

    val isPrime = fermatTest(5);
    println(printResult(isPrime));

    println(System.currentTimeMillis() - time + " ms");


  }
}
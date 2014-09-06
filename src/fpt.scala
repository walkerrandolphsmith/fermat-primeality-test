import scala.util;
import java.math.BigInteger

import scala.util.Random
;

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

    sb.append("             Fermat's Primality Test                   \n");
    return sb.toString();
  }

  def fermatTest(n:BigInteger, maxIterations:BigInteger): Boolean = {

    //refactor for k iterations
    var a = maxIterations;

    while(a.compareTo(BigInteger.ZERO) > 0 && a != BigInteger.ONE) {
      //refactor to randomly select a
      a = a.subtract(BigInteger.ONE);
        val r = a.modPow(maxIterations, n);
        println("Iteration: " + a + " r = " + r);
        if (!r.equals(BigInteger.ONE)) return false;
    }
    return true;

  }

  def main(args: Array[String]) {
    println(printHeader());
    val sut = new BigInteger("31");
    val isPrime = fermatTest(sut, sut.subtract(BigInteger.ONE));

    if(isPrime)  println("Likely Prime") else println("Composite");


  }
}
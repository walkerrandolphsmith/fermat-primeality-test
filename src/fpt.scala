import java.math.BigInteger;

object fptRunner {

  def fermatTest(n: BigInteger, maxIterations: BigInteger): Boolean = {

    //refactor for k iterations
    var a = maxIterations;

    while (a.compareTo(BigInteger.ZERO) > 0 && a != BigInteger.ONE) {
      //refactor to randomly select a
      a = a.subtract(BigInteger.ONE);
      val r = a.modPow(maxIterations, n);
      println("Iteration: " + a + " r = " + r);
      if (!r.equals(BigInteger.ONE)) return false;
    }
    return true;
  }

  def main(args: Array[String]) {
    val sut = new BigInteger("31");
    val isPrime = fermatTest(sut, sut.subtract(BigInteger.ONE));

    if (isPrime) println("Likely Prime") else println("Composite");
  }
}
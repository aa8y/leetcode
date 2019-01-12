package co.aa8y.leetcode

import scala.annotation.tailrec

/**
 * 762. Prime Number of Set Bits in Binary Representation
 *
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a
 * prime number of set bits in their binary representation. (Recall that the number of set bits an
 * integer has is the number of 1s present when written in binary. For example, 21 written in
 * binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 *
 * Example 1:
 *   Input: L = 6, R = 10
 *   Output: 4
 *   Explanation:
 *     6 -> 110 (2 set bits, 2 is prime)
 *     7 -> 111 (3 set bits, 3 is prime)
 *     9 -> 1001 (2 set bits , 2 is prime)
 *     10 -> 1010 (2 set bits , 2 is prime)
 *
 * Example 2:
 *   Input: L = 10, R = 15
 *   Output: 5
 *   Explanation:
 *     10 -> 1010 (2 set bits, 2 is prime)
 *     11 -> 1011 (3 set bits, 3 is prime)
 *     12 -> 1100 (2 set bits, 2 is prime)
 *     13 -> 1101 (3 set bits, 3 is prime)
 *     14 -> 1110 (3 set bits, 3 is prime)
 *     15 -> 1111 (4 set bits, 4 is not prime)
 *
 * Note:
 * 1. L, R will be integers L <= R in the range [1, 10^6].
 * 2. R - L will be at most 10000.
 */
object PrimeNumberOfSetBitsInBinaryRepresentation {
  def countPrimeSetBits(l: Int, r: Int): Int = {
    (l to r).map { n =>
      toBinary(n).count(_ == 1)
    }.count(isPrime)
  }

  def toBinary(n: Int): List[Int] = {
    @tailrec
    def loop(n: Int, acc: List[Int]): List[Int] = {
      if (n == 0 || n == 1) n :: acc
      else loop(n / 2, n % 2 :: acc)
    }
    loop(n, Nil)
  }

  // Ref: https://en.wikipedia.org/wiki/Primality_test
  def isPrime(n: Int): Boolean = {
    @tailrec
    def loop(i: Int): Boolean = {
      if (i * i > n) true
      else if (n % i == 0 || n % (i + 2) == 0) false
      else loop(i + 1)
    }

    if (n <= 1) false
    else if (n <= 3) true
    else if (n % 2 == 0 || n % 3 == 0) false
    else loop(5)
  }
}

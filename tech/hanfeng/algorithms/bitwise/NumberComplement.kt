package tech.hanfeng.algorithms.bitwise

fun findComplement(num: Int): Int {

    /*
      Total number of bits = ⌊log2(n)⌋ + 1

      log2(n) means the logarithm in base 2 of n, which is the exponent to which 2 is raised to get n. For example, log2(123) ≈ 6.9425145. The presence of a fractional part means n is between powers of two.

      ⌊x⌋ is the floor of x, which is the integer part of x. For example, ⌊6.9425145⌋ = 6. You can think of ⌊log2(n)⌋ as the exponent of the highest power of two in the binary representation of n.

      + 1 takes the exponent to the next higher power of two. You can think of this step as accounting for the 20th place of your binary number, which then gives you its total number of bits. For our example, that’s 6 + 1 = 7.

     */

    val totalBits = Math.floor(Math.log(num.toDouble()) / Math.log(2.0)).toInt() + 1
    return (Math.pow(2.0, totalBits.toDouble()) - 1).toInt() xor num
}

fun bitSolution(num: Int): Int {
    var mask = 0.inv()   //  all 1's

    // no leading 0's    keep shifting left until 0 is length of the bit size of the num
    while((num and mask) != 0) {
        mask = mask shl 1
    }
    return num xor mask.inv()   // xor to get the complement number
}

fun main() {
    println(findComplement(5))
    println(bitSolution(5))
}
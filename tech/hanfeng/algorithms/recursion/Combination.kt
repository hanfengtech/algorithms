package tech.hanfeng.algorithms.recursion

fun combination(n : Int, k : Int) : Int = if (n <= 1 || k == 0 || k == n) 1
      else combination(n - 1, k) + combination(n - 1, k - 1)

fun main() {
    println(combination(5, 2))
}
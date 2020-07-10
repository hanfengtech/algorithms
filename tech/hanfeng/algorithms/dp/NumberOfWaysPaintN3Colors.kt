package tech.hanfeng.algorithms.dp

/*

  1 2 3   <- previous row     three colors
  ------
  2 1 2      x
  2 3 1   x
  2 3 2      x
  3 1 2   x

  1 2 1  <- previous row      two colors
  -----
  2 1 2      x
  2 1 3   x
  2 3 2      x
  3 1 2   x
  3 1 3      x
		 /    \
this column   this column
for 3 colors  for 2 colors

 */
fun numOfWays(n : Int) : Int {
    if (n == 0) return 0
    val mod = 1_000_000_007L
    var count = 1
    var twoColors = 6L
    var threeColors = 6L

    while(count++ < n) {
        var nextTwoColors = (3 * twoColors + 2 * threeColors) % mod
        threeColors = (2 * twoColors + 2 * threeColors) % mod
        twoColors = nextTwoColors
    }

    return ((twoColors + threeColors) % mod).toInt()
}

fun main() {
    println(numOfWays(1))
    println(numOfWays(2))
    println(numOfWays(4))
    println(numOfWays(10))
}
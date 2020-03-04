package tech.hanfeng.algorithms.recursion

/*
 *  Full tree
 *  Total Steps = 2 ^ N - 1     
 */
fun hanoi(n : Int) {
    fun helper(n : Int, src : Int, dst : Int, aux : Int) {
        if (n == 1) {
            println("Move disk from src $src to dst $dst")
        } else {
            helper(n - 1, src, aux, dst)
            println("Move disk from src $src to dst $dst")
            helper(n - 1, aux, dst, src)
        }
    }

    helper(3, 1, 2,3)
}

fun main() {
    print(hanoi(3))
}

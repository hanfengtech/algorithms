package tech.hanfeng.algorithms.array

class RandomPick(var nums : IntArray) {

    val map = HashMap<Int, ArrayList<Int>>()

    /*
    init {
        for (i in nums.indices) {
            if (!map.containsKey(nums[i])) {
                map[nums[i]] = ArrayList()
            }
            map[nums[i]]!!.add(i)
        }
    }
     */

    fun pick(target : Int) : Int {
        return map[target]!!.random()
    }

    fun pickInPlace(target : Int) : Int {
        val results = ArrayList<Int>()
        for( i in nums.indices) {
            if (nums[i] == target)
                results.add(i)
        }
        return results.random()
    }
}

fun main() {
    val randomPick = RandomPick(intArrayOf(1,2,3,3,3))
    println(randomPick.pick(3))
    println(randomPick.pick(2))
    println(randomPick.pick(1))
}
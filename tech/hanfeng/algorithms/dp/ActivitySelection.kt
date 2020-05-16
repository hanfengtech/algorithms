package tech.hanfeng.algorithms.dp

fun activitySelection(start : IntArray, end : IntArray) : Int {

    if (start.isEmpty() || start.size != end.size) return 0

    val activities = ArrayList<Pair<Int, Int>>()
    start.forEachIndexed { index, value -> activities.add(Pair(value, end[index])) }
    activities.sortBy { it.second }

    var count = 1
    var i = 0

    for (j in 1 until activities.size) {
        if (activities[j].first >= activities[i].second) {
            count++
            i = j
        }
    }

    return count
}

fun main() {
    println(activitySelection(intArrayOf(1, 3, 2, 5, 8, 5), intArrayOf(2, 4, 6, 7, 9, 9)))
    println(activitySelection(intArrayOf(1, 3, 2, 5), intArrayOf(2, 4, 3, 6)))
    println(activitySelection(intArrayOf(), intArrayOf()))
    println(activitySelection(intArrayOf(), intArrayOf(1)))
}
package tech.hanfeng.algorithms.dp

data class Activity(var start : Int, var finish : Int)

fun activitySelection(start : IntArray, end : IntArray) : Int {

    if (start.isEmpty() || start.size != end.size) return 0

    val activities = ArrayList<Activity>()
    start.forEachIndexed { index, value -> activities.add(Activity(value, end[index])) }
    activities.sortBy { it.finish }

    var count = 1
    var i = 0

    for (j in 1 until activities.size) {
        if (activities[j].start >= activities[i].finish) {
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
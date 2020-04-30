package tech.hanfeng.algorithms.implementation

import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet
import kotlin.collections.MutableMap
import kotlin.collections.first
import kotlin.collections.forEach
import kotlin.collections.set


class FirstUnique(private var nums: IntArray) {

    class DLinkedNode(var value : Int = 0) {
        var prev : DLinkedNode? = null
        var next : DLinkedNode? = null
    }

    private val head = DLinkedNode()
    private val tail = DLinkedNode()
    private val map = HashMap<Int, DLinkedNode>()

    init {
        head.next = tail
        tail.prev = head

        nums.forEach {
            add(it)
        }
    }


    fun showFirstUnique(): Int {
        return if (head.next != tail) {
            head.next!!.value
        } else {
            -1
        }
    }

    fun add(value: Int) {
        if (map.containsKey(value)) {
            val node = map[value]!!
            remove(node)
        } else {
            val newNode = DLinkedNode(value)
            map[value] = newNode
            append(newNode)
        }
    }

    fun append(node: DLinkedNode) {
        node.prev = tail.prev
        tail.prev?.next = node
        node.next = tail
        tail.prev = node
    }

    fun remove(node : DLinkedNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.next = null
        node.prev = null
    }
}


class StreamFirstUnique(private var nums: IntArray) {
    private val set = HashSet<Int>()
    private val unique = LinkedHashSet<Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun showFirstUnique(): Int {
        return unique.stream().findFirst().orElse(-1)
    }

    fun add(value: Int) {
        if (set.contains(value)) {
            unique.remove(value)
        } else {
            set.add(value)
            unique.add(value)
        }
    }
}

fun main() {
    val queue = StreamFirstUnique(intArrayOf(412,655,699,414,425,156,61,407,376))

    println(queue.showFirstUnique())

    queue.add(412)
    queue.add(655)
    queue.add(699)
    queue.add(414)
    queue.add(425)
    queue.add(156)

    println(queue.showFirstUnique())

    /*
    println(queue.showFirstUnique())
    queue.add(3)
    println(queue.showFirstUnique())
     */
}
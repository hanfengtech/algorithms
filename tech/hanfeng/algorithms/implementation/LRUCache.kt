package tech.hanfeng.algorithms.implementation

import java.util.*

class LRUCache(private var capacity: Int) {
    class DLinkedNode(var key : Int = 0, var value : Int = 0) {
        var prev : DLinkedNode? = null
        var next : DLinkedNode? = null
    }

    private var head = DLinkedNode()
    private var tail = DLinkedNode()
    private var count = 0
    private val cache = Hashtable<Int, DLinkedNode>()

    //  Always add new node right after head
    private fun addNode(node : DLinkedNode) {
        node.next = head.next
        node.next?.prev = node
        node.prev = head
        head.next = node
    }

    private fun removeNode(node: DLinkedNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail() : DLinkedNode? {
        val last = tail.prev
        removeNode(last!!)
        return last
    }

    init {
        head.next = tail
        tail.prev = head
    }

    operator fun get(key : Int) : Int {
        var node = cache[key] ?: return -1

        moveToHead(node)
        return node.value
    }

    operator fun set(key : Int, value : Int) {
        val node = cache[key]

        if (node != null) {  // already exist, update value and move to head because recent access
            node.value = value
            moveToHead(node)
        } else {
            if (count == capacity) {
                var last = popTail()
                cache.remove(last?.key)
                count--
            }
            var newNode = DLinkedNode(key, value)
            addNode(newNode)
            cache[key] = newNode
            count++
        }
    }
}

fun main() {
    var cache = LRUCache(2)

    cache[1] = 1
    cache[2] = 2
    println(cache[1])
    cache[3] = 3
    cache[4] = 4
    println(cache[1])
    println(cache[3])
    println(cache[4])
}
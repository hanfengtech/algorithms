package tech.hanfeng.algorithms.implementation

class MyLinkedList {

    /** Initialize your data structure here. */

    class Node(var `val` : Int, var next : Node? = null)

    var headNode = Node(0)  // dummy header node
    var size = 0

    fun getNode(index : Int) : Node? {
        if (index < 0 || index >= size) return null
        var i = 0
        var cur = headNode

        while (i++ <= index) {
            cur = cur.next!!
        }
        return cur
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        return getNode(index)?.`val` ?: -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0 || index > size) return

        var newNode = Node(`val`)
        val prev = if (index == 0) headNode else getNode(index - 1)
        newNode.next = prev!!.next
        prev!!.next = newNode
        size++
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) return
        val prev = if (index == 0) headNode else getNode(index - 1)
        prev!!.next = prev!!.next!!.next
        size--
    }

    override fun toString() : String {
        val sb = StringBuilder()

        var cur = headNode.next

        while (cur != null) {
            sb.append(cur.`val`)
            if (cur.next != null) {
                sb.append(" -> ")
            }

            cur = cur.next
        }

        return sb.toString()
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */


/*
["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
[[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
 */
fun main() {
    var obj = MyLinkedList()
    var param_1 = obj.get(1)
    obj.addAtHead(1)
    println(obj)
    obj.addAtTail(3)
    println(obj)
    obj.addAtIndex(1,2)
    println(obj)
    param_1 = obj.get(1)
    println(param_1)
    println(obj)
    obj.deleteAtIndex(1)
    param_1 = obj.get(1)
    println(param_1)
    println(obj)

    obj = MyLinkedList()
    obj.addAtHead(4)
    println(obj.get(1))
    obj.addAtHead(1)
    obj.addAtHead(5)
    obj.deleteAtIndex(3)
    obj.addAtHead(7)
    println(obj.get(3))
    println(obj.get(3))
    println(obj.get(3))
    obj.addAtHead(1)
    obj.deleteAtIndex(4)
}
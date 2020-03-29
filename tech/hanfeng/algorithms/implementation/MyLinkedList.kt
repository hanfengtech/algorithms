package tech.hanfeng.algorithms.implementation

class MyLinkedList() {

    /** Initialize your data structure here. */

    class Node(num : Int) {
        var `val` : Int = num
        var next : Node? = null
    }

    var head : Node? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        if (index < 0 || head == null) return -1

        var cur : Node? = head

        for (i in 0 until index) {

            if (cur == null) {
                return -1
            }

            cur = cur.next
        }

        return cur?.`val` ?: -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
        } else {
            var newHead = Node(`val`)
            newHead.next = head
            head = newHead
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
            return
        }

        var cur : Node? = head
        while (cur!!.next != null) {
            cur = cur.next
        }

        cur.next = Node(`val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0) return

        if (index == 0) {
            addAtHead(`val`)
            return
        }

        var cur : Node? = head
        var i = 0

        while (cur != null && i < index) {
            if (i == index - 1) {
                var newNode = Node(`val`)
                newNode.next = cur.next
                cur.next = newNode
                return
            }

            if (cur.next == null && i == index) {
                cur.next = Node(`val`)
            }

            i++
            cur = cur.next
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (index < 0 || head == null) return

        if (index == 0) {
            head = head!!.next
            return
        }

        var cur : Node? = head
        var i = 0

        while (cur != null && i < index) {
            if (i++ == index - 1) {
                if (cur.next != null) {
                    cur.next = cur!!.next!!.next
                } else {
                    cur.next = null
                }
            }

            cur = cur.next
        }
    }

    override fun toString() : String {
        val sb = StringBuilder()

        var cur = head

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
package tech.hanfeng.algorithms.list

class InsertIntoSortedCircularLinkedList {

    fun insert(head: Node?, insertVal: Int): Node? {
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        }

        var prev = head!!
        var curr = head.next!!
        var isInsert = false

        do {
            if (prev.`val` <= insertVal && insertVal <= curr.`val`) {
                isInsert = true
            } else if (prev.`val` > curr.`val`) {
                if (insertVal >= prev.`val` || insertVal <= curr.`val`)
                    isInsert = true
            }

            if (isInsert) {
                prev.next = Node(insertVal)
                prev.next!!.next = curr
                return head
            }

            prev = curr
            curr = curr.next!!
        } while (prev != head)

        prev.next = Node(insertVal)
        prev.next!!.next = curr
        return head
    }
}
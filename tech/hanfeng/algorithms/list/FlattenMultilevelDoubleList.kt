package tech.hanfeng.algorithms.list

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

fun printList(node : Node?) {
    if (node == null)
        return

    var cur = node
    if (cur.next !== null) {
        while (cur?.next != null) {
            print("${cur?.`val`} -> ")
            cur = cur?.next
        }
    }
    print(cur?.`val`)
}

fun flatten(root: Node?): Node? {
    fun helper(root: Node?) : Node? {
        var cur = root

        while (cur != null) {
            if (cur.child != null) {
                var tail = helper(cur.child)
                var next = cur.next
                cur.next = cur.child
                cur.child?.prev = cur
                tail?.next = next
                cur.child = null
                next?.prev = tail
            }

            if (cur.next == null) {
               return cur
            }
            cur = cur.next
        }

        return cur
    }

    helper(root)
    return root
}

fun main() {
    var node3 = Node(3)

    var node5 = Node(5)
    node3.child = node5

    var node6 = Node(6)
    node5.child = node6

    printList(flatten(node3))
}
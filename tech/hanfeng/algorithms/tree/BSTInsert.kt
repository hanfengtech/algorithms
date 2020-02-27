package tech.hanfeng.algorithms.tree

fun insert(root : TreeNode?, x : Int) : TreeNode {

    var newNode = TreeNode(x)

    if (root == null) return newNode

    var cur : TreeNode? = root
    var prev : TreeNode? = null

    while (cur != null) {
        when {
            x == cur.value -> {
                throw Exception("Value already exist!")
            }
            x < cur.value -> {
                prev = cur
                cur = cur.left
            }
            x > cur.value -> {
                prev = cur
                cur = cur.right
            }
        }
    }

    if (x < prev!!.value) {
        prev.left = newNode
    } else {
        prev.right = newNode
    }

    return root
}

fun main() {
    var bst = insert(null, 44)

    bst = insert(bst, 17)
    bst = insert(bst, 88)
    bst = insert(bst, 8)
    bst = insert(bst, 32)
    bst = insert(bst, 28)
    bst = insert(bst, 29)
    bst = insert(bst, 65)
    bst = insert(bst, 54)
    bst = insert(bst, 82)
    bst = insert(bst, 76)
    bst = insert(bst, 68)
    bst = insert(bst, 80)
    bst = insert(bst, 97)
    bst = insert(bst, 93)

    print("Pre-order: ")
    print(preorder(bst).joinToString())
    print("\nPre-order: ")
    print(dfsIt(bst)!!.joinToString())
    println("\nPre-order: ")
    preorderPretty(bst)
}

fun populateTree() : TreeNode {
    var bst = insert(null, 44)
    bst = insert(bst, 17)
    bst = insert(bst, 88)
    bst = insert(bst, 8)
    bst = insert(bst, 32)
    bst = insert(bst, 28)
    bst = insert(bst, 29)
    bst = insert(bst, 65)
    bst = insert(bst, 54)
    bst = insert(bst, 82)
    bst = insert(bst, 76)
    bst = insert(bst, 68)
    bst = insert(bst, 80)
    bst = insert(bst, 97)
    bst = insert(bst, 93)
    return bst
}
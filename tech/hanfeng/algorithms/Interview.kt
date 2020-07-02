package tech.hanfeng.algorithms

import java.awt.Image
/*
In my screen , I have to display a Scrollbale Images
123
456
789
...

I want to add pic to nth position .
I want to delete the pic from nth pos .
I click nth position , move to first position.
After each operation , need to rearrange all the pictures. So that position 1 is the latest and so on .
How we write the app?
Please code in Kotlin .

612    Item   [1 2 3]
345
789
...

123

456

0) Layout Image screen  / activity / fragment
1) create recycleview  / adapter
2) create the item layout for three images
3) data source
4) ViewModles

6
 */
fun delete(images : ArrayList<Image>, pos : Int) : Boolean {
    if (pos > 0 && pos < images.size) {
        var image = images[pos]
        images.removeAt(pos)
        images.add(0, image)
        return true
    } else {
        return false
    }
}

fun add(images : ArrayList<Image>, image : Image, pos : Int) : Boolean {
    if (pos > 0 && pos < images.size) {
        images.add(pos, image)
        return true
    } else {
        return false
    }
}







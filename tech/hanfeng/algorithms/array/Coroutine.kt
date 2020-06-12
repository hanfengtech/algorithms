package tech.hanfeng.algorithms.array

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    try {
        println(failedConcurrentSum())
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }

    launch { // context of the parent, main runBlocking coroutine
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }

// here we print five received integers:
  //  repeat(5) { println(channel.receive()) }
  //  println("Done!")
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            //delay(Long.MAX_VALUE) // Emulates very long computation
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        //throw ArithmeticException()
        8
    }
    one.await() + two.await()
}
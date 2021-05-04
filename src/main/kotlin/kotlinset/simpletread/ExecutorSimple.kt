package kotlinset.simpletread

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main() {
    val strings = listOf("1", "2", "3")
    val printStringTasks = mutableListOf<Callable<Unit>>()
    strings.forEach {
        printStringTasks.add(Callable<Unit> {
            println("starting task: $it")
            Thread.sleep(2000)
            println("finished task: $it")
        })
    }

    val threadPoolExecutor = Executors.newFixedThreadPool(3)
    threadPoolExecutor.invokeAll(printStringTasks)
    threadPoolExecutor.shutdown()
}
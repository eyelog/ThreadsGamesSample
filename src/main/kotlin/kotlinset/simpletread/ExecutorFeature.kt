package kotlinset.simpletread

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main() {
    val strings = listOf("1", "2", "3")
    val printStringTasks = mutableListOf<Callable<String>>()
    strings.forEach { printStringTasks.add(Callable<String> {
        println("starting task: $it")
        Thread.sleep(2000)
        println("finished task: $it")
        return@Callable it
    })}

    val threadPoolExecutor = Executors.newFixedThreadPool(3)

    data class ThreeStr(val a: String, val b: String, val c: String)

    val awaits = threadPoolExecutor.invokeAll(printStringTasks)

    val ts1 = ThreeStr(
        awaits[0].get(),
        awaits[1].get(),
        awaits[2].get()
    )

    // can do this if the tasks are different types

    val res1 = threadPoolExecutor.submit(printStringTasks[0])
    val res2 = threadPoolExecutor.submit(printStringTasks[1])
    val res3 = threadPoolExecutor.submit(printStringTasks[2])

    val ts2 = ThreeStr(
        res1.get(),
        res2.get(),
        res3.get()
    )

    threadPoolExecutor.shutdown()

    print(ts1)
    print(ts2)
}
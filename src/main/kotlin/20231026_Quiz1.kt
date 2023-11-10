import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
    val star = "*"

    for (i in 1 until num+1)
        println(star.repeat(i))

    for (i in num-1 downTo 1 step(1))
        println(star.repeat(i))
    scanner.close()
}
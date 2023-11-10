import java.security.InvalidParameterException
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()

    if(num % 2 == 0) {
        throw InvalidParameterException("짝수는 허용되지 않습니다. 다시 입력해주세요")
    }

    if (num < 0) {
        throw InvalidParameterException("음수는 허용되지 않습니다. 다시 입력해주세요")
    }

    val default = "*".repeat(num)

    //O(N)
    for (i in 1 until num+1 step(2)) {
        if (i==num){
            println(default)
        } else {
            val start = (num-i)/2
            val len = i
            print(" ".repeat(start)) //left pad
            print(default.substring(start, start+len)) //
            //print(" ".repeat(start)) //right pad 굳이 안해도 표현됨
            println()
        }
    }

    for (i in num downTo 1 step(2)) {
        if (i==num){
            continue
        } else {
            val start = (num-i)/2
            val len = i
            print(" ".repeat(start))
            print(default.substring(start, start+len))
            //print(" ".repeat(start))
            println()
        }
    }
    scanner.close()
}
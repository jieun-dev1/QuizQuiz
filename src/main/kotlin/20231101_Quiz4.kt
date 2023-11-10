import java.security.InvalidParameterException
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    if (number % 2 == 0) {
        throw InvalidParameterException("짝수는 허용되지 않습니다. 다시 입력해주세요")
    }

    if (number < 0) {
        throw InvalidParameterException("음수는 허용되지 않습니다. 다시 입력해주세요")
    }

    val default = "*".repeat(number)

    var seq = 1
    val point = number / 2 + 1
    var leftpad = 0
    var len = 0

    while (seq in 1..number) {
        if (seq < point) {
            leftpad = point - seq
            len = 2 * (seq - 1) + 1
            print(" ".repeat(leftpad))
            print(default.substring(leftpad, leftpad + len))
            println()
        } else if (seq == point) {
            println(default)
        } else {
            leftpad = seq - point
            len = 2 * (number - seq) + 1
            print(" ".repeat(leftpad))
            print(default.substring(leftpad, leftpad+len))
            println()
        }
        seq++
    }

}
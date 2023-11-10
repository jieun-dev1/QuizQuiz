import java.util.*
import kotlin.random.Random

data class Result(
    val strikeCount: Int,
    val ballCount: Int
)

fun numberGenerator2(): String {
    val list = generateSequence {
        Random.nextInt(10)
    }.distinct().take(3).toSet()
    val numberStr = buildString { list.forEach (::append)}
    return numberStr
}

fun score(systemInput: String, userInput: String): Result {
    return Result (
        strikeCount = scoreStrike(systemInput, userInput),
        ballCount = scoreBall(systemInput, userInput)
    )
}
fun scoreStrike(systemInput: String, userInput: String): Int {
//String 으로 만든다.
    var strikeCount = 0
    for (i in 0 until 3 ) {
        if (systemInput[i] == userInput[i]) {
            strikeCount++
        }
    }
    return strikeCount
}

fun scoreBall(systemInput: String, userInput: String): Int {
    var ballCount = 0
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == j) {
                continue
            }
            if (systemInput[i] == userInput[j]) {
                ballCount++
            }
        }
    }
    return ballCount
}

fun returnResult(result:Result):String {
    if (result.strikeCount!= 0 && result.ballCount!=0) {
        return "${result.strikeCount}스트라이크${result.ballCount}볼"
    }
    if (result.strikeCount== 0 && result.ballCount!=0) {
        return "${result.ballCount}볼"
    }
    if (result.strikeCount!= 0 && result.ballCount==0) {
        return "${result.strikeCount}스트라이크"
    }
    return "아무것도 맞추지 못했습니다ㅜ"
}

fun validateInput(userInput: String): InputResponse {
    if(userInput.length >=4){
        return InputResponse(false, "3자리의 숫자만 입력 가능합니다")
    }
    val userInputArray = userInput.toCharArray().map { it - '0'}
    if (userInputArray.toSet().size != userInputArray.size) {
        return InputResponse(false, "같은 숫자를 2번 이상 입력했습니다. 다시 입력하세요")
    }
    return InputResponse(true, "")
}
fun main(args: Array<String>) {
    var count = 1
    //입력을 받고 저장한다 .
    val systemNumber = numberGenerator2()
    print(systemNumber)

    while(count <= 10) {
        println()
        println("${count} 회차입니다. 세 자리의 숫자를 중복 없이 입력해주세요")

        val scanner = Scanner(System.`in`)
        var userNumber = scanner.next()
        while (!validateInput(userNumber).valid){
            print(validateInput(userNumber).message)
            println()
            userNumber = scanner.next()
            validateInput(userNumber)
        }
        val result = score(systemNumber, userNumber)

        print(returnResult(result))
        if (result.strikeCount == 3) {
            println()
            print("정답입니다!")
            return
        }
        count += 1
    }
    println("10회차가 모두 종료되었습니다. 다음기회에 도전하세요")
}

data class InputResponse(
    val valid: Boolean,
    var message: String? = ""
)
import java.security.InvalidParameterException
import java.util.*

/**
 * 1씩 증가. pad 없음.
 * System.in: standard input stream
 * close()를 명시적으로 해주지 않으면, 리소스가 열린채로 input 계속받을 수 있다.
 * 파일 작업은 파일 손상 될 수 있어서, close()를 꼭 해줘야 하지만,
 * 키보드 입력의 경우는 굳이 안해줘도 무관하다.
 *
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
    if(num <= 0) {
        throw InvalidParameterException("0 이하의 숫자는 허용되지 않습니다. 다시 입력해주세요")
    }
    val star = "*"
    var length = 2*num -1 //별찍기를 하면 1,2,3,4,3,2,1 length = 7 == 2*num -1
    var seq = 1
    while (seq in 1..length) {
        if(seq < num)  {
            println(star.repeat(seq)) //1,2,3
            seq += 1
            continue
        }

        if(seq == num)  {
            println(star.repeat(seq)) //1,2,3
            seq += 1
            continue
        }

        if (seq > num) {
            println(star.repeat(2 * num - seq)) //
            seq++
            continue
        }
    }
    //scanner.close()
}
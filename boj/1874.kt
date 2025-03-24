// 0x05 Stack | 1874_스택 수열
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val stack = Stack<Int>()
    val N = readLine().toInt()
    val arr = IntArray(N) { readLine().toInt() }
    var index = 0
    var pushCount = 0
    val str = StringBuilder()

    while(index < N) {

        if (stack.isNotEmpty() && stack.peek() == arr[index]) {
            stack.pop()
            str.appendLine("-")
            index++
        } else if (stack.isEmpty() || stack.peek() < arr[index]) { // top < num
            if (pushCount > arr[index]) {
                break
            }
            while (pushCount < arr[index]) { // pushCount > num
                pushCount++
                stack.push(pushCount)
                str.appendLine("+")
            }
        } else if (stack.isNotEmpty() && stack.peek() > arr[index]) { // top > num
            while (stack.peek() > arr[index]) {
                stack.pop()
                str.appendLine("-")
            }
        }
    }
    if (index == N) {
        print(str.toString())
    } else {
        print("NO")
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val stack = ArrayDeque<Char>()
    var line = ""

    while(readLine().also { line = it } != ".") {
        var flag = true
        for (ch in line) {
            if (ch in "[(") {
                stack.addLast(ch)
            } else if (ch in ")]") {
                if (stack.isEmpty()) {
                    flag = false
                    break
                }
                if ((ch == ')' && stack.last() == '(') || (ch == ']' && stack.last() == '[')) {
                    stack.removeLast()
                } else {
                    flag = false
                    break
                }
            }
        }
        if (stack.isNotEmpty()) flag = false
        if (flag) println("yes") else println("no")
        stack.clear()
    }
}
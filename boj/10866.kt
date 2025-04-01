import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val dq = ArrayDeque<Int>()
    val N = readLine().toInt()
    val sb = StringBuilder()

    repeat(N) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "front" -> sb.appendLine(dq.firstOrNull() ?: -1)
            "back" -> sb.appendLine(dq.lastOrNull() ?: -1)
            "size" -> sb.appendLine(dq.size)
            "empty" -> sb.appendLine(if (dq.isEmpty()) 1 else 0)
            "pop_front" -> sb.appendLine(dq.removeFirstOrNull() ?: -1)
            "pop_back" -> sb.appendLine(dq.removeLastOrNull() ?: -1)
            "push_front" -> dq.addFirst(st.nextToken().toInt())
            "push_back" -> dq.addLast(st.nextToken().toInt())
        }
    }
    print(sb)
}
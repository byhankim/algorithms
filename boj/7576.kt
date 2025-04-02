import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    var zeroCount = 0

    val box = Array(n) { IntArray(m) }
    val q = ArrayDeque<Pair<Int, Int>>()
    var max = -1

    repeat(n) { x ->
        st = StringTokenizer(readLine())
        repeat(m) { y ->
            val tomato = st.nextToken().toInt()
            box[x][y] = tomato

            if (tomato == 0) zeroCount++
            if (tomato == 1) {
                q.addLast(Pair(x, y))
            }
        }
    }
    if (zeroCount == 0) {
        print(0)
        return
    }

    while (q.isNotEmpty()) {
        val (x,y) = q.removeFirst()

        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (box[nx][ny] != 0) continue

            q.addLast(Pair(nx, ny))

            box[nx][ny] = box[x][y] + 1
            zeroCount--
            max = maxOf(max, box[nx][ny])
        }
    }
    if (zeroCount > 0) {
        print(-1)
    } else {
        print(max - 1)
    }
}
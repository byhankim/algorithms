import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    val tomatoCount = mutableMapOf<Int, Int>()

    val box = Array(n) { IntArray(m) }
    val q = ArrayDeque<Pair<Int, Int>>()
    var max = -1

    repeat(n) { x ->
        st = StringTokenizer(readLine())
        repeat(m) { y ->
            val tomato = st.nextToken().toInt()
            box[x][y] = tomato
            tomatoCount[tomato] = tomatoCount.getOrDefault(tomato, 0) + 1
            if (tomato == 1) {
                q.addLast(Pair(x, y))
            }
        }
    }
    if (tomatoCount.getOrDefault(0, 0) == 0) {
        print(0)
        return
    }

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (dir in 0 until 4) {
            val nx = cur.first + dx[dir]
            val ny = cur.second + dy[dir]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (box[nx][ny] != 0) continue

            q.addLast(Pair(nx, ny))

            box[nx][ny] = box[cur.first][cur.second] + 1

            val new = box[nx][ny]

            tomatoCount[0] = tomatoCount.getOrDefault(0, 0) - 1
            tomatoCount[new] = tomatoCount.getOrDefault(new, 0) + 1

            if (new > max) {
                max = new
            }
        }
    }
    if (tomatoCount.getOrDefault(0, 0) > 0) {
        print(-1)
    } else {
        print(max - 1)
    }
}
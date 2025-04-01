import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val distMap = Array(n) { IntArray(m) }
    val maze = Array(n) { IntArray(m) }
    
    repeat(n) { i ->
        val line = readLine()
        repeat(m) { j ->
            maze[i][j] = line[j]-'0'
        }
    }

    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,-1,0,1)
    
    val q = ArrayDeque<Pair<Int, Int>>()
    distMap[0][0] = 1
    q.addLast(Pair(0, 0))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (dir in 0 until 4) {
            val nx = cur.first + dx[dir]
            val ny = cur.second + dy[dir]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (maze[nx][ny] == 0 || distMap[nx][ny] > 0) continue

            distMap[nx][ny] = distMap[cur.first][cur.second] + 1
            q.addLast(Pair(nx, ny))
        }
    }
    println(distMap[n-1][m-1])
}
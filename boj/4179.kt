import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,-1,0,1)

    val fq = ArrayDeque<Pair<Int,Int>>() // fire queue
    val jq = ArrayDeque<Pair<Int,Int>>() // j queue
    var shortestDist = 0

    val visited = Array(r) { BooleanArray(c) }
    val maze = Array(r) { CharArray(c) }
    repeat(r) { x ->
        val line = readLine()
        repeat(c) { y ->
            maze[x][y] = line[y]
            when (line[y]) {
                'F' -> fq.addLast(Pair(x,y))
                'J' -> {
                    jq.addLast(Pair(x,y))
                    visited[x][y] = true
                }
            }
        }
    }

    while (jq.isNotEmpty()) {

        repeat(fq.size) {
            val (fx, fy) = fq.removeFirst()

            for (dir in 0 until 4) {
                val nx = fx + dx[dir]
                val ny = fy + dy[dir]
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue
                if (maze[nx][ny] in "#F") continue

                fq.addLast(Pair(nx, ny))
                maze[nx][ny] = 'F'
            }
        }

        var moved = false
        repeat(jq.size) {
            val (jx, jy) = jq.removeFirst()

            for (dir in 0 until 4) {
                val nx = jx + dx[dir]
                val ny = jy + dy[dir]

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    println(shortestDist + 1)
                    return
                }
                if (maze[nx][ny] in "#F" || visited[nx][ny]) continue

                visited[nx][ny] = true
                moved = true

                jq.addLast(Pair(nx, ny))
            }

        }
        if (moved) {
            shortestDist++
        }
    }
    println("IMPOSSIBLE")
}
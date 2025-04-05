fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine()!!.toInt()
    val sb = StringBuilder()

    fun bfs(w: Int, h: Int): String {
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        val map = Array(h) { CharArray(w) }
        val distF = Array(h) { IntArray(w) { -1 } }
        val distS = Array(h) { IntArray(w) { -1 } }

        val fq = ArrayDeque<Pair<Int, Int>>()
        val sq = ArrayDeque<Pair<Int, Int>>()

        repeat(h) { x ->
            val line = readLine()
            repeat(w) { y ->
                map[x][y] = line[y]
                when (line[y]) {
                    '*' -> {
                        fq.addLast(Pair(x, y))
                        distF[x][y] = 0
                    }
                    '@' -> {
                        sq.addLast(Pair(x, y))
                        distS[x][y] = 0
                    }
                }
            }
        }

        // 불
        while (fq.isNotEmpty()) {
            val (x, y) = fq.removeFirst()
            for (dir in 0 until 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]
                if (nx !in 0 until h || ny !in 0 until w) continue
                if (map[nx][ny] == '#' || distF[nx][ny] != -1) continue
                distF[nx][ny] = distF[x][y] + 1
                fq.addLast(Pair(nx, ny))
            }
        }

        // 상근이
        while (sq.isNotEmpty()) {
            val (x, y) = sq.removeFirst()
            for (dir in 0 until 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]
                if (nx !in 0 until h || ny !in 0 until w) {
                    return "${distS[x][y] + 1}"
                }
                if (map[nx][ny] == '#' || distS[nx][ny] != -1) continue
                if (distF[nx][ny] != -1 && distF[nx][ny] <= distS[x][y] + 1) continue
                distS[nx][ny] = distS[x][y] + 1
                sq.addLast(Pair(nx, ny))
            }
        }

        return "IMPOSSIBLE"
    }

    repeat(t) {
        val (w, h) = readLine()!!.split(" ").map { it.toInt() }
        sb.append(bfs(w, h)).append('\n')
    }

    print(sb)
}
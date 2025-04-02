import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()  // box cols
    val n = st.nextToken().toInt()  // box rows
    val h = st.nextToken().toInt()  // box packs

    val dx = intArrayOf(1, 0, -1, 0, 0, 0)
    val dy = intArrayOf(0, -1, 0, 1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)
    val q = ArrayDeque<Triple<Int, Int, Int>>()
    var zeroCount = 0
    var max = -1

    val box = Array(h) { Array(n) { IntArray(m) } }
    repeat(h) { z ->
        repeat(n) { x ->
            st = StringTokenizer(readLine())
            repeat(m) { y ->
                val tomato = st.nextToken().toInt()
                box[z][x][y] = tomato

                if (tomato == 0) zeroCount++
                if (tomato == 1) q.addLast(Triple(z, x, y))
            }
        }
    }

    if (zeroCount == 0) {
        print(0)
        return
    }

    while (q.isNotEmpty()) {
        val (z,x,y) = q.removeFirst()

        for (dir in 0 until 6) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            val nz = z + dz[dir]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue
            if (box[nz][nx][ny] != 0) continue

            q.addLast(Triple(nz, nx, ny))

            box[nz][nx][ny] = box[z][x][y] + 1
            zeroCount--
            max = maxOf(max, box[nz][nx][ny])
        }
    }

    if (zeroCount > 0) {
        print(-1)
    } else {
        print(max - 1)
    }
}
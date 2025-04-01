import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    // board, N, M 정의
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val board = Array(n) {
        st = StringTokenizer(readLine())
        BooleanArray(m) {
            if (st.nextToken().toInt() == 1) true else false
        }
    }

    // visited map 정의
    val vis = Array(n) { BooleanArray(m) { false } }

    // 상하좌우 인접 방향 정의
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,-1,0,1)

    // Queue 정의
    val q = ArrayDeque<Pair<Int, Int>>()

    var res = -1
    var paintingSize = 0
    var paintingCnt = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            // check if current cell is visited/painted
            if (!board[i][j] || vis[i][j]) continue
            
            // new painting
            vis[i][j] = true
            q.addLast(Pair(i, j))

            while (q.isNotEmpty()) {
                val cur = q.removeFirst()
                if (board[cur.first][cur.second]) {
                    paintingSize++
                }
                for (dir in 0 until 4) {
                    val nx = cur.first + dx[dir]
                    val ny = cur.second + dy[dir]

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                    if (vis[nx][ny] || !board[nx][ny]) continue
                    q.addLast(Pair(nx, ny))
                    vis[nx][ny] = true
                }
            }

            res = if (paintingSize > res) paintingSize else res
            paintingSize = 0
            paintingCnt++
            
        }
    }
    print("$paintingCnt\n$res")
}
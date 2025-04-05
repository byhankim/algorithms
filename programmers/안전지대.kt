class Solution {
    fun solution(board: Array<IntArray>): Int {
        val dx = intArrayOf(1,0,-1,0, 1,1,-1,-1)
        val dy = intArrayOf(0,-1,0,1, 1,-1,-1,1)

        val bq = ArrayDeque<Pair<Int,Int>>()
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        var area = 0

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 1) {
                    visited[i][j] = true
                    bq.addLast(Pair(i,j))
                    area++
                }
            }
        }

        repeat(bq.size) {
            val coord = bq.removeLast()

            for (dir in 0 until 8) {
                val nx = coord.first + dx[dir]
                val ny = coord.second + dy[dir]

                if (nx !in 0 until board.size || ny !in 0 until board[0].size) continue
                if (visited[nx][ny]) continue

                visited[nx][ny] = true
                area++
            }
        }

        return (visited.size * visited[0].size) - area
    }
}
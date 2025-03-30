fun main() {
    val N = readLine()!!.toInt()
    var res = N
    repeat(N.toString().length * 9) {
        val M = N - it
        if (M < 0) return@repeat
        if (M + M.digitSum() == N) {
            res = M
        }
    }
    print("${if (res < N) res else 0}")

}

fun Int.digitSum() = this.toString().fold(0) { acc, v ->
    acc + v.digitToInt()
}
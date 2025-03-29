fun main() {
    val N = System.`in`.bufferedReader().readLine().toInt()
    val q = ArrayDeque<Int>()
    repeat(N) { q.addLast(it+1) }
    
    while (q.size > 1) {
        q.removeFirst()
        q.addLast(q.removeFirst())
    }
    print(q.first())
}
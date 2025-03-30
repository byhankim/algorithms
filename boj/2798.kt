import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine(), " ")
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val cards = IntArray(N)
    
    st = StringTokenizer(readLine(), " ")
    repeat(N) { cards[it] = st.nextToken().toInt() }
    cards.sort()

    var res = 0

    for (i in 0 until N-2) {
        for (j in i+1 until N-1) {
            for (k in j+1 until N) {
                val sum = cards[i]+cards[j]+cards[k]

                if (sum > M) break
                if (sum > res) {
                    res = sum
                }
            }
            if (res == M) break
        }
        if (res == M) break
    }
    print(res)
}
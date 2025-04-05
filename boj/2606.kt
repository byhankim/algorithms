import java.util.StringTokenizer

// stack version
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    var result = 0
    
    val graph = Array(n+1) { mutableListOf<Int>() }
    val visited = BooleanArray(n+1)
    val s = ArrayDeque<Int>()
    
    repeat(m) {
        val st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        
        // 무방향이므로 양쪽 다 더하기
        graph[i].add(v)
        graph[v].add(i)
    }
    
    visited[1] = true
    s.addLast(1)
    
    while (s.isNotEmpty()) {
        val com = s.removeLast()
        
        for (c in graph[com]) {
            if (visited[c]) continue
            visited[c] = true
            s.addLast(c)
            result++
        }
    }
    print(result)
}
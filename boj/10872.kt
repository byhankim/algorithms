fun main() {
    val N = readLine()!!.toInt()
    print(factorial(N))
}

fun factorial(n: Int): Int {
    if (n == 0) return 1
    return n * factorial(n-1)
}
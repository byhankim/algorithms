fun main()  = with(System.`in`.bufferedReader()){

    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val N = readLine().toInt()

    repeat(N) {
        sb.appendLine(canStrfry(readLine()))
    }
    print(sb)
}

fun canStrfry(str: String) : String {
    val (str1, str2) = str.split(" ")
    val arr1 = IntArray(26)
    val arr2 = IntArray(26)

    str1.indices.forEach {
        arr1[str1[it] - 'a']++
        arr2[str2[it] - 'a']++
    }
    return if (arr1.contentEquals(arr2)) "Possible" else "Impossible"
}
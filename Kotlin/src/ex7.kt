fun main(args: Array<String>) {
    val str: String = readLine() ?: return;

    var zeros_count: Int = 0
    for (c in str) {
        if (c == '0') zeros_count++
    }
    println("${zeros_count} количество нулей")
}
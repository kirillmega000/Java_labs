fun main(args: Array<String>) {
    val str:String = readLine()?:"null"//Элвис-оператор
    val digit: Int? = when(str){
        "one" -> 1
        "two" -> 2
        "three" -> 3
        "zero" -> 0
        else -> null
    }
    println(digit ?:"Wrong string")
}
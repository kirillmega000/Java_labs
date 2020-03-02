import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val str:String= readLine()?:" "
    val list_of_numbers=str.split(",")
    var sum:Int=0
    for(number in list_of_numbers){
        sum+=try{number.toInt()}catch(e:NumberFormatException){0}
    }
    print("Sum= ${sum}")

}
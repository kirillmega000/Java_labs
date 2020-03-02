
fun calculateBugMentions(input:List<String>):Int = input.filter { o -> o=="BUG" }.count()
fun main(args: Array<String>) {
    var rec=Rectangle((readLine()?:0.toString()).toInt(),(readLine()?:0.toString()).toInt())
    print(rec.sq())
}
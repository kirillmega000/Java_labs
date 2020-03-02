fun main(args: Array<String>) {
    var str:String= readLine()?: return
    println(calculateWordStat(str))
}
fun calculateWordStat(input:String): String{
    var map:MutableMap<String, Int> = HashMap()
    var n:Int?=0
    var max="str" to 0
    for(str in input.split(' '))
    {
        n=map.get(str)
        if(n==null){
            map.put(str,1)
        }
        else{
            map.remove(str)
            map.put(str,n+1)
        }
    }

    for(it in map){
        if(it.component2()>max.component2())
            max=it.toPair()
    }
    return max.component1()
}
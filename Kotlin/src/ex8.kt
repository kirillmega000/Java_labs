fun calculateEvenDigits(input:String): Int{
    // enter your function code here
    var count:Int=0
    for(c in input){
        if(c.toString().toInt()%2==0) count+=c.toString().toInt()
    }
    return count
}


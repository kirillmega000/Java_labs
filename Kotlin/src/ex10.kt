class Player(var str:Int=0,var dex:Int=0,var XP:Int=0,var lvl:Int=1,var nextLvlXP:Int=10){
    public fun receiveXP(xp:Int){
        XP+=xp;
        while(XP>=nextLvlXP) lvlUP()
        println("str ${str} dex ${dex} lvl ${lvl}")
    }
    private fun lvlUP(){
        lvl+=1
        str+= if(lvl %2==0) 1 else 0
        dex+= if(lvl %2==1) 1 else 0
        XP-=nextLvlXP
        nextLvlXP+=10       

    }
}

fun main(args: Array<String>) {
    var p:Player=Player(str=2)
    p.receiveXP(10)
    p.receiveXP(40)
    p.receiveXP(70)

}
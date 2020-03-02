open class item(var lvl:Int,var weight:Double)

open class weapon( lvl:Int, weight:Double) :item(lvl,weight) {//var не нужен,т.к. используем конструктор базового класса
    open fun calcDamage():Int=42
}
class magic_weapon(lvl: Int,weight:Double) :weapon(lvl,weight){
    override fun calcDamage():Int=super.calcDamage()*2
}
fun main(args: Array<String>) {
    val instance:magic_weapon=magic_weapon(1,1.0)
    println("Damage=${instance.calcDamage()}")
}
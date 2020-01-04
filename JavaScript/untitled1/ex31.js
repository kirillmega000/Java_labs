
class animal {
    constructor(name="Noname"){
        this.name=name
    }
    walk() {
        console.log("Гуляет " + this.name)
    }

}
class Cat extends  animal{
    walk() {
        super.walk()
        console.log("и мяукает")
    }
}
new Cat("Джейк").walk()
//человеческое наследование
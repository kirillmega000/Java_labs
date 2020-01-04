//классы

class User{
    constructor(name){
        this.name=name
    }
    sayHi() {
        console.log(this.name)
    }
}
let user = new User("Алекс")

user.sayHi()
new User("Petr").sayHi()//анонимный объект
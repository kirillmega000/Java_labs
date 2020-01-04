class  User {
    constructor(first,last){
        this.first=first
        this.last=last
    }
    get fullName() {
        return `${this.first} ${this.last}`//getter и setter
    }
    set fullName(value) {
        [this.first, this.last]=value.split(" ")
    }
    static genGuest() {//static метод,как в Java
        return new User("Guest","Гость")
    }
}
let user=new User("Кирилл","Петухов")
console.log(user.fullName)
user.fullName="Egor Krid"
console.log(user.fullName)
console.log(User.genGuest().fullName)
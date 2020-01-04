
let methodname="name";
let man= {
   last:"Иванов",
    [methodname](){//название функции из String
        return "Вася";
    }
}
console.log(man["name"]());
console.log(man);
man.toString=function () {return "Man["+this.last+"]"; }//добавление метода в существующий объект
console.log(man.toString())
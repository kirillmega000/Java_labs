function Man (){
    this.last= "Ivanov";
    this.first= "Ivan";
    this.middle="Ivanovich";
    this.toString=function () {return "Man["+this.last+"]";
    }
};//класс(функция)

let man = new Man();
console.log(man.toString());
console.log(man);

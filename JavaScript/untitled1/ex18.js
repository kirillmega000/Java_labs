var e1 = new Object();
var e2 = {};
var man = {//безымянный объект
    last: 'Иванов',
    first:'Иван',
    middle:"Иванович",
    toString:function () {//можно без function и :
        return "Man[" + this.last + "]";
    }
};
console.log(man.last);
console.log(man.toString());
console.log(JSON.stringify(man));//запись объекта в формате JSON

//JSON-JavaScript Object Notation
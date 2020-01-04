
let animal = {
    walk :()=> console.log("Прибежал")
};
let rabbit = {
    __proto__:animal,
    walk(){console.log(super.walk.toString());super.walk()}
}

rabbit.walk()
//можно сделать то же самое,присвоив внешней переменной внутреннюю функцию walk(let walk = rabbit.walk)
//деление на модули
let animal =  {
    walk() {
        console.log("побежал")
    }
}
let cat={
    walk() {
        console.log("мяу")
    }



}
module.exports.cat=cat;
module.exports.animal=animal
console.log(module)
//global.animal=animal   -глобальная переменная


//генератор
function* generateSequence(result){
    console.log(result)
    result=yield "a";//передача параметра в генератор
    console.log(result)
    result=yield "b";
    console.log(result)
    return "c";

}
let i = 1;
let value;
let generator=generateSequence(i);

while(!(value=generator.next(++i)).done){

    console.log(value)
}
console.log(value)
console.log(i)
//создание последовательности для тестирования и отладки программы
//объект proxy для добавления свойств
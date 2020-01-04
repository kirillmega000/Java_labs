var man = {
    last: 'Иванов',
    first:'Иван',
};
man.age=24
if("age1"in man)
    console.log("Поле найдено")
else
    console.log("Поле не найдено")
console.log(man["first"])
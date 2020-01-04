let promise = new Promise((resolve , reject)=>{
    setTimeout(()=>{
        //reject(new Error("timeout"))//ошибка
       resolve("Correct")//корректное выполнение
        },
        500)
});
promise

    .then(//действия в зависимости от успешности выполнения
    result=>{console.log("Успешно "+ result);return result+"123"},
    error=>{console.log("Ошибка "+error.message)}


)
    .then(
     data=>{console.log("В цепочке "+data)},
     error=>{console.log("Ошибка "+error.message)}
    )

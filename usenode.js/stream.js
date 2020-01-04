
let fs = require("fs")
let stream=new fs.ReadStream(__filename)

stream.on("open",()=>console.log("open"))
stream.on('readable', function(){
    var data = stream.read();
    if(data)
        console.log(data.toString("utf-8"));
    else console.log("empty")
});
stream.on('end', function(){
    console.log("THE END");
});
stream.on('close', function(){
    console.log("close");
});
/*
Все синхронные обработчики ввода вывода срабатывают на следующей итерации событийного цикла, то есть заведомо после того, как весь текущий JavaScript закончит работу.
    Это означает, что я могу без проблем навесить все обработчики и я твердо знаю что они будут установлены до того как будет считан первый фрагмент данных.*/
//буфер 64k=>попадаем в readable каждые 64 килобайта данных
//данные параметры обработчиков универсальны для всех потоков


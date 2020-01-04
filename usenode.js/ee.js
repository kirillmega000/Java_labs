
let EventEmitter= require("events").EventEmitter;

let manager=new EventEmitter();
manager.on("request",(request)=>{
    request.myProperty = true})
manager.on("request",(request)=>{
    console.log(request)})
manager.emit("request",{data:"Данные"})
manager.emit("request",{data:"Еще данные"})
//обработчик событий
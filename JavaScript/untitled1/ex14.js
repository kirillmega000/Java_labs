function write(text){//функция
    if(!text)
        text="Пусто";
    console.log(text);
}
write("govno");
write();
let writ= function(text){//анонимная функция
    if(!text)
        text="Пусто";
    console.log(text);
}
writ("govno");
writ();
function show(text="заг",num=10){
    console.log(`${text} ${num}`)
}
show();
show("pedr");
show(undefined,12);
show("pedr",20);
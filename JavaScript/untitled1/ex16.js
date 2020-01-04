let data={
    title: "Test",
    height:20,
    width: 10
};


function show({title="Без названия",width=30,height=40}={}){
    console.log(`${title} ${width}x${height}`);
}
show(data);//объект в качестве параметра
show();
console.log(show.name);
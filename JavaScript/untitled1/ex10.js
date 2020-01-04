var a = ["a"];
a[10]= "b";
a[100]= "c";
for(var key in a)//перебор по индексам
    console.log(key,a[key]);
let arr=["a","b","c"];
for(var value of a)//перебор по значениям
    console.log(value);
for(var char of "Привет")//строка как массив
    console.log(char);

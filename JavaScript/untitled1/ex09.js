var x = [];
var y = [1,2,3]
var z = [1.2,"sa",false,
    function (t) {console.log(t);}]  ;
console.log(z.length);
for (let i = 0;i<z.length;i++)
    console.log("z[",i,"]=",z[i]);
z[3]("Вызов из массива");
//функция вызывается из массива
var a =["a","b","c"];
a.forEach(function (t) {
    console.log(t);
})
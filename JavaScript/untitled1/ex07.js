//for
for(let x = 0;x < 4; x++ )//при выходе из for x удаляется(let)
    console.log(x*x)
console.log(x*x)
for(var x = 0;x < 4; x++ )//при выходе из for let остается(var)
    console.log(x*x)
console.log(x*x)
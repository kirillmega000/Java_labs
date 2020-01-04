//вызов с задержкой
setTimeout(()=>console.log("4.timeout")
    ,1000)//задержка
setImmediate(()=>console.log("2.immediate"))//немедленное выполнение в следующем програмном цикле
setInterval(()=>console.log("3.interval"),700)//выполнение периодически с интервалом
console.log("1.last.row")//выполнение в текщем цикле
/*
1.last.row
2.immediate
3.interval
4.timeout
*/

//перидические задачи
let counter = 0
let interval = setInterval(()=>{
    console.log("countee",++counter)
    if(counter==3)
        clearInterval(interval)
},300)
console.log("last row")
//альтернатива
let counter = 0
setTimeout(work,300)
function work() {
    console.log("countee",++counter)
    if(counter!==3)
        setTimeout(work,300)
}
console.log("last row")
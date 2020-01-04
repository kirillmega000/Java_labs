//пример синхронного чтения файла

let http=require("http")
let fs=require("fs")
let server=http.createServer((req, res) => {
    let answer;
    if(req.url="/")
    {
        answer=fs.readFileSync("hello.txt")
        res.statusCode=200
    }
    else {
        answer="File not found"
        res.statusCode=404
    }
    res.end(answer)
})
server.listen(3000,'127.0.0.1',() => {
    console.log("Server running at","http://127.0.0.1:3000/")
})
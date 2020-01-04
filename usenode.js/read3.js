//пример асинхронного чтения файла

let http=require("http")
let fs=require("fs")
let server=http.createServer((req, res) => {
    let answer;
    if(req.url="/")

        answer=fs.readFile("index.html","utf-8",(err, data) => {//файл читается в бинарном виде,для преобразвания нужно в качестве параметра указать кодировку(utf-8)
            if(err){
                console.log(err)
                res.statusCode = 500
                res.end("Error reading file")
                return;
            }
            res.end(data)
            console.log("answered")
            })
})
server.listen(3000,'127.0.0.1',() => {
    console.log("Server running at","http://127.0.0.1:3000/")
})
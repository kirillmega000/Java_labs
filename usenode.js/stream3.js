//запись по частям
let http=require("http")
let fs = require("fs")
let server=http.createServer((req, res) => {
    let answer;
    if(req.url="/")

        sendFile(new fs.ReadStream("puk.jpg"),res)


})
server.listen(3000,'127.0.0.1',() => {
    console.log("Server running at","http://127.0.0.1:3000/")
})
function  sendFile(file,res) {
   file.pipe(res)
    file.on("error",()=>{
        res.end("404 File not found")
        res.statusCode=500
        })
    file.on("open", ()=>
        console.log("open")
        )

    file.on("close",()=>{
        console.log("close")
        file.destroy()//уничтожение файла при закрытии вкладки

    })
    file.on("end",()=>res.end())
}
//long-polling-непрерываемое соеденение

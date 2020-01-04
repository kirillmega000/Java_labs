//Echo сервер

let http=require("http")
let server=http.createServer((req, res) => {
    console.log(req.method,req.url)
    res.end(`${req.method} ${req.url}`)
})
server.listen(3000,'127.0.0.1',() => {
    console.log("Server running at","http://127.0.0.1:3000/")
})
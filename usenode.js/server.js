//http сервер
const http=require("http")
const server=
    http.createServer(
        (req, res) => {
            res.statusCode=200
            res.setHeader('Content-Type','text/plain')
            res.end("Hello World \n")
        }
    )
server.listen(3000,'127.0.0.1')

//можно через const server=new http.Server();server.on(requestListener)
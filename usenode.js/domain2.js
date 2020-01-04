
//аналог domain
const http=require("http")

    const server =
        http.createServer(
            (req, res) => {
                try{
                res.statusCode = 200
                res.setHeader('Content-Type', 'text/plain')
                res.end("Hello World \n")
                unknownFun()}
                catch (e) {
                    console.log(e.message)
                }
            }
        )
    server.listen(3000,'127.0.0.1',() => {
        console.log("Server running at","http://127.0.0.1:3000/")
    })


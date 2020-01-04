const PORT=4000
const d = require('domain').create();
d.on('error', (er) => {
    // The error won't crash the process, but what it does is worse!
    // Though we've prevented abrupt process restarting, we are leaking
    // resources like crazy if this ever happens.
    // This is no better than process.on('uncaughtException')!
    console.log(`error, but oh well ${er.message}`);
});
d.run(() => {
    require('http').createServer((req, res) => {
        res.statusCode=200
        res.setHeader('Content-Type','text/plain')
        res.end("Hello World \n")
        unknownFun();


    }).listen(PORT);
});

//использование domain для того,чтобы при налисии ошибки сервер не вырубался,но выводилось сообщение об ошибке
//также существует модуль cluster


































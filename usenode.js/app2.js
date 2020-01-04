//отладчик npm]
var winston = require('winston')
    , http = require('http')
    , name = 'My App';
let logger = winston.createLogger({
    levels:{
        debug:0,
        info:1,
        warn: 2,
        error: 3
    },

    transports: [
        //
        // - Write to all logs with level `info` and below to `combined.log`
        // - Write all logs error (and below) to `error.log`.
        //
        new winston.transports.Console,
        new winston.transports.File({ filename: 'combined.log' })
    ]
});
// fake app

logger.error('booting %o', name);

http.createServer(function(req, res){
    logger.info(req.method + ' ' + req.url);
    res.end('hello\n');
}).listen(4000, function(){
    logger.info('listening');
});

// fake worker of some kind

require('./worker2');
//операторы,для который отадчик выдает сообщения,натсраиваются с помощью переменной окружения DEBUG
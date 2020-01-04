//отладчик npm]
var debug = require('debug')('http')
    , http = require('http')
    , name = 'My App';

// fake app

debug('booting %o', name);

http.createServer(function(req, res){
    debug(req.method + ' ' + req.url);
    res.end('hello\n');
}).listen(3010, function(){
    debug('listening');
});

// fake worker of some kind

require('./worker');
//операторы,для который отадчик выдает сообщения,натсраиваются с помощью переменной окружения DEBUG
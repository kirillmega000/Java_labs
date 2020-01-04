//использование внешних журналов логирования
// include and initialize the rollbar library with your access token
var Rollbar = require("rollbar");
var rollbar = new Rollbar({
    accessToken: 'ca9215b6e6e94c9d84be85df619108a3',
});

// record a generic message and send it to Rollbar
rollbar.log("MyLog:Hello world!");
rollbar.debug("MyDebug:Hello World!")
//существует еще Raven
var winston= require("winston")
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
function work() {
    logger.log("debug",'doing lots of uninteresting work');
    setTimeout(work, Math.random() * 1000);
}

work();

function workb() {
    logger.debug('doing some work');
    setTimeout(workb, Math.random() * 2000);
}

workb();

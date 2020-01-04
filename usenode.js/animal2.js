//использование JSON
let lang = require("./ru")//ссылка на Json файл ru.json
let animal =  {
    walk() {
        console.log(lang.run)
    }
}
console.log("Animal", lang.loaded);
module.exports.animal=animal;

//для создания конфигурационных файлов
//можно ипользовать папку.тогда главный js файл назыаем Index.js

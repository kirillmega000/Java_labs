
let user = {name:"Вася"};
let visitors={ isAdmin:false};
let admin={visits:true}

Object.assign(user,visitors,admin)//объеденение объектов в один
let clone = Object.assign({},user)//клонирование объекта(перезапись user в пустой новый объект)
console.log(user)
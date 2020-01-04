 let map = new Map();//пара ключ-значение
map.set('1','строка')
map.set(1,'число')
map.set(true,'логическое')

console.log(map.get(1))
console.log(map.get('1'))
console.log(map.size)
let set = new Set();//как массив,только без повторяющ.элементов и не гарантирует последовательность возврата


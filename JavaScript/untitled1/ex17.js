let inc1=(x)=>x+1;
let inc2= function (x) {return x + 1};

console.log(inc1(1));
console.log(inc2(1));

let sum = (a,b) =>{ return (a + b)};
console.log(sum(2,3));

let getTime = () => new Date().getHours() + ":" + new Date().getMinutes();
console.log(getTime());
//лямбды в JavaScript
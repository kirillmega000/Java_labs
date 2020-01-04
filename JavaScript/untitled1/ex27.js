function F() {this.name="Kirill"}
F.prototype= {m:function(){
console.log("kill-real")}
}
function B() {}
B.prototype=new F;
B.prototype.f="Hello world"
var test=new B();
console.log(test.name)
test.m();
console.log(test.f)
//наследование в JavaScript с помомщью прототипов.К прототипу напрямую иожно обратиться через свойство __proto__
var man = {
    last: 'Иванов',
    first:'Иван',
    get fullName() {//getter
        return `${this.last} ${this.first}`
    }
};
console.log(man.fullName)
console.log(man)

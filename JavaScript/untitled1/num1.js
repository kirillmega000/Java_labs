let man = {
    name:"Tape",
    surname:"as",
    fullName(){
        return `${this.name} ${this.surname}`
    }

}
class Room {
    Windows=5
    _owner="no"
    set owner (value)
    {
        this._owner=`${value} 123`
    }
    get owner ()
    {
        return this._owner
    }
}
let room=new Room();
room.owner="vasya"
console.log(room.owner)
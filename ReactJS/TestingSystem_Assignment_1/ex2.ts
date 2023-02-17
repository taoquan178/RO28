//Question 1:
const luong1 : GLfloat = 5240.5;
const luong2 : GLfloat = 10970.055;
var Account1 = {
        name: "Quân",
        luong: luong1
}
var Account2 = {
    name: "Hiếu",
    luong: luong2
}
// Datatype Casting
const l1: number = <number> <any> Math.round(Account1.luong);
const l2: number = <number> <any> Math.round(Account2.luong);
console.log(l1)
console.log(l2)

//Question 2:
const ramdomNumber : number = Math.floor(Math.random() * 99999) + 0;
let stringRamdomNumber : string = ramdomNumber+"";
if( stringRamdomNumber.length == 4){
    stringRamdomNumber  = "0"+stringRamdomNumber;
}if (stringRamdomNumber.length == 3) {
    stringRamdomNumber  = "00"+stringRamdomNumber;
}if (stringRamdomNumber.length == 2) {
    stringRamdomNumber  = "000"+stringRamdomNumber;
}if (stringRamdomNumber.length == 1) {
    stringRamdomNumber  = "0000"+stringRamdomNumber;
} 
console.log(stringRamdomNumber)

//Question 3:
const subStringRamdomNumber : string = stringRamdomNumber.substring(3,5);
console.log(subStringRamdomNumber)
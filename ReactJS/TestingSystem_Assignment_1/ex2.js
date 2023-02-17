//Question 1:
var luong1 = 5240.5;
var luong2 = 10970.055;
var Account1 = {
    name: "Quân",
    luong: luong1
};
var Account2 = {
    name: "Hiếu",
    luong: luong2
};
var l1 = Math.round(Account1.luong);
var l2 = Math.round(Account2.luong);
console.log(l1);
console.log(l2);
//Question 2:
var ramdomNumber = Math.floor(Math.random() * 99999) + 0;
var stringRamdomNumber = ramdomNumber + "";
if (stringRamdomNumber.length == 4) {
    stringRamdomNumber = "0" + stringRamdomNumber;
}
if (stringRamdomNumber.length == 3) {
    stringRamdomNumber = "00" + stringRamdomNumber;
}
if (stringRamdomNumber.length == 2) {
    stringRamdomNumber = "000" + stringRamdomNumber;
}
if (stringRamdomNumber.length == 1) {
    stringRamdomNumber = "0000" + stringRamdomNumber;
}
console.log(stringRamdomNumber);
//Question 3:
var subStringRamdomNumber = stringRamdomNumber.substring(3, 5);
console.log(subStringRamdomNumber);

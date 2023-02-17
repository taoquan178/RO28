const array : string[] = ['a', 'b', 'c', 'd', 'e'];
array.forEach(function(value) {
    console.log(value);
})
console.log("đảo ngược lại")
const arrayReverse = array.reverse();
arrayReverse.forEach(function(value) {
    console.log(value);
})
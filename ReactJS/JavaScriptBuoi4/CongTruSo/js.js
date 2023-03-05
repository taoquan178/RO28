let stringNumber = document.getElementById('number')
let numhjasd = 0;
document.getElementById('tru').addEventListener('click', function(){
    numhjasd--;
    stringNumber.innerHTML = numhjasd;
})
document.getElementById('cong').addEventListener('click', function(){
    numhjasd++;
    stringNumber.innerHTML = numhjasd;
})
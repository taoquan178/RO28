let randomNumber = Math.floor((Math.random() * 20)+1);
let guessCount = 0;
document.querySelector('.again').addEventListener('click', function() {
    refreshGame();
})

function refreshGame(){
    randomNumber = Math.floor((Math.random() * 20)+1);
    guessCount = 0;
    document.querySelector('body').style.backgroundColor = "#222"
}

document.querySelector('.check').addEventListener('click', function() {
    const number = document.querySelector('.guess').value;
    const message = document.querySelector('.message');
    if(number == null || number == undefined){
        alert('Bạn cần nhập số để check!')
    }
    guessCount++
    const score = document.querySelector('.label-score').innerHTML ='💯 Score: '+ guessCount;
    if(score > 20){
        message.innerHTML = `Bạn chỉ có 20 lần đoán ${guessCount}`
        refreshGame
        return;
    } else if (number > 20 || number < 0) {
        message.innerHTML = "(Between 1 and 20)"
        return;
    }
    checkNumber(number,guessCount,message);
})

function checkNumber(number,guessCount,message) {
    if(randomNumber == number ){
        message.innerHTML = `Bạn đã đoán đúng số rồi! số lần đoán ${guessCount}`
        document.querySelector('body').style.backgroundColor = "#60b347"
    } else if(randomNumber > number){
        message.innerHTML = "Số cần đoán lớn hơn"
    } else if (randomNumber < number) {
        message.innerHTML = "Số cần đoán bé hơn"
    }
}
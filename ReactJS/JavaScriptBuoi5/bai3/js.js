document.getElementById('btn-submit').addEventListener('click', function(){
    const height = document.getElementById('height').value;
    const weight = document.getElementById('weight').value;

    let text =""
    const bmi = weight/(height*2);
    if(bmi>= 25){
        text = "Thừa cân"
    } else if(bmi < 18.5){

    }

    const showText = document.querySelector('.say-hello').innerHTML = text+ bmi
    test();
})

function test(){
    const a = "test 1"
    return`
    <h2> ${a} </h2>
    `
}

// document.querySelector('.image-box').style.backgroundimage = "url('https://donoithatdanang.com/wp-content/uploads/2021/11/hinh-anh-anime-nam-buon-3.jpg')"

window.onload = function() {

}

let obj = [
    {id: 1 , name: 'Product 1', pice: 20},
    {id: 2 , name: 'Product 2', pice: 25},
    {id: 3 , name: 'Product 3', pice: 10},
    {id: 4 , name: 'Product 4', pice: 30}
]

let listProduct = [];

function handleHome(){
    const header = document.getElementById('header')
    header.innerHTML = "\n <p>Trang Chủ</p>"

    const tabIcon = document.getElementsByClassName('tab-icon--home')
    tabIcon[0].classList.add("ative")
    tabIcon[1].classList.add("ative")

    removeTabColor('tab-icon--message','tab-icon--account','tab-icon--cart')
    showSlide();
    addProduct();
}

function handleCart(){
    const header = document.getElementById('header')
    header.innerHTML = "\n <p>Giỏ Hàng</p>"

    const tabIcon = document.getElementsByClassName('tab-icon--cart')
    tabIcon[0].classList.add("ative")
    tabIcon[1].classList.add("ative")

    removeHome();
    addListCartProduct();
    removeSlide();
    removeTabColor('tab-icon--message','tab-icon--account','tab-icon--home')
}

function handleMessage(){
    const header = document.getElementById('header')
    header.innerHTML = "\n <p>Tin Nhắn</p>"

    const tabIcon = document.getElementsByClassName('tab-icon--message')
    tabIcon[0].classList.add("ative")
    tabIcon[1].classList.add("ative")

    removeHome();
    removeSlide();
    removeTabColor('tab-icon--account','tab-icon--cart','tab-icon--home')
}

function handleAccount(){
    const header = document.getElementById('header')
    header.innerHTML = "\n <p>Thông Tin</p>"

    const tabIcon = document.getElementsByClassName('tab-icon--account')
    tabIcon[0].classList.add("ative")
    tabIcon[1].classList.add("ative")

    removeHome();
    removeSlide();
    removeTabColor('tab-icon--message','tab-icon--cart','tab-icon--home')
}

function removeHome(){
    const aa = document.getElementById('products')
    aa.innerHTML = "";
}

function removeTabColor(className1,className2,className3){
  const name1 =  document.getElementsByClassName(className1)
  const name2 =  document.getElementsByClassName(className2)
  const name3 =  document.getElementsByClassName(className3)

  name1[0].classList.remove("ative")
  name1[1].classList.remove("ative")

  name2[0].classList.remove("ative")
  name2[1].classList.remove("ative")

  name3[0].classList.remove("ative")
  name3[1].classList.remove("ative")
}

function removeSlide(){
    const slide = document.getElementById('slides')
    slide.innerHTML = ""
}

function showSlide(){
    const slide = document.getElementById('slides')
    slide.innerHTML = '<img class="img" src="./assets/img/img1.jpg" alt="">'
}


function addProduct(){
    const product = document.getElementById('products')
    product.innerHTML = objProduct() ;
}

function objProduct(){
    
    let product = "";
    for(let i = 0; i < obj.length; i++){
        product = product + `
        <div class="product">
        <div class="product-img">
            <img src="./assets/img/img2.jpg" alt="">
        </div>
        <p class="product-name">${obj[i].name}</p>
        <div class="product-content">
            <p>${obj[i].pice}$</p>
            <i class="fa-solid fa-cart-shopping tab-icon"onclick="saveProduct(${obj[i].id})"></i>
        </div>
        </div>
        `
    }
    return product;
}

function saveProduct(productId){
    const product = obj.find(product => product.id === productId); 
    listProduct.push(product)
}

function addListCartProduct(){
    let totalMoney = 0;
    listProduct.forEach(element => {
        totalMoney += element.pice
    });

    const total =  document.createElement("div").innerHTML = `Total = ${totalMoney} `;
    const product = document.getElementById('products')
    product.innerHTML = cartProduct() + total;
   
}

function cartProduct(){
    const cart = listProduct;
    let listCartProduct = "";
    for(let i = 0; i < cart.length; i++){
        listCartProduct = listCartProduct + `
        <div class="listProduct">
                <img src="./assets/img/img1.jpg" alt="">
                <p>${cart[i].name}</p>
                <p>${cart[i].pice}$</p>
            </div>
        `
    }
    return listCartProduct;
}
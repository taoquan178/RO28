//Question 1:
var fullName = "name1"
function hello(){
    const fullName = "name2"
    console.log(LexicalScope(),fullName);
    
    function LexicalScope(){
        return "name3"
    }
}

console.log(fullName)
console.log(hello())

//Question 2:
function printName(MyName: String){
    console.log("Tên tôi là: "+ MyName)
}
printName("Nguyễn Trung Quân");

//Question 3:
function getGreeting(firstName:String, lastName:String){

    const greeting = function(){
        return  firstName + " " + lastName;
    }
    return greeting;
}

console.log(getGreeting("Trung","Quân"));

//Question 4:
for(let i=1; i<=6;i++){
    setTimeout(function(){
        console.log(i);
    },i*1000);
}

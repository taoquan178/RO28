const textarea = document.getElementById('textarea');

textarea.addEventListener('keyup',function (event) {
    if(event.key === 'Enter') {
        stringTextarea();
    }
})

function stringTextarea(){
    const textareaArray = textarea.value.trim().split(" ")
    document.getElementById("tags").innerHTML = textareaArray; 
    textarea.value = "";
    
}
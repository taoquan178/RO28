$(function() {
    var isRememberMe = storage.getRememberMe();
    document.getElementById('rememberMe').checked = isRememberMe;
    addEventListener();
});

function addEventListener(){

    $('#btn-login').on('click', function(){
        login();
    })

   
}

function login(){
    const username = $('#userName').val();
    const password = $('#userPassword').val();

    // validate 
    if(!username && !password){
        showErrorMessageLogin("Chưa Nhập User Name và Password")
        return;
    }

    if(!username){
        showErrorMessageLogin("Chưa nhập User Name")
        return;
    }

    if(!password){
        showErrorMessageLogin("Chưa Nhập Password")
        return;
    }

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/login',
        // contentType: "application/json; charset=UTF-8",
        dataType: 'json',

        beforeSend: function(xhr){
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(username + ':' + password));
        },
        success: function(data,textStatus, xhr){

            // save remember me to Storage 
            var isRememberMe = document.getElementById('rememberMe').checked;
            storage.saveRememberMe(isRememberMe);

            // save to Storage
            storage.setItem('ID', data.id);
            storage.setItem('FULL_NAME', data.fullName);
            storage.setItem('TYPE', data.type);
            storage.setItem('USERNAME', username);
            storage.setItem('PASSWORD', password);

            window.location.replace("http://127.0.0.1:5500/index.html")
        },
        error: function(jqXHR, textStatus, errorThrown){
            if(jqXHR.status == 401 ){
                showErrorMessageLogin("Tài khoản hoặc mật khẩu không đúng!")
            } else {
                console.error(jqXHR);
                console.error(textStatus);
                console.error(errorThrown);
            }
        },
        complete: function(){

        }
    });
}

function showErrorMessageLogin(errorMessage){
    document.getElementById('errorMessage-login').innerHTML = errorMessage;
    document.getElementById('errorMessage-login').style.display = "block";
}

function hideErrorMessageLogin(){
    document.getElementById('errorMessage-login').style.display = "none";
}
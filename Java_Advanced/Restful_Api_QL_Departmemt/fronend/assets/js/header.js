$(function() {
    document.getElementById('account-fullName').innerHTML = 'Xin chào: ' + storage.getItem('FULL_NAME')
    addEventListenerHeader();
});

function addEventListenerHeader(){

    $('#btn-logout').on('click', function(){
        logout();
    })
}

function logout(){
    storage.removeItem('ID');
    storage.removeItem('FULL_NAME');
    storage.removeItem('TYPE');
    storage.removeItem('USERNAME');
    storage.removeItem('PASSWORD');

    // redirect to login
    window.location.replace("http://127.0.0.1:5500/assets/html/login.html")
}
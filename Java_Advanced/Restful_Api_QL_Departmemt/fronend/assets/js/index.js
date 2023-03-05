// function này chỉ chạy khi nội dung của body html đã load xong
// document.addEventListener('DOMContentLoaded', function() {
// });

// giống câu lệnh trên nhưng jquery nó hỗ trợ nên ngắn đi
$(function() {
    $('#header').load('./assets/html/header.html');
    $('#main').load('./assets/html/main.html');
    $('#footer').load('./assets/html/footer.html');
});





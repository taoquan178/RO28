$(function() {
    if(!checkLogin()){
        window.location.replace("http://127.0.0.1:5500/assets/html/login.html")
    }
    addListenersAccount();
    getAllAccount();
    getAllDepartment();
});

function checkLogin() {
    if(storage.getItem('ID')){
        return true;
    }
    return false;
}

// các sự kiện
function addListenersAccount() {

    // $('#list-account').on('click',function(event){
    //     getAllAccount();
    //     getAllDepartment();
    // });

    // sự kiện chọn dữ liệu trong table account
    $('#tbody').on('click','tr',function(event){
        $(this).addClass('selected').siblings().removeClass('selected'); // this là thằng tr được bấm vào
    });

    // sự kiện xoá account
    $('#btn-delete').on('click',function(event){
        deleteAccount();
    });

    // sự kiện create account
    $('#btn-create').on('click',function(event){
        createAccount();
    });

    // sự kiện edit account
    $('#btn-update').on('click',function(event){
        updateAccount();
    });

    // gán dữ liệu từ trường đang selected vào modal update
    $('#btn-edit').on('click',function(){
        const selectedRow = $('.selected');
        $('#from-id-update').val(selectedRow.find('.id').text());
        $('#from-name-update').val(selectedRow.find('.name').text());
        $('#from-fullName-update').val(selectedRow.find('.fullName').text());
        $('#from-type-update').val(selectedRow.find('.type').text());
        // $('#from-departmentId-update').val(selectedRow.find('.departmentName').text());
        // if($('#from-departmentId-update').find('option').text() == selectedRow.find('.departmentName').text()){
            
        // }
    });
}

// updateAccount
function updateAccount() {
    const id = $('#from-id-update').val();
    $.ajax({
        method: 'PUT',
        url: 'http://localhost:8080/account/update/'+id,
        data: JSON.stringify({
            id: id,
            name: $('#from-name-update').val(),
            fullName: $('#from-fullName-update').val(),
            type: $('#from-type-update').val(),
            departmentId: $('#from-departmentId-update').val()
        }),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        success: function(data) {
            // ẩn dòng đang được chọn đi
            $('.selected').hide(function(){
                // sau khi ẩn thì đổi tên rồi lại show nó ra
                $('.selected').find('.name').text(data.name);
                $('.selected').find('.fullName').text(data.fullName);
                $('.selected').find('.type').text(data.type);
                $('.selected').find('.departmentName').text(data.departmentName);
                $('.selected').show();
            });
            alert("Cập nhập thành công!");
        }
    });
};

// createAccount
function createAccount(){
    $.ajax({
        method: 'POST',
        url: 'http://localhost:8080/account/add',
        data: JSON.stringify({
            name: $('#from-name').val(),
            fullName: $('#from-fullName').val(),
            type: $('#from-type').val(),
            email: $('#from-email').val(),
            password: $('#from-password').val(),
            departmentId: $('#from-departmentId').val()
        }), // body
        contentType: "application/json; charset=UTF-8", // type of body (json, xml , text)
        // dataType: 'json', // dataType return  trả về kiểu dữ liệu thì để còn trả về dạng text thì nên đóng nó lại vì nó sẽ tự hiểu cái string text đó là json
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        success: function(data) {
            alert("Thêm thành công!");
            showAccount(data);
        }
    });

};

// delete account
function deleteAccount() {
    // lấy ra id của thằng đang được selected
    const id = $('.selected').find('.id').text();
    $.ajax({
        method: 'DELETE',
        url: 'http://localhost:8080/account/delete/' + id,
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        success: function(data) {
            $('.selected').remove();
            alert("xoá thành công!");
        }
    });
};

// Gọi dữ liệu account
function getAllAccount() {
    console.log(btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/account',
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        success: function(data) {
            if( data == undefined || data == null ) {
                alert("Error when loading data")
            }
            showAllAccount(data);
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        complete: function() {
            hideLoading();
        }
    });
}

function showAllAccount(accounts) {
    const tbody = $('#tbody');
    for (const account of accounts) {
        tbody.append(`
            <tr>
                <th class="id">${account.id}</th>
                <th class="name">${account.name}</th>
                <th class="fullName">${account.fullName}</th>
                <th class="type">${account.type}</th>
                <th class="email">${account.email}</th>
                <th class="departmentName">${account.departmentName}</th>
            </tr>
        `)
    }
}

function showAccount(account) {
    $('#tbody').append(`
        <tr>
            <th class="id">${account.id}</th>
            <th class="name">${account.name}</th>
            <th class="fullName">${account.fullName}</th>
            <th class="type">${account.type}</th>
            <th class="email">${account.email}</th>
            <th class="departmentName">${account.departmentName}</th>
        </tr>
    `)
}

function getAllDepartment() {
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/department/getall',
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        success: function(data){
            selectDepartment(data);
        },
        complete: function() {
            hideLoading();
        }
    });
};

// slect department bên add và update account
function selectDepartment(departments){
    const fromSelect = $('.select-department');
    for (const department of departments) {
        fromSelect.append(`
            <option value="${department.id}">${department.name}</option>
        `)
    }

}


function showLoading() {

}

function hideLoading(){

}
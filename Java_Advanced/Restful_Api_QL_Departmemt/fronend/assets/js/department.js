$(function() {
    addListenersDepartment();
    buildTableDepartment();
});

function addListenersDepartment() {

    // $('#list-department').on('click', function(event) {
    //     buildTableDepartment();
    // })

    $('#btn-searchDepartment').on('click', function(event) {
        searchDepartmentsName();
    })

    $('#btn-add-depratment').on('click', function(event) {
        refreshFromCreate();
    })

    $('#btn-create-department').on('click', function(event) {
        createDepartment();
    });

    $('#btn-update-department').on('click', function(event) {
        updateDepartment();
    });

    $('#btn-deleteAll-depratment').on('click', function(event) {
        deleteAllDepartment();
    })

    $('#bnt-refresh-department').on('click', function(event) {
        refreshTableDepartment();
    })

};

function refreshTableDepartment(){
    $('#searchDepartment').val("")
    refreshFromUpdate();
    refreshFromCreate();
    resetPageable();
    buildTableDepartment();
}

function buildTableDepartment(){
    $('#tbody-depratment').empty();
    getPageDepartment();
}

function refreshFromUpdate(){
    $('#from-name-update-department-v2').val("")
    hideMessageFromUpdate();
}

function refreshFromCreate(){
    $('#from-name-department').val("");
    hideMessageFromCreate();
}

// mess from create
function showMessageFromCreate(errorMessage){
    document.getElementById('errorMessage-name-create').innerHTML = errorMessage;
    document.getElementById('errorMessage-name-create').style.display = "block";
}

function hideMessageFromCreate(){
    document.getElementById('errorMessage-name-create').style.display = "none";
}

// mess from update
function showMessageFromUpdate(errorMessage){
    document.getElementById('errorMessage-name-update').innerHTML = errorMessage;
    document.getElementById('errorMessage-name-update').style.display = "block";
}

function hideMessageFromUpdate(){
    document.getElementById('errorMessage-name-update').style.display = "none";
}

// alert
function alertSuccess(successMessage){
    const alert1 = document.getElementById('alert');
    alert1.classList.add('alert-success') 
    alert1.classList.add('alert')
    alert1.innerHTML = successMessage;
    setTimeout(function(){
        alert1.classList.remove('alert-success')
        alert1.classList.remove('alert')
        alert1.innerHTML = ""
    },3000);
}

function alertDanger(errorMessage){
    const alert1 = document.getElementById('alert');
    alert1.classList.add('alert-danger') 
    alert1.classList.add('alert')
    alert1.innerHTML = successMessage;
    setTimeout(function(){
        alert1.classList.remove('alert-danger')
        alert1.classList.remove('alert')
        alert1.innerHTML = ""
    },3000);
}

// kiểm tra chuỗi chỉ có chữ và số
function onlyLettersAndNumbers(str) {
    return Boolean(str.match(/^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ 0-9]+$/));
}


function createDepartment() {
    const name = $('#from-name-department').val();

    // validate name > 3 and <= 30 kí tự
    if(!name || name.length < 3 || name.length >= 30){
        showMessageFromCreate("Department name > 3 and <= 30 characters!")
        return;
    }
    
    // không chứa kí tự đặc biệt
    if(!onlyLettersAndNumbers(name)){
        showMessageFromCreate("Department name không được chứa kí tự đặc biệt")
        return;
    }

    // validate unique name
    $.ajax({
        method: 'GET',
        url: "http://localhost:8080/department/"+ name + "/exist",
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        success: function(data){
            if(data){
                showMessageFromCreate("Department name is exist!")
            }else{
        
                $.ajax({
                    method: 'POST',
                    url: 'http://localhost:8080/department/add',
                    data: JSON.stringify({
                        name: name
                    }),
                    contentType: "application/json; charset=UTF-8",
                    beforeSend: function(xhr){
                        showLoading();
                        xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        alertDanger("Tạo không thành công!")
                        console.error(jqXHR);
                        console.error(textStatus);
                        console.error(errorThrown);
                    },
                    success: function(data) {
                        alertSuccess("Thêm thành công!")
                        hideMessageFromCreate();
                        resetPageable();
                        buildTableDepartment();
                    }
                });
        
            }
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
};

function deleteDepartment(id) {
    const result = confirm("Bạn có chắc muốn xoá "+ id +" này không?");
    if(result){
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost:8080/department/delete/'+id,
            beforeSend: function(xhr){
                showLoading();
                xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
            },
            error: function(jqXHR, textStatus, errorThrown){
                alertDanger("Xoá thất bại");
                console.error(jqXHR);
                console.error(textStatus);
                console.error(errorThrown);
            },
            success: function(data){
                alertSuccess('Xoá thành công!');
                resetPageable();
                buildTableDepartment();
            }
        });
    }
};

var departments = [];
let curentPage = 1;
let size = 5;
let sortField = "id";
let isAsc = false;

function getPageDepartment() {
    // reset list
    departments = []; 

    let url = 'http://localhost:8080/department';
    url += '?page=' + curentPage +'&size='+ size;
    url += '&sort=' + sortField + ',' + (isAsc ? "asc" : "desc");

    $.ajax({
        method: 'GET',
        url: url,
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        success: function(data){
            $('#tbody-depratment').empty();
            departments = data.content;
            showAllDepartment(data.content);
            pageDepartment(data.totalPages);
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
};

function searchDepartment(dataSearch) {
    // reset list
    departments = []; 

    let url = 'http://localhost:8080/department/search';
    url += '?data=' + dataSearch;
    url += '&page=' + curentPage +'&size='+ size;

    $.ajax({
        method: 'GET',
        url: url,
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
            departments = data.content;
            $('#tbody-depratment').empty();
            showAllDepartment(data.content);
            pageDepartment(data.totalPages);
        },
        complete: function() {
            hideLoading();
        }
    });
};

function searchDepartmentsName(){
    const dataSearch = $('#searchDepartment').val().trim();
    if(dataSearch == null || dataSearch == undefined || dataSearch == ""){
        return;
    }
    searchDepartment(dataSearch);
}

function pageDepartment(page){
    let pageNumber =""
    if(page > 1){
        if(curentPage  > 1){
            pageNumber += `<li class="page-item"><a class="page-link" href="#" onclick="previousPage()">Previous</a></li>`
        }
        for(let i = 0; i < page; i++){
            pageNumber += `<li class="page-item ${curentPage == i+1 ? "active" : "" }"><a class="page-link" href="#" onclick="changePage(${(i+1)})">${i+1}</a></li>`
        }
        if(curentPage < page){
            pageNumber += `<li class="page-item"><a class="page-link" href="#"  onclick="nextPage()">Next</a></li>`
        }
    }

    $('#pageNumber').empty();
    $('#pageNumber').append(pageNumber);
}

function resetPageable(){
    curentPage = 1;
    size = 5;
    sortField = "id";
    isAsc = false;
}

function previousPage(){
    changePage(curentPage - 1);
}

function nextPage(){
    changePage(curentPage + 1);
}

function changePage(page){
    if(page == curentPage){
        return;
    }
    curentPage = page;
    buildTableDepartment();
}

function changeSort(field){
    if(sortField == field){
        isAsc = !isAsc;
    }else{
        sortField = field;
        isAsc = true;
    }
    buildTableDepartment();
}


function showAllDepartment(departments){
    const tbodyDepartment = $('#tbody-depratment');
    departments.forEach(function(department,index){
        tbodyDepartment.append(`
            <tr>
                <th><input type="checkbox" id="checkBox-${index}" onclick="checkBoxItem()" ></th>
                <th class="name-department">${department.name}</th>
                <th class="action-department">
                <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modal-update-department-v2" onclick="getDepartmentById(${department.id})"><i class="bi bi-pencil-square"></i></button>
                <button type="button" class="btn btn-danger" onclick="deleteDepartment(${department.id})"> <i class="bi bi-trash"></i></button>
                </th>
            </tr>
        `)
    });

};

// update department v2 , call api để gán giá trị
function getDepartmentById(id){
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/department/'+ id,
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        error: function(jqXHR, textStatus, errorThrown){
            alertDanger('Lấy dữ liệu không thành công!')
            console.error(jqXHR);
            console.error(textStatus);
            console.error(errorThrown);
        },
        success: function(data){
            valueUpdateModalDepartment(data);
        }
        
    })
}

// gán dữ liệu vào input
function valueUpdateModalDepartment(department){
    refreshFromUpdate();
    $('#from-name-update-department-v2').val(department.name)
    $('#btn-update-department-v2').on('click',function(event){
        updateDepartmentV2(department.id, department.name)
    })
}

function updateDepartmentV2(id,oldName){
    const name = $('#from-name-update-department-v2').val();

     // validate name > 3 and <= 30 kí tự
     if(!name || name.length < 3 || name.length >= 30){
        showMessageFromUpdate("Department name > 3 and <= 30 characters!")
        return;
    }

     // không chứa kí tự đặc biệt
     if(!onlyLettersAndNumbers(name)){
        showMessageFromCreate("Department name không được chứa kí tự đặc biệt")
        return;
    }

    // validate unique name
    if(name == oldName){
        alertSuccess("Cập nhập thành công!");
        hideMessageFromUpdate();
        return;
    }

    $.ajax({
        method: 'GET',
        url: "http://localhost:8080/department/"+ name + "/exist",
        beforeSend: function(xhr){
            showLoading();
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa(storage.getItem("USERNAME") + ':' + storage.getItem("PASSWORD")));
        },
        success: function(data){
            if(data){
                showMessageFromUpdate("Department name is exist!")
            }else{
        
                $.ajax({
                    method: 'PUT',
                    url: 'http://localhost:8080/department/update/'+ id,
                    data: JSON.stringify({
                        name: name
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
                        alertSuccess("Cập nhập thành công!");
                        hideMessageFromUpdate();
                        buildTableDepartment();
                    },
                    error: function(error) {
                        alertDanger("Cập nhập không thành công!")
                    }
                })
        
            }
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
// end update department v2

// delete nhiều  
function deleteAllDepartment(){
    let ids = [];
    let names = [];
    let i = 0;
    while (true) {
        let checkBox = document.getElementById('checkBox-'+i);
        if(checkBox != undefined || checkBox != null){
            if(checkBox.checked){
                ids.push(departments[i].id)
                names.push(departments[i].name)
            }
            i++
        }else{
            break;
        }
    }

    const isDelete = confirm("Bạn có chắc muốn xoá "+ names + " chứ!")
    if(isDelete){
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost:8080/department/deletelist?ids='+ids,
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
                // error
                if(data == undefined || data == null){
                    alert("Error when loading data");
                    return;
                }
                // success
                alertSuccess("Xoá thành công!");
                document.getElementById('checkBox-all').checked = false;
                resetPageable();
                buildTableDepartment();
            },
        });
    }
}

// đang chọn all, mà 1 thằng bỏ chọn thì chọn all sẽ tắt, chuyển thành chọn nhiều
function checkBoxItem(){
    let i = 0;
    while (true) {
        let checkBox = document.getElementById('checkBox-'+i);
        if(checkBox != undefined || checkBox != null){
            if(!checkBox.checked){
                document.getElementById('checkBox-all').checked = false;
                return;
            }
            i++
        }else{
            break;
        }
    }
    document.getElementById('checkBox-all').checked = true;
}

// chọn all
function checkedAllDepartment(){
    let i = 0;
    while (true) {
        let checkBox = document.getElementById('checkBox-'+i);
        if(checkBox != undefined || checkBox != null){
            checkBox.checked = document.getElementById('checkBox-all').checked;
            i++
        }else{
            break;
        }
    }
}
// end delete nhiều



function showLoading() {

}

function hideLoading(){

}


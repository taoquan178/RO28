// // 1. Thêm 3 job bổ sung vào phần 'job' của trang bằng cách sao chép 'job-card'
// ban đầu. 
// // 2. Cập nhật tiêu đề của các job mới thành : JavaScript Developer,
// Java Developer, Python Developer 
// // 3. Cập nhật Jobs listed thành tổng số công
// việc hiện có trong trang 
// // 4. Nhập tên công việc vào ô tìm kiếm để lọc các công
// việc (lọc theo tên công việc). Những công việc được tìm thấy sẽ hiển thị ra, còn
// lại sẽ bị ẩn đi 
// // 5. Bấm vào Nút "All jobs" để reset ô tìm kiếm và hiển thị ra
// tất cả các công việc

const job = document.querySelector('.job-card')
const divJob = document.querySelector('.jobs')
const newJob =  job.cloneNode(true)
divJob.appendChild(newJob)

const job1 = document.querySelector('.job-card')
const divJob1 = document.querySelector('.jobs')
const newJob1 =  job1.cloneNode(true)
divJob.appendChild(newJob1)

const job2 = document.querySelector('.job-card')
const divJob2 = document.querySelector('.jobs')
const newJob2 =  job2.cloneNode(true)
divJob.appendChild(newJob2)

const h3 = document.querySelectorAll('h3')
for(let i=0; i<h3.length; i++){
    console.log(h3[i])
    h3[i].classList.add('h3-'+i)
}
const h31 = document.querySelector('.h3-1').innerHTML = "JavaScript Developer"
const h32 = document.querySelector('.h3-2').innerHTML = "Java Developer"
const h33 = document.querySelector('.h3-3').innerHTML = "Python Developer"

let countListjob = 4;

function addJob(){
    countListjob++
    const job = document.querySelector('.job-card')
    const divJob = document.querySelector('.jobs')
    const newJob =  job.cloneNode(true)
    divJob.appendChild(newJob)
    document.querySelector('.text-center').innerHTML = `Danh sách công việc hiện có ${countListjob}` 

}

function search(){
    const seachJob = document.getElementById('search').value;
    console.log(seachJob)
}







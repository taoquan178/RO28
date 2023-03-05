// <!-- // 1. Một tính năng mới vào gói Pro: '24/7 Phone support'  -->
// <!-- // 2. Đổi vị trí 2 card pricing (pro, basic) => (basic, pro)  -->
// <!-- // 3. Trong gói Pro hãy cập nhật nút
// 'Get Started' hiện tại thành màu xanh có màu background: #0984e3, có chữ màu
// #fff và có dòng chữ 'Buy Now'  -->
// <!-- // 4. Tăng dung lượng lưu trữ của gói Pro thêm 25%, gói Basic thêm 50% -->

const ul = document.getElementById('basic')
const li = document.createElement('li').innerHTML = '24/7 Phone support';
ul.append(li)

document.getElementById('btn-pro').style.background = "#0984e3"
document.getElementById('btn-pro').style.color = "white"





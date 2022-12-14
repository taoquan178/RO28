package frontend;

import static backend.Exercise_5_Inheritance_Q2.*;
import static backend.Exercise_5_Inheritance_Q4.*;

import entity.HighSchoolStudent;
public class Program4 {
    public static void main(String[] args) {
        /**
         * Question 2: Tiếp tục Question 1
         * Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực
         * hiện các chức năng sau:
         * a) Thêm mới cán bộ.
         * b) Tìm kiếm theo họ tên.
         * c) Hiện thị thông tin về danh sách các cán bộ.
         * d) Nhập vào tên của cán bộ và delete cán bộ đó
         * e) Thoát khỏi chương trình.
         */
        System.out.println("Question 2");
        Menu();

        /**
         * Question 3 (Optional): constructor inheritance
         * Tạo class abstract Person gồm các property name và tạo constructor có
         * 1 parameter name
         * Tạo class abstract Student kế thừa Person gồm các property id, name
         * và tạo constructor có 2 parameter id, name
         * Tạo class HighSchoolStudent kế thừa Student bao gồm các property id,
         * name, clazz (Lớp đang học), desiredUniversity (trường đại học mong
         * muốn vào) và tạo constructor có 4 parameter id, name, clazz,
         * desiredUniversity.
         * Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name =
         * "Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công
         * nghệ
         */
        System.out.println("Question 3");
        HighSchoolStudent highSchoolStudent = new HighSchoolStudent(1,"Quân","ROCKET28","RMIT");
        System.out.println(highSchoolStudent);

        /**
         * Question 4 (Optional):
         * Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
         * tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
         * Tên nhà xuất bản, số bản phát hành.
         * Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
         * Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
         * Các báo cần quản lý thêm: Ngày phát hành.
         * Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
         * cách hiệu quả.
         * Xây dựng lớp QuanLySach có các chức năng sau
         * a) Thêm mới tài liêu: Sách, tạp chí, báo.4
         * b) Xoá tài liệu theo mã tài liệu.
         * c) Hiện thị thông tin về tài liệu.
         * d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
         * e) Thoát khỏi chương trình.
         */
        System.out.println("Question 4");
        QLTV();

    }
}

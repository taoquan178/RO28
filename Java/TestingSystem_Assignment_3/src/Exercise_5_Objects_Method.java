public class Exercise_5_Objects_Method {
    public static void main(String[] args) {
        // Create Department
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Bảo Vệ";

        Department department4 = new Department();
        department4.id = 4;
        department4.name = "Giám Đốc";

        Department department5 = new Department();
        department5.id = 5;
        department5.name = "Thư Ký";
        //Question 1:
        //In ra thông tin của phòng ban thứ 1 (sử dụng toString())\
        System.out.println("\nQuestion 1:");
        System.out.println(department1);
        //Question 2:
        //In ra thông tin của tất cả phòng ban (sử dụng toString())
        System.out.println("\nQuestion 2:");
        Department[] departmentArray = {department1,department2,department3,department4,department5};
        for ( Department department : departmentArray){
            System.out.println(department);
        }

        //Question 3:
        //In ra địa chỉ của phòng ban thứ 1
        System.out.println("\nQuestion 3:");
        System.out.println(department1.hashCode());

        //Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
        System.out.println("\nQuestion 4:");
        if (department1.name.equals("Phòng A")){
            System.out.println("Nó là Phòng A");
        }else {
            System.out.println("Nó là Phòng "+department1.name);
        }
        //Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
        //không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
        if (department1.name.equals(department2.name)){
            System.out.println("2 Phòng ban bằng nhau");
        }else {
            System.out.println("2 Phòng ban không bằng nhau");
        }
        //Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
        //sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
        //VD:
        //Accounting
        //Boss of director
        //Marketing
        //Sale
        //Waiting room

    }
}

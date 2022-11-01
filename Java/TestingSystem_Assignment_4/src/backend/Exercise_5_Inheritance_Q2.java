package backend;
import entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_5_Inheritance_Q2 {
    public static void  Menu(){
        ArrayList<CanBo> ListCanBo;
        ListCanBo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
                while (true){
            System.out.println("===========================");
            System.out.println("1: Thêm mới cán bộ");
            System.out.println("2: Tìm kiếm cán bộ");
            System.out.println("3: Danh sách cán bộ");
            System.out.println("4: Xoá cán bộ");
            System.out.println("0: Thoát");
            System.out.println("===========================");
            System.out.print("Mời bạn nhập lựa chọn: ");

            int chon = scanner.nextInt();
            switch (chon){
                case 0:
                    return;
                case 1:
                    System.out.println("===========================");
                    System.out.println("Bạn chọn thêm mới cán bộ");
                    System.out.println("1: Thêm công nhân");
                    System.out.println("2: Thêm kỹ sư");
                    System.out.println("3: Thêm nhân viên");
                    System.out.println("===========================");
                    System.out.print("Chọn loại cán bộ cần thêm: ");
                    int chon1 = scanner.nextInt();
                    switch (chon1){
                        case 1:
                            System.out.print("Nhập tên Công Nhân: ");
                            String tenCongNhan = scanner.next();
                            System.out.print("Nhập tuổi Công Nhân: ");
                            int tuoiCongNhan = scanner.nextInt();
                            System.out.print("Nhập địa chỉ Công Nhân: ");
                            String diaChiCongNhan = scanner.next();
                            System.out.print("Nhập số Bậc Công Nhân: ");
                            int bacCongNhan = scanner.nextInt();
//                            while (true){
//                                if (bacCongNhan >= 1 && bacCongNhan <= 10){
//                                    return;
//                                }else {
//                                    System.out.println("Chỉ được nhập từ 1~10");
//                                }
//                            }

                            System.out.println("1: Nam - 2: Nữ - 3: Unknown");
                            int genderCongNhan = scanner.nextInt();
                            CanBo.Gender gioiTinh = null;
                            switch (genderCongNhan){
                                case 0:
                                    gioiTinh = CanBo.Gender.UNKNOWN;
                                    break;
                                case 1:
                                    gioiTinh = CanBo.Gender.NAM;
                                    break;
                                case 2:
                                    gioiTinh = CanBo.Gender.NU;
                                    break;
                                default:
                                    System.out.println("Mời bạn nhập lại");
                            }

                            CanBo congNhan = new entity.CongNhan(tenCongNhan,tuoiCongNhan,gioiTinh,diaChiCongNhan,bacCongNhan);
                            ListCanBo.add(congNhan);
                            break;

                        case 2:
                            System.out.print("Nhập tên Ký Sư: ");
                            String nameKySu = scanner.next();
                            System.out.print("Nhập tuổi  Ký Sư: ");
                            int ageKySu = scanner.nextInt();
                            System.out.print("1: Nam - 2: Nữ - 3: Unknown");
                            int genderKySu = scanner.nextInt();
                            CanBo.Gender gioiTinh1 = null;
                            switch (genderKySu) {
                                case 1:
                                    gioiTinh1 = CanBo.Gender.UNKNOWN;
                                    break;
                                case 2:
                                    gioiTinh1 = CanBo.Gender.NAM;
                                    break;
                                case 3:
                                    gioiTinh1 = CanBo.Gender.NU;
                                    break;
                            }
                            System.out.print("Nhập địa chỉ  Ký Sư: ");
                            String diaChiKySu = scanner.next();
                            System.out.print("Nhập chuyên ngành  Ký Sư: ");
                            String chuyenNganhKySu = scanner.next();
                            CanBo kySu = new KySu(nameKySu, ageKySu, gioiTinh1, diaChiKySu, chuyenNganhKySu);
                            ListCanBo.add(kySu);
                            break;

                        case 3:
                            System.out.print("Nhập tên Nhân Viên: ");
                            String nameNhanVien = scanner.next();
                            System.out.println("Nhập tuổi Nhân Viên: ");
                            int ageNhanVien = scanner.nextInt();
                            System.out.print("1: Nam - 2: Nữ - 3: Unknown");
                            int flagEmployee = scanner.nextInt();
                            CanBo.Gender gioiTinh2 = null;
                            switch (flagEmployee) {
                                case 1:
                                    gioiTinh2 = CanBo.Gender.UNKNOWN;
                                    break;
                                case 2:
                                    gioiTinh2 = CanBo.Gender.NAM;
                                    break;
                                case 3:
                                    gioiTinh2 = CanBo.Gender.NU;
                                    break;
                            }
                            System.out.print("Nhập địa chỉ Nhân Viên: ");
                            String diaChiNhanVien = scanner.next();
                            System.out.print("Nhập nhiệm vụ Nhân Viên: ");
                            String nhiemVuNhanVien = scanner.next();
                            CanBo Employee = new NhanVien(nameNhanVien, ageNhanVien, gioiTinh2, diaChiNhanVien, nhiemVuNhanVien);
                            ListCanBo.add(Employee);
                            break;
                        default:
                            System.out.println("Mời bạn nhập lại");

                    }
                    break;
                case 2:
                    System.out.print("Mời bạn nhập vào tên cán bộ cần tìm: ");
                    String timTen = scanner.next();
                    for (CanBo canbo: ListCanBo){
                        if (canbo.getName().equals(timTen)){
                            System.out.println(canbo);
                        }
                    }
                    break;
                case 3:
                    for (CanBo canbo : ListCanBo){
                        System.out.println(canbo);
                    }
                    break;
                case 4:
                    System.out.print("Mời bạn nhập vào tên cán bộ cần xoá: ");
                    String xoaTen = scanner.next();
                    ListCanBo.removeIf(CanBo -> CanBo.getName().equals(xoaTen));
                    for (CanBo canbo : ListCanBo){
                        System.out.println(canbo);
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }

}

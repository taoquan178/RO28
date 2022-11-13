package org.example.vti.menu;

import org.example.vti.controller.PositionController;
import org.example.vti.entity.Position;
import org.example.vti.repository.PositionRepository;
import org.example.vti.service.impl.PositionServiceImpl;
import org.example.vti.util.ScannerUtils;

import java.util.List;

public class MenuPosition {
    public static void menuPosition() {
        PositionRepository pRepository = new PositionRepository();
        PositionServiceImpl pService = new PositionServiceImpl(pRepository);
        PositionController pController = new PositionController(pService);
        while (true){
            System.out.println("================Menu Project==============");
            System.out.println("1: Show position                         |");
            System.out.println("2: Create position                       |");
            System.out.println("3: update position                       |");
            System.out.println("4: delete position                       |");
            System.out.println("0: Exit position                         |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    List<Position> positions = pController.getListPosition();
                    System.out.println("==========Danh Sách Position==========");
                    for (Position position : positions){
                        System.out.println(position);
                    }
                    break;
                case 2:
                    Position position = new Position();
                    System.out.println("Mời bạn chọn position");
                    System.out.println("1: Dev - 2: Test - 3: Scrum Master - 4: PM");
                    int choice1 = ScannerUtils.inputInt();
                    switch (choice1){
                        case 1:
                            position.setPositionName("Dev");
                            pController.createPosition(position);
                            break;
                        case 2:
                            position.setPositionName("Test");
                            pController.createPosition(position);
                            break;
                        case 3:
                            position.setPositionName("Scrum Master");
                            pController.createPosition(position);
                            break;
                        case 4:
                            position.setPositionName("PM");
                            pController.createPosition(position);
                            break;
                        default:
                            System.err.println("Bạn chỉ được nhập từ 1->4");
                    }
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào id: ");
                    int positionID = ScannerUtils.inputInt();
                    Position position1 = new Position();
                    position1.setId(positionID);
                    System.out.println("Mời bạn chọn position muốn đổi: ");
                    System.out.println("1: Dev - 2: Test - 3: Scrum Master - 4: PM");
                    int choice2 = ScannerUtils.inputInt();
                    switch (choice2){
                        case 1:
                            position1.setPositionName("Dev");
                            pController.updatePosition(position1);
                            break;
                        case 2:
                            position1.setPositionName("Test");
                            pController.updatePosition(position1);
                            break;
                        case 3:
                            position1.setPositionName("Scrum Master");
                            pController.updatePosition(position1);
                            break;
                        case 4:
                            position1.setPositionName("PM");
                            pController.updatePosition(position1);
                            break;
                        default:
                            System.err.println("Bạn chỉ được nhập từ 1->4");
                    }
                    break;
                case 4:
                    System.out.println("Mời bạn nhập vào prosition id muốn xoá: ");
                    int positionID1 = ScannerUtils.inputInt();
                    Position position2 = new Position();
                    position2.setId(positionID1);
                    pController.deletePosition(position2);
                    System.out.println(position2);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}

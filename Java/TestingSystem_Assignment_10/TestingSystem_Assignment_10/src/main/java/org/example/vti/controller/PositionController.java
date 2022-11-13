package org.example.vti.controller;

import org.example.vti.entity.Position;
import org.example.vti.service.PositionService;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    public List<Position> getListPosition(){
        List<Position> positions = new ArrayList<>();
        try {
            positions = positionService.getListPosition();
            System.out.println("Lấy danh sách position thành công");
        }catch (Exception e){
            System.err.println("Lấy danh sách position không thành công!");
        }
        return positions;
    }

    public void createPosition(Position position){
        try {
            positionService.createPosition(position);
        }catch (Exception e){
            System.err.println("Tạo position không thành công!");
        }
    }

    public void updatePosition(Position position){
        try {
            positionService.updatePosition(position);
        }catch (Exception e){
            System.err.println("Cập nhập position không thành công!");
        }
    }

    public void deletePosition(Position position){
        try {
            positionService.deletePosition(position);
        }catch (Exception e){
            System.err.println("Xoá position không thành công!");
        }
    }
}

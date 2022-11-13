package org.example.vti.service.impl;

import org.example.vti.entity.Position;
import org.example.vti.repository.PositionRepository;
import org.example.vti.service.PositionService;
import org.example.vti.util.Utils;

import java.sql.SQLException;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getListPosition() throws SQLException {
        return positionRepository.getListPosition();
    }

    @Override
    public void createPosition(Position position) throws SQLException {
        int result = positionRepository.createPosition(position);
        if (result > 0){
            System.out.println("Tạo dữ liệu thành công");
        } else {
            System.err.println("Tạo dữ liệu thất bại!");
        }
    }

    @Override
    public void updatePosition(Position position) throws SQLException {
        List<Position> positionList = positionRepository.getListPosition();
        boolean validate = Utils.validatePosition(positionList,position);
        if (validate){
            int result = positionRepository.updatePosition(position);
            if (result > 0){
                System.out.println("Cập nhập dữ liệu thành công");
            } else {
                System.err.println("Cập nhập dữ liệu thất bại!");
            }
        }else {
            throw new RuntimeException("Không có id này trong position!");
        }
    }

    @Override
    public void deletePosition(Position position) throws SQLException {
        List<Position> positionList = positionRepository.getListPosition();
        boolean validate = Utils.validatePosition(positionList,position);
        if (validate){
            int result = positionRepository.deletePosition(position);
            if (result > 0){
                System.out.println("Xoá dữ liệu thành công");
            } else {
                System.err.println("Xoá dữ liệu thất bại!");
            }
        }else {
            throw new RuntimeException("Không có id này trong position!");
        }
    }
}

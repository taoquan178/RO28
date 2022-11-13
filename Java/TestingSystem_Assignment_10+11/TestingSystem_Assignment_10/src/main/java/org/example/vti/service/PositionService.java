package org.example.vti.service;

import org.example.vti.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionService {
    List<Position> getListPosition()throws SQLException;
    void createPosition(Position position)throws SQLException;
    void updatePosition(Position position)throws SQLException;
    void deletePosition(Position position)throws SQLException;
}

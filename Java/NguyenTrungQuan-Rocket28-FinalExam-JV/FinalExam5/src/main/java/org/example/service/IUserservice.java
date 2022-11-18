package org.example.service;

import org.example.entity.User;

import java.sql.SQLException;

public interface IUserservice {
    void getListUsers() throws SQLException;
    void getUserByProjectId( int projectId ) throws SQLException;
    void loginUser( String email, String password ) throws SQLException;
    void createUser(User user)throws SQLException;
    void createUserManager(User user, int projectId, int expInYear)throws SQLException;
    void createUserEmployee(User user, int projectId,String proSkill)throws SQLException;
}

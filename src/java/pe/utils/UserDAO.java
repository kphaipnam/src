/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.entity.user;

/**
 *
 * @author HOME
 */
public class UserDAO {

    private static final String LOGIN_QUERY = "SELECT *FROM tblUsers where userID=? and [password] = ? ";
    private static final String CHECK_DUP = "SELECT COUNT(*) FROM tblUsers WHERE userID=?";

    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    public user login(String userID, String Password) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            pre = conn.prepareStatement(LOGIN_QUERY);
            pre.setString(1, userID);
            pre.setString(2, Password);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new user(rs.getString("userID"), rs.getString("fullName"),rs.getString("roleID"),rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            closeResources();
        }
        return null;
    }

}

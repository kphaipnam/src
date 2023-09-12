/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.entity.fashion;

/**
 *
 * @author HOME
 */
public class FashionDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    public List<fashion> getlist() {
        String query = "SELECT id, name, description, price, size, status \n"
                + "From tblFashion";
        try {
            conn = new DBUtils().getConnection();
            pre = conn.prepareStatement(query);
            rs = pre.executeQuery();
            List<fashion> list = new ArrayList<>();
            while (rs.next()) {
                fashion fash = new fashion(rs.getString("id"),rs.getString("name"), rs.getString("description"),rs.getFloat("price"), rs.getString("size"), rs.getBoolean("status"));
                list.add(fash);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}

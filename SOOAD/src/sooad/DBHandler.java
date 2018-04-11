/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sooad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vighnesh
 */
public class DBHandler {

    static Connection con;
    static private Statement st;
    static private ResultSet rs;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static ResultSet getResult(String query) {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static void insert(String query) {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static public String[][] getData(String query) {
        String s[][]=null;
        int i = 0;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            st=con.createStatement();
            rs = st.executeQuery(query);
            s = new String[100][rs.getMetaData().getColumnCount()];
            while (rs.next()) {
                for (int j = 0; j < rs.getMetaData().getColumnCount(); j++) {
                    s[i][j] = rs.getString(j + 1);
                }
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }
    static public void addData(String s) {
        System.out.println(s);
        try {
            st.executeUpdate(s);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

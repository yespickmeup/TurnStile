/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import turnstile.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Users {

    public static class to_users {

        public final int id;
        public final String screen_name;
        public final String username;
        public final String password;
        public final int status;
        public final String created_by;
        public final String updated_by;
        public final String created_at;
        public final String updated_at;

        public to_users(int id, String screen_name, String username, String password, int status, String created_by, String updated_by, String created_at, String updated_at) {
            this.id = id;
            this.screen_name = screen_name;
            this.username = username;
            this.password = password;
            this.status = status;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }
    }

    public static void add_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into users("
                    + "screen_name"
                    + ",username"
                    + ",password"
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + ")values("
                    + ":screen_name"
                    + ",:username"
                    + ",:password"
                    + ",:status"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:created_at"
                    + ",:updated_at"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", to_users.screen_name)
                    .setString("username", to_users.username)
                    .setString("password", to_users.password)
                    .setNumber("status", to_users.status)
                    .setString("created_by", to_users.created_by)
                    .setString("updated_by", to_users.updated_by)
                    .setString("created_at", to_users.created_at)
                    .setString("updated_at", to_users.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update users set "
                    + "screen_name= :screen_name "
                    + ",username= :username "
                    + ",password= :password "
                    + ",status= :status "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + " where id='" + to_users.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", to_users.screen_name)
                    .setString("username", to_users.username)
                    .setString("password", to_users.password)
                    .setNumber("status", to_users.status)
                    .setString("created_by", to_users.created_by)
                    .setString("updated_by", to_users.updated_by)
                    .setString("created_at", to_users.created_at)
                    .setString("updated_at", to_users.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from users  "
                    + " where id='" + to_users.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_data(String where) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",username"
                    + ",password"
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                int status = rs.getInt(5);
                String created_by = rs.getString(6);
                String updated_by = rs.getString(7);
                String created_at = rs.getString(8);
                String updated_at = rs.getString(9);

                to_users to = new to_users(id, screen_name, username, password, status, created_by, updated_by, created_at, updated_at);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}

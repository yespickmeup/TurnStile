/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.access_logs;

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
public class Access_logs {

    public static class to_access_logs {

        public final int id;
        public final String id_no;
        public final String fname;
        public final String mname;
        public final String lname;
        public final String year_level;
        public final String course;
        public final String college;
        public final int status;
        public final String created_by;
        public final String updated_by;
        public final String created_at;
        public final String updated_at;

        public to_access_logs(int id, String id_no, String fname, String mname, String lname, String year_level, String course, String college, int status, String created_by, String updated_by, String created_at, String updated_at) {
            this.id = id;
            this.id_no = id_no;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.year_level = year_level;
            this.course = course;
            this.college = college;
            this.status = status;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }
    }

    public static void add_data(to_access_logs to_access_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into access_logs("
                    + "id_no"
                    + ",fname"
                    + ",mname"
                    + ",lname"
                    + ",year_level"
                    + ",course"
                    + ",college"
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + ")values("
                    + ":id_no"
                    + ",:fname"
                    + ",:mname"
                    + ",:lname"
                    + ",:year_level"
                    + ",:course"
                    + ",:college"
                    + ",:status"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:created_at"
                    + ",:updated_at"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_access_logs.id_no)
                    .setString("fname", to_access_logs.fname)
                    .setString("mname", to_access_logs.mname)
                    .setString("lname", to_access_logs.lname)
                    .setString("year_level", to_access_logs.year_level)
                    .setString("course", to_access_logs.course)
                    .setString("college", to_access_logs.college)
                    .setNumber("status", to_access_logs.status)
                    .setString("created_by", to_access_logs.created_by)
                    .setString("updated_by", to_access_logs.updated_by)
                    .setString("created_at", to_access_logs.created_at)
                    .setString("updated_at", to_access_logs.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Access_logs.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_access_logs to_access_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update access_logs set "
                    + "id_no= :id_no "
                    + ",fname= :fname "
                    + ",mname= :mname "
                    + ",lname= :lname "
                    + ",year_level= :year_level "
                    + ",course= :course "
                    + ",college= :college "
                    + ",status= :status "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + " where id='" + to_access_logs.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_access_logs.id_no)
                    .setString("fname", to_access_logs.fname)
                    .setString("mname", to_access_logs.mname)
                    .setString("lname", to_access_logs.lname)
                    .setString("year_level", to_access_logs.year_level)
                    .setString("course", to_access_logs.course)
                    .setString("college", to_access_logs.college)
                    .setNumber("status", to_access_logs.status)
                    .setString("created_by", to_access_logs.created_by)
                    .setString("updated_by", to_access_logs.updated_by)
                    .setString("created_at", to_access_logs.created_at)
                    .setString("updated_at", to_access_logs.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Access_logs.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_access_logs to_access_logs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from access_logs  "
                    + " where id='" + to_access_logs.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Access_logs.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_access_logs> ret_data(String where) {
        List<to_access_logs> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",id_no"
                    + ",fname"
                    + ",mname"
                    + ",lname"
                    + ",year_level"
                    + ",course"
                    + ",college"
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + " from access_logs"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String id_no = rs.getString(2);
                String fname = rs.getString(3);
                String mname = rs.getString(4);
                String lname = rs.getString(5);
                String year_level = rs.getString(6);
                String course = rs.getString(7);
                String college = rs.getString(8);
                int status = rs.getInt(9);
                String created_by = rs.getString(10);
                String updated_by = rs.getString(11);
                String created_at = rs.getString(12);
                String updated_at = rs.getString(13);

                to_access_logs to = new to_access_logs(id, id_no, fname, mname, lname, year_level, course, college, status, created_by, updated_by, created_at, updated_at);
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

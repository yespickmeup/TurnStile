/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.students;

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
public class Students {

    public static class to_students {

        public final int id;
        public final String id_no;
        public final String fname;
        public final String mname;
        public final String lname;
        public final String year_level;
        public final String course;
        public final int status;
        public final String created_by;
        public final String updated_by;
        public final String created_at;
        public final String updated_at;
        public boolean selected;

        public to_students(int id, String id_no, String fname, String mname, String lname, String year_level, String course, int status, String created_by, String updated_by, String created_at, String updated_at, boolean selected) {
            this.id = id;
            this.id_no = id_no;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.year_level = year_level;
            this.course = course;
            this.status = status;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

    public static void add_data(to_students to_students) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into students("
                    + "id_no"
                    + ",fname"
                    + ",mname"
                    + ",lname"
                    + ",year_level"
                    + ",course"
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
                    + ",:status"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:created_at"
                    + ",:updated_at"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_students.id_no)
                    .setString("fname", to_students.fname)
                    .setString("mname", to_students.mname)
                    .setString("lname", to_students.lname)
                    .setString("year_level", to_students.year_level)
                    .setString("course", to_students.course)
                    .setNumber("status", to_students.status)
                    .setString("created_by", to_students.created_by)
                    .setString("updated_by", to_students.updated_by)
                    .setString("created_at", to_students.created_at)
                    .setString("updated_at", to_students.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Students.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data(List<to_students> to_students1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_students to_students : to_students1) {
                String s0 = "insert into students("
                        + "id_no"
                        + ",fname"
                        + ",mname"
                        + ",lname"
                        + ",year_level"
                        + ",course"
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
                        + ",:status"
                        + ",:created_by"
                        + ",:updated_by"
                        + ",:created_at"
                        + ",:updated_at"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("id_no", to_students.id_no)
                        .setString("fname", to_students.fname)
                        .setString("mname", to_students.mname)
                        .setString("lname", to_students.lname)
                        .setString("year_level", to_students.year_level)
                        .setString("course", to_students.course)
                        .setNumber("status", to_students.status)
                        .setString("created_by", to_students.created_by)
                        .setString("updated_by", to_students.updated_by)
                        .setString("created_at", to_students.created_at)
                        .setString("updated_at", to_students.updated_at)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

            Lg.s(Students.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_students to_students) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update students set "
                    + "id_no= :id_no "
                    + ",fname= :fname "
                    + ",mname= :mname "
                    + ",lname= :lname "
                    + ",year_level= :year_level "
                    + ",course= :course "
                    + ",status= :status "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + " where id='" + to_students.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_students.id_no)
                    .setString("fname", to_students.fname)
                    .setString("mname", to_students.mname)
                    .setString("lname", to_students.lname)
                    .setString("year_level", to_students.year_level)
                    .setString("course", to_students.course)
                    .setNumber("status", to_students.status)
                    .setString("created_by", to_students.created_by)
                    .setString("updated_by", to_students.updated_by)
                    .setString("created_at", to_students.created_at)
                    .setString("updated_at", to_students.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Students.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_students to_students) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from students  "
                    + " where id='" + to_students.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Students.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(List<to_students> to_students1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_students to_students : to_students1) {
                String s0 = "delete from students  "
                        + " where id='" + to_students.id + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

            Lg.s(Students.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_students> ret_data(String where) {
        List<to_students> datas = new ArrayList();

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
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + " from students"
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
                int status = rs.getInt(8);
                String created_by = rs.getString(9);
                String updated_by = rs.getString(10);
                String created_at = rs.getString(11);
                String updated_at = rs.getString(12);

                to_students to = new to_students(id, id_no, fname, mname, lname, year_level, course, status, created_by, updated_by, created_at, updated_at, false);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> levels(String where) {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " year_level"
                    + " from students"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                String year_level = rs.getString(1);

//                System.out.println("year_level: " + year_level);
                datas.add(year_level);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static List<String> courses(String where) {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + " course"
                    + " from students"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                String year_level = rs.getString(1);

//                System.out.println("year_level: " + year_level);
                datas.add(year_level);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}

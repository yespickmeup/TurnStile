/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.faculty_and_staffs;

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
public class Faculty_and_staffs {

    public static class to_faculty_and_staffs {

        public final int id;
        public final String id_no;
        public final String fname;
        public final String mname;
        public final String lname;
        public final String college;
        public final int status;
        public final String created_by;
        public final String updated_by;
        public final String created_at;
        public final String updated_at;
        public boolean selected;

        public to_faculty_and_staffs(int id, String id_no, String fname, String mname, String lname, String college, int status, String created_by, String updated_by, String created_at, String updated_at, boolean selected) {
            this.id = id;
            this.id_no = id_no;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.college = college;
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

    public static void add_data(to_faculty_and_staffs to_faculty_and_staffs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into faculty_and_staffs("
                    + "id_no"
                    + ",fname"
                    + ",mname"
                    + ",lname"
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
                    + ",:college"
                    + ",:status"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:created_at"
                    + ",:updated_at"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_faculty_and_staffs.id_no)
                    .setString("fname", to_faculty_and_staffs.fname)
                    .setString("mname", to_faculty_and_staffs.mname)
                    .setString("lname", to_faculty_and_staffs.lname)
                    .setString("college", to_faculty_and_staffs.college)
                    .setNumber("status", to_faculty_and_staffs.status)
                    .setString("created_by", to_faculty_and_staffs.created_by)
                    .setString("updated_by", to_faculty_and_staffs.updated_by)
                    .setString("created_at", to_faculty_and_staffs.created_at)
                    .setString("updated_at", to_faculty_and_staffs.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Faculty_and_staffs.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data(List<to_faculty_and_staffs> to_faculty_and_staff1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_faculty_and_staffs to_faculty_and_staffs : to_faculty_and_staff1) {
                String s0 = "insert into faculty_and_staffs("
                        + "id_no"
                        + ",fname"
                        + ",mname"
                        + ",lname"
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
                        + ",:college"
                        + ",:status"
                        + ",:created_by"
                        + ",:updated_by"
                        + ",:created_at"
                        + ",:updated_at"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("id_no", to_faculty_and_staffs.id_no)
                        .setString("fname", to_faculty_and_staffs.fname)
                        .setString("mname", to_faculty_and_staffs.mname)
                        .setString("lname", to_faculty_and_staffs.lname)
                        .setString("college", to_faculty_and_staffs.college)
                        .setNumber("status", to_faculty_and_staffs.status)
                        .setString("created_by", to_faculty_and_staffs.created_by)
                        .setString("updated_by", to_faculty_and_staffs.updated_by)
                        .setString("created_at", to_faculty_and_staffs.created_at)
                        .setString("updated_at", to_faculty_and_staffs.updated_at)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

            Lg.s(Faculty_and_staffs.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_faculty_and_staffs to_faculty_and_staffs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update faculty_and_staffs set "
                    + "id_no= :id_no "
                    + ",fname= :fname "
                    + ",mname= :mname "
                    + ",lname= :lname "
                    + ",college= :college "
                    + ",status= :status "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + " where id='" + to_faculty_and_staffs.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("id_no", to_faculty_and_staffs.id_no)
                    .setString("fname", to_faculty_and_staffs.fname)
                    .setString("mname", to_faculty_and_staffs.mname)
                    .setString("lname", to_faculty_and_staffs.lname)
                    .setString("college", to_faculty_and_staffs.college)
                    .setNumber("status", to_faculty_and_staffs.status)
                    .setString("created_by", to_faculty_and_staffs.created_by)
                    .setString("updated_by", to_faculty_and_staffs.updated_by)
                    .setString("created_at", to_faculty_and_staffs.created_at)
                    .setString("updated_at", to_faculty_and_staffs.updated_at)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Faculty_and_staffs.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_faculty_and_staffs to_faculty_and_staffs) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from faculty_and_staffs  "
                    + " where id='" + to_faculty_and_staffs.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Faculty_and_staffs.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(List<to_faculty_and_staffs> to_faculty_and_staffs1) {
        try {
            Connection conn = MyConnection.connect();
            for (to_faculty_and_staffs to_faculty_and_staffs : to_faculty_and_staffs1) {
                String s0 = "delete from faculty_and_staffs  "
                        + " where id='" + to_faculty_and_staffs.id + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

            Lg.s(Faculty_and_staffs.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_faculty_and_staffs> ret_data(String where) {
        List<to_faculty_and_staffs> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",id_no"
                    + ",fname"
                    + ",mname"
                    + ",lname"
                    + ",college"
                    + ",status"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + " from faculty_and_staffs"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String id_no = rs.getString(2);
                String fname = rs.getString(3);
                String mname = rs.getString(4);
                String lname = rs.getString(5);
                String college = rs.getString(6);
                int status = rs.getInt(7);
                String created_by = rs.getString(8);
                String updated_by = rs.getString(9);
                String created_at = rs.getString(10);
                String updated_at = rs.getString(11);

                to_faculty_and_staffs to = new to_faculty_and_staffs(id, id_no, fname, mname, lname, college, status, created_by, updated_by, created_at, updated_at, false);
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

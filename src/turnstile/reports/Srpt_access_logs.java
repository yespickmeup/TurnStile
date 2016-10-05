/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.reports;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import turnstile.util.DateType;

import turnstile.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Srpt_access_logs {

    public final List<field> fields;
    public final String date;
    public final String group;
    public final String total_rows;
    public final String total_count;
    public final String per;

    public Srpt_access_logs(String date, String group, String total_rows, String total_count, String per) {
        this.fields = new ArrayList();
        this.date = date;
        this.group = group;
        this.total_rows = total_rows;
        this.total_count = total_count;
        this.per = per;
    }

    public static class field {

        String id_no;
        String fname;
        String mname;
        String lname;
        String year_level;
        String course;
        String college;
        String group;
        String date;
        int count;

        public field() {
        }

        public field(String id_no, String fname, String mname, String lname, String year_level, String course, String college, String group, String date, int count) {
            this.id_no = id_no;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.year_level = year_level;
            this.course = course;
            this.college = college;
            this.group = group;
            this.date = date;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getId_no() {
            return id_no;
        }

        public void setId_no(String id_no) {
            this.id_no = id_no;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getMname() {
            return mname;
        }

        public void setMname(String mname) {
            this.mname = mname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getYear_level() {
            return year_level;
        }

        public void setYear_level(String year_level) {
            this.year_level = year_level;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }

    public static void main(String[] args) {

        List<Srpt_access_logs.field> datas = Srpt_access_logs.ret_data(" group by id");
        String date = "01/01/2016 - 01/02/2016";
        String group = "All";
        String total_rows = "20";
        String total_count = "25";
        String per = "Individual";
        Srpt_access_logs rpt = new Srpt_access_logs(date, group, total_rows, total_count, per);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_access_logs.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_access_logs.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_access_logs to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_access_logs.field> ret_data(String where) {
        List<Srpt_access_logs.field> datas = new ArrayList();

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
                    + ",count(id)"
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
                String created_at = DateType.convert_slash_datetime4(rs.getString(12));
                String updated_at = rs.getString(13);
                int count = rs.getInt(14);
                String type = "Student";
                if (!college.isEmpty()) {
                    type = "Faculty";
                }

                Srpt_access_logs.field field = new field(id_no, fname, mname, lname, year_level, course, college, type, created_at, count);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}

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
 * @author Maytopacka
 */
public class Srpt_statistics_students {

    public final List<field> fields;
    public final String date;
    public final int over;
    public final int s1;
    public final int s2;
    public final int s3;
    public final int s4;
    public final int s5;
    public final int s6;
    public final int sI;
    public final int sII;
    public final int sIII;
    public final int sIV;
    public final int sV;
    public final int s_total;

    public Srpt_statistics_students(String date, int over, int s1, int s2, int s3, int s4, int s5, int s6, int sI, int sII, int sIII, int sIV, int sV, int s_total) {
        this.fields = new ArrayList();
        this.date = date;
        this.over = over;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.sI = sI;
        this.sII = sII;
        this.sIII = sIII;
        this.sIV = sIV;
        this.sV = sV;
        this.s_total = s_total;
    }

    public static class field {

        String course;
        int count;

        public field() {
        }

        public field(String course, int count) {
            this.course = course;
            this.count = count;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }

    public static void main(String[] args) {
        String where = " where id_no<>'0000000002' "
                + " or id_no<>'0000000003' "
                + " or id_no<>'0000000003' and id_no<>'0000000002' and college='' "
                + " group by course order by course";
        List<Srpt_statistics_students.field> datas = ret_data(where);
        String date = "01/01/2016 - 01/02/2016";

        int over = 1000;
        int s1 = 100;
        int s2 = 200;
        int s3 = 300;
        int s4 = 400;
        int s5 = 500;
        int s6 = 600;
        int sI = 700;
        int sII = 800;
        int sIII = 900;
        int sIV = 1000;
        int sV = 1010;
        int s_total = s1 + s2 + s3 + s4 + s5 + s6 + sI + sII + sIII + sIV + sV;
        Srpt_statistics_students rpt = new Srpt_statistics_students(date, over, s1, s2, s3, s4, s5, s6, sI, sII, sIII, sIV, sV, s_total);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_statistics_students.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_statistics_students.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_statistics_students to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_statistics_students.field> ret_data(String where) {
        List<Srpt_statistics_students.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "count(id)"
                    + ",course"
                    + " from access_logs"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int count = rs.getInt(1);
                String course = rs.getString(2);

                Srpt_statistics_students.field field = new Srpt_statistics_students.field(course, count);
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

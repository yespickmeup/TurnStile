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
import turnstile.util.MyConnection;

/**
 *
 * @author Maytopacka
 */
public class Srpt_statistics_faculty {

    public final List<field> fields;
    public final String date;
    public final int over;
    public final int staff;
    public final int total;

    public Srpt_statistics_faculty(String date, int over, int staff, int total) {
        this.fields = new ArrayList();
        this.date = date;
        this.over = over;
        this.staff = staff;
        this.total = total;
    }

    public static class field {

        String college;
        int count;

        public field() {
        }

        public field(String college, int count) {
            this.college = college;
            this.count = count;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }

    public static void main(String[] args) {
        String where = " where Date(created_at) between '2016-10-19' and '2016-10-19' and access_type=2"
                + " group by college order by college";
        List<Srpt_statistics_faculty.field> datas = Srpt_statistics_faculty.ret_data(where);
        String date = "01/01/2016 - 01/02/2016";

        int over = 1000;
        int staff = 0;
        int total = over + staff;
        Srpt_statistics_faculty rpt = new Srpt_statistics_faculty(date, over, staff, total);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_statistics_faculty.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_statistics_faculty.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_statistics_faculty to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_statistics_faculty.field> ret_data(String where) {
        List<Srpt_statistics_faculty.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "count(id)"
                    + ",college"
                    + " from access_logs"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int count = rs.getInt(1);
                String course = rs.getString(2);

                Srpt_statistics_faculty.field field = new Srpt_statistics_faculty.field(course, count);
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

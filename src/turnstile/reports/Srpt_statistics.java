/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.reports;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

import turnstile.access_logs.Access_logs;
import turnstile.access_logs.Access_logs.to_access_logs;
import turnstile.util.DateType;

/**
 *
 * @author Maytopacka
 */
public class Srpt_statistics {

    public final List<field> fields;
    public final String date;
    public final int total_students;
    public final int total_faculty;
    public final int total_guest;
    public final int total;

    public Srpt_statistics(String date, int total_students, int total_faculty, int total_guest, int total) {
        this.fields = new ArrayList();
        this.date = date;
        this.total_students = total_students;
        this.total_faculty = total_faculty;
        this.total_guest = total_guest;
        this.total = total;
    }

//    Faculty and Staff
//    08:00   12:00   01:30   05:30
//    12:00   01:30   05:30   08:00
//    Students
//    08:00   12:00   01:30   05:30
//    12:00   01:30   05:30   08:00
//    Guests
    public static class field {

        String date;
        String fs_am_08_12;
        String fs_am_12_01;
        String fs_pm_01_05;
        String fs_pm_05_08;
        String s_am_08_12;
        String s_am_12_01;
        String s_pm_01_05;
        String s_pm_05_08;
        String g_am_08_12;
        String g_am_12_01;
        String g_pm_01_05;
        String g_pm_05_08;

        public field() {
        }

        public field(String date, String fs_am_08_12, String fs_am_12_01, String fs_pm_01_05, String fs_pm_05_08, String s_am_08_12, String s_am_12_01, String s_pm_01_05, String s_pm_05_08, String g_am_08_12, String g_am_12_01, String g_pm_01_05, String g_pm_05_08) {
            this.date = date;
            this.fs_am_08_12 = fs_am_08_12;
            this.fs_am_12_01 = fs_am_12_01;
            this.fs_pm_01_05 = fs_pm_01_05;
            this.fs_pm_05_08 = fs_pm_05_08;
            this.s_am_08_12 = s_am_08_12;
            this.s_am_12_01 = s_am_12_01;
            this.s_pm_01_05 = s_pm_01_05;
            this.s_pm_05_08 = s_pm_05_08;
            this.g_am_08_12 = g_am_08_12;
            this.g_am_12_01 = g_am_12_01;
            this.g_pm_01_05 = g_pm_01_05;
            this.g_pm_05_08 = g_pm_05_08;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getFs_am_08_12() {
            return fs_am_08_12;
        }

        public void setFs_am_08_12(String fs_am_08_12) {
            this.fs_am_08_12 = fs_am_08_12;
        }

        public String getFs_am_12_01() {
            return fs_am_12_01;
        }

        public void setFs_am_12_01(String fs_am_12_01) {
            this.fs_am_12_01 = fs_am_12_01;
        }

        public String getFs_pm_01_05() {
            return fs_pm_01_05;
        }

        public void setFs_pm_01_05(String fs_pm_01_05) {
            this.fs_pm_01_05 = fs_pm_01_05;
        }

        public String getFs_pm_05_08() {
            return fs_pm_05_08;
        }

        public void setFs_pm_05_08(String fs_pm_05_08) {
            this.fs_pm_05_08 = fs_pm_05_08;
        }

        public String getS_am_08_12() {
            return s_am_08_12;
        }

        public void setS_am_08_12(String s_am_08_12) {
            this.s_am_08_12 = s_am_08_12;
        }

        public String getS_am_12_01() {
            return s_am_12_01;
        }

        public void setS_am_12_01(String s_am_12_01) {
            this.s_am_12_01 = s_am_12_01;
        }

        public String getS_pm_01_05() {
            return s_pm_01_05;
        }

        public void setS_pm_01_05(String s_pm_01_05) {
            this.s_pm_01_05 = s_pm_01_05;
        }

        public String getS_pm_05_08() {
            return s_pm_05_08;
        }

        public void setS_pm_05_08(String s_pm_05_08) {
            this.s_pm_05_08 = s_pm_05_08;
        }

        public String getG_am_08_12() {
            return g_am_08_12;
        }

        public void setG_am_08_12(String g_am_08_12) {
            this.g_am_08_12 = g_am_08_12;
        }

        public String getG_am_12_01() {
            return g_am_12_01;
        }

        public void setG_am_12_01(String g_am_12_01) {
            this.g_am_12_01 = g_am_12_01;
        }

        public String getG_pm_01_05() {
            return g_pm_01_05;
        }

        public void setG_pm_01_05(String g_pm_01_05) {
            this.g_pm_01_05 = g_pm_01_05;
        }

        public String getG_pm_05_08() {
            return g_pm_05_08;
        }

        public void setG_pm_05_08(String g_pm_05_08) {
            this.g_pm_05_08 = g_pm_05_08;
        }

    }

    public static void main(String[] args) {
        String where = " where Date(created_at) between '" + "2016-10-08" + "' and '" + "2016-10-08" + "' ";
        List<to_access_logs> logs = Access_logs.ret_data(where);

        List<field> fields = new ArrayList();
        Date date = new Date();
        try {
            date = DateType.sf.parse("2016-10-08");
        } catch (ParseException ex) {
            Logger.getLogger(Srpt_statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        int fs_am_08_12 = 0;
        int fs_am_12_01 = 0;
        int fs_pm_01_05 = 0;
        int fs_pm_05_08 = 0;
        int s_am_08_12 = 0;
        int s_am_12_01 = 0;
        int s_pm_01_05 = 0;
        int s_pm_05_08 = 0;
        int g_am_08_12 = 0;
        int g_am_12_01 = 0;
        int g_pm_01_05 = 0;
        int g_pm_05_08 = 0;

        Date min_f_08_00 = Srpt_statistics.min(date, "08" + ":" + "00" + ":00");
        Date max_f_12_00 = Srpt_statistics.max(date, "12" + ":" + "00" + ":00");

        Date min_f_12_01 = Srpt_statistics.min(date, "12" + ":" + "01" + ":00");
        Date max_f_13_30 = Srpt_statistics.max(date, "13" + ":" + "30" + ":00");

        Date min_f_13_31 = Srpt_statistics.min(date, "13" + ":" + "31" + ":00");
        Date max_f_17_30 = Srpt_statistics.max(date, "17" + ":" + "30" + ":00");

        Date min_f_17_31 = Srpt_statistics.min(date, "17" + ":" + "31" + ":00");
        Date max_f_20_00 = Srpt_statistics.max(date, "20" + ":" + "00" + ":00");

        for (to_access_logs to : logs) {
            try {
                Date d = DateType.datetime.parse(to.created_at);

                if (to.id_no.equalsIgnoreCase("0000000002") || !to.college.isEmpty()) {
                    if (d.after(min_f_08_00) && d.before(max_f_12_00)) {
                        fs_am_08_12++;
                    }
                    if (d.after(min_f_12_01) && d.before(max_f_13_30)) {
                        fs_am_12_01++;
                    }
                    if (d.after(min_f_13_31) && d.before(max_f_17_30)) {
                        fs_pm_01_05++;
                    }
                    if (d.after(min_f_17_31) && d.before(max_f_20_00)) {
                        fs_pm_05_08++;
                    }
                }
                if (to.id_no.equalsIgnoreCase("0000000001") || !to.course.isEmpty()) {
                    if (d.after(min_f_08_00) && d.before(max_f_12_00)) {
                        s_am_08_12++;
                    }
                    if (d.after(min_f_12_01) && d.before(max_f_13_30)) {
                        s_am_12_01++;
                    }
                    if (d.after(min_f_13_31) && d.before(max_f_17_30)) {
                        s_pm_01_05++;
                    }
                    if (d.after(min_f_17_31) && d.before(max_f_20_00)) {
                        s_pm_05_08++;
                    }
                }
                if (to.id_no.equalsIgnoreCase("0000000003")) {
                    if (d.after(min_f_08_00) && d.before(max_f_12_00)) {
                        g_am_08_12++;
                    }
                    if (d.after(min_f_12_01) && d.before(max_f_13_30)) {
                        g_am_12_01++;
                    }
                    if (d.after(min_f_13_31) && d.before(max_f_17_30)) {
                        g_pm_01_05++;
                    }
                    if (d.after(min_f_17_31) && d.before(max_f_20_00)) {
                        g_pm_05_08++;
                    }
                }

            } catch (ParseException ex) {
                Logger.getLogger(Srpt_statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int total_students = 0;
        int total_faculty = 0;
        int total_guest = 0;
        int total = 0;

        field field = new field("" + date, empty(fs_am_08_12), empty(fs_am_12_01), empty(fs_pm_01_05), empty(fs_pm_05_08), empty(s_am_08_12), empty(s_am_12_01), empty(s_pm_01_05), empty(s_pm_05_08), empty(g_am_08_12), empty(g_am_12_01), empty(g_pm_01_05), empty(g_pm_05_08));
        fields.add(field);
        Srpt_statistics rpt = new Srpt_statistics("" + date, total_students, total_faculty, total_guest, total);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_statistics.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String empty(int number) {
        if (number == 0) {
            return "";
        }
        return "" + number;
    }

    public static Date min(Date date, String stmt) {
        String min_faculty = DateType.sf.format(date);
        min_faculty = min_faculty + " " + stmt;
        Date min_f = new Date();
        try {
            min_f = DateType.datetime.parse(min_faculty);

        } catch (ParseException ex) {
            Logger.getLogger(Srpt_statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return min_f;
    }

    public static Date max(Date date, String stmt) {

        String max_faculty = DateType.sf.format(date);
        max_faculty = max_faculty + " " + stmt;
        Date max_f = new Date();
        try {
            max_f = DateType.datetime.parse(max_faculty);
        } catch (ParseException ex) {
            Logger.getLogger(Srpt_statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max_f;
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_statistics.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_statistics to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}

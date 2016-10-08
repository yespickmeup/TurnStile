/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.reports;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_statistics {

    public final List<field> fields;

    public Srpt_statistics() {
        this.fields = new ArrayList();
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
        int fs_am_08_12;
        int fs_am_12_01;
        int fs_pm_01_05;
        int fs_pm_05_08;
        int s_am_08_12;
        int s_am_12_01;
        int s_pm_01_05;
        int s_pm_05_08;
        int g_am_08_12;
        int g_am_12_01;
        int g_pm_01_05;
        int g_pm_05_08;

        public field() {
        }

        public field(String date, int fs_am_08_12, int fs_am_12_01, int fs_pm_01_05, int fs_pm_05_08, int s_am_08_12, int s_am_12_01, int s_pm_01_05, int s_pm_05_08, int g_am_08_12, int g_am_12_01, int g_pm_01_05, int g_pm_05_08) {
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

        public int getFs_am_08_12() {
            return fs_am_08_12;
        }

        public void setFs_am_08_12(int fs_am_08_12) {
            this.fs_am_08_12 = fs_am_08_12;
        }

        public int getFs_am_12_01() {
            return fs_am_12_01;
        }

        public void setFs_am_12_01(int fs_am_12_01) {
            this.fs_am_12_01 = fs_am_12_01;
        }

        public int getFs_pm_01_05() {
            return fs_pm_01_05;
        }

        public void setFs_pm_01_05(int fs_pm_01_05) {
            this.fs_pm_01_05 = fs_pm_01_05;
        }

        public int getFs_pm_05_08() {
            return fs_pm_05_08;
        }

        public void setFs_pm_05_08(int fs_pm_05_08) {
            this.fs_pm_05_08 = fs_pm_05_08;
        }

        public int getS_am_08_12() {
            return s_am_08_12;
        }

        public void setS_am_08_12(int s_am_08_12) {
            this.s_am_08_12 = s_am_08_12;
        }

        public int getS_am_12_01() {
            return s_am_12_01;
        }

        public void setS_am_12_01(int s_am_12_01) {
            this.s_am_12_01 = s_am_12_01;
        }

        public int getS_pm_01_05() {
            return s_pm_01_05;
        }

        public void setS_pm_01_05(int s_pm_01_05) {
            this.s_pm_01_05 = s_pm_01_05;
        }

        public int getS_pm_05_08() {
            return s_pm_05_08;
        }

        public void setS_pm_05_08(int s_pm_05_08) {
            this.s_pm_05_08 = s_pm_05_08;
        }

        public int getG_am_08_12() {
            return g_am_08_12;
        }

        public void setG_am_08_12(int g_am_08_12) {
            this.g_am_08_12 = g_am_08_12;
        }

        public int getG_am_12_01() {
            return g_am_12_01;
        }

        public void setG_am_12_01(int g_am_12_01) {
            this.g_am_12_01 = g_am_12_01;
        }

        public int getG_pm_01_05() {
            return g_pm_01_05;
        }

        public void setG_pm_01_05(int g_pm_01_05) {
            this.g_pm_01_05 = g_pm_01_05;
        }

        public int getG_pm_05_08() {
            return g_pm_05_08;
        }

        public void setG_pm_05_08(int g_pm_05_08) {
            this.g_pm_05_08 = g_pm_05_08;
        }

    }

    public static void main(String[] args) {

        List<field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String date = "October 7,2016 (Monday)" + i;
            int fs_am_08_12 = 50;
            int fs_am_12_01 = 100;
            int fs_pm_01_05 = 150;
            int fs_pm_05_08 = 200;
            int s_am_08_12 = 90;
            int s_am_12_01 = 95;
            int s_pm_01_05 = 100;
            int s_pm_05_08 = 105;
            int g_am_08_12 = 110;
            int g_am_12_01 = 210;
            int g_pm_01_05 = 215;
            int g_pm_05_08 = 220;
            field field = new field(date, fs_am_08_12, fs_am_12_01, fs_pm_01_05, fs_pm_05_08, s_am_08_12, s_am_12_01, s_pm_01_05, s_pm_05_08, g_am_08_12, g_am_12_01, g_pm_01_05, g_pm_05_08);
            fields.add(field);
        }
        Srpt_statistics rpt = new Srpt_statistics();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_statistics.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

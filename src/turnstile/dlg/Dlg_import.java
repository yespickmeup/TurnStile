/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.dlg;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.DateType;
import turnstile.faculty_and_staffs.Faculty_and_staffs;
import turnstile.faculty_and_staffs.Faculty_and_staffs.to_faculty_and_staffs;
import turnstile.students.Students;
import turnstile.students.Students.to_students;
import turnstile.util.Alert;
import turnstile.util.Dlg_confirm_action;

/**
 *
 * @author Guinness
 */
public class Dlg_import extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_import
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_import(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_import(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_import() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_import myRef;

    private void setThisRef(Dlg_import myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_import> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_import create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_import create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_import dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_import((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_import dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_import((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_import dialog = Dlg_import.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new Field.Input();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_students = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new Button.Primary();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jButton4 = new Button.Default();
        jButton5 = new Button.Primary();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_faculty_and_staffs = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Location:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/computer (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbl_students.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_students);

        jLabel2.setText("No. of rows:");

        jLabel3.setText("0");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel4.setText("status:");

        jButton3.setText("Import to Database");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Import Students", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Location:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/computer (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Import to Database");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tbl_faculty_and_staffs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_faculty_and_staffs);

        jLabel6.setText("No. of rows:");

        jLabel7.setText("0");

        jProgressBar2.setString("");
        jProgressBar2.setStringPainted(true);

        jLabel8.setText("status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Import Faculty and Staff", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        extract();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        import_to_db_students();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        extract_faculty();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        import_to_db_staffs();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbl_faculty_and_staffs;
    private javax.swing.JTable tbl_students;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        String dir = System.getProperty("user.home") + "\\Desktop\\students.csv";
        String dir2 = System.getProperty("user.home") + "\\Desktop\\faculty.csv";
        jTextField1.setText(dir);
        jTextField2.setText(dir2);

        init_tbl_students(tbl_students);
        init_tbl_faculty_and_staffs(tbl_faculty_and_staffs);
    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" students ">
    private void extract() {
        final JFileChooser fileChooser = new JFileChooser();

        String dir = System.getProperty("user.home") + "\\Desktop";
        fileChooser.setCurrentDirectory(new File(dir));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILE", "csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    jTextField1.setText(selectedFile.getAbsolutePath());
                    String csvFilePath = selectedFile.getAbsolutePath();
                    open_file(csvFilePath);

                }
            });
            t.start();

        }
    }

    private void open_file(String csvFilePath) {
        String line = "";
        String cvsSplitBy = ",";

        List<Students.to_students> students = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] list = line.split(cvsSplitBy);

//                System.out.println("id: " + list[0] + " lname: " + list[1] + " first_name: " + list[2] + " middle_name: " + list[3] + " year_level: " + list[4] + " course: " + list[5]);
//               
                int id = 0;
                String id_no = list[0];
                String fname = list[2];
                String mname = list[3];
                String lname = list[1];
                String year_level = list[4];
                String course = list[5];
                int status = 1;
                String created_by = "admin";
                String updated_by = "admin";
                String created_at = DateType.now();
                String updated_at = DateType.now();
                Students.to_students student = new Students.to_students(id, id_no, fname, mname, lname, year_level, course, status, created_by, updated_by, created_at, updated_at);
                students.add(student);
            }
            students.remove(0);
            loadData_students(students);
            jLabel3.setText("" + students.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //<editor-fold defaultstate="collapsed" desc=" students "> 
    public static ArrayListModel tbl_students_ALM;
    public static TblstudentsModel tbl_students_M;

    public static void init_tbl_students(JTable tbl_students) {
        tbl_students_ALM = new ArrayListModel();
        tbl_students_M = new TblstudentsModel(tbl_students_ALM);
        tbl_students.setModel(tbl_students_M);
        tbl_students.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_students.setRowHeight(25);
        int[] tbl_widths_students = {0, 90, 120, 120, 120, 70, 100, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_students.length; i < n; i++) {
            if (i == 6) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_students, i, tbl_widths_students[i]);
        }
        Dimension d = tbl_students.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_students.getTableHeader().setPreferredSize(d);
        tbl_students.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_students.setRowHeight(25);
        tbl_students.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_students(List<to_students> acc) {
        tbl_students_ALM.clear();
        tbl_students_ALM.addAll(acc);
    }

    public static class TblstudentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "ID No", "Last Name", "First Name", "Middle Name", "Year Level", "Course", "status", "created_by", "updated_by", "created_at", "updated_at"
        };

        public TblstudentsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_students tt = (to_students) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return " " + tt.id_no;
                case 2:
                    return " " + tt.fname;
                case 3:
                    return " " + tt.mname;
                case 4:
                    return " " + tt.lname;
                case 5:
                    return " " + tt.year_level;
                case 6:
                    return " " + tt.course;
                case 7:
                    return tt.status;
                case 8:
                    return tt.created_by;
                case 9:
                    return tt.updated_by;
                case 10:
                    return tt.created_at;
                default:
                    return tt.updated_at;
            }
        }
    }
//</editor-fold> 

    private void import_to_db_students() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                final List<to_students> students = tbl_students_ALM;
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Students.add_data(students);
                        Alert.set(1, "");
                        tbl_students_ALM.clear();
                        tbl_students_M.fireTableDataChanged();
                        jLabel3.setText("");
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
//</editor-fold>

    private void extract_faculty() {
        final JFileChooser fileChooser = new JFileChooser();

        String dir = System.getProperty("user.home") + "\\Desktop";
        fileChooser.setCurrentDirectory(new File(dir));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILE", "csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    jTextField2.setText(selectedFile.getAbsolutePath());
                    String csvFilePath = selectedFile.getAbsolutePath();
                    open_file_faculty(csvFilePath);

                }
            });
            t.start();

        }
    }

    private void open_file_faculty(String csvFilePath) {
        String line = "";
        String cvsSplitBy = ",";

        List<Faculty_and_staffs.to_faculty_and_staffs> staffs = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] list = line.split(cvsSplitBy);

//                System.out.println("id: " + list[0] + " lname: " + list[1] + " first_name: " + list[2] + " middle_name: " + list[3] + " college: " + list[4]);
                int id = 0;
                String id_no = list[0];
                String fname = list[1];
                String mname = list[3];
                String lname = list[2];
                String college = list[4];

                int status = 1;
                String created_by = "admin";
                String updated_by = "admin";
                String created_at = DateType.now();
                String updated_at = DateType.now();
                Faculty_and_staffs.to_faculty_and_staffs staff = new Faculty_and_staffs.to_faculty_and_staffs(id, id_no, fname, mname, lname, college, status, created_by, updated_by, created_at, updated_at);
                staffs.add(staff);
            }
            staffs.remove(0);
            loadData_faculty_and_staffs(staffs);
            jLabel7.setText("" + staffs.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //<editor-fold defaultstate="collapsed" desc=" students "> 
    //<editor-fold defaultstate="collapsed" desc=" faculty_and_staffs "> 
    public static ArrayListModel tbl_faculty_and_staffs_ALM;
    public static Tblfaculty_and_staffsModel tbl_faculty_and_staffs_M;

    public static void init_tbl_faculty_and_staffs(JTable tbl_faculty_and_staffs) {
        tbl_faculty_and_staffs_ALM = new ArrayListModel();
        tbl_faculty_and_staffs_M = new Tblfaculty_and_staffsModel(tbl_faculty_and_staffs_ALM);
        tbl_faculty_and_staffs.setModel(tbl_faculty_and_staffs_M);
        tbl_faculty_and_staffs.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_faculty_and_staffs.setRowHeight(25);
        int[] tbl_widths_faculty_and_staffs = {0, 90, 120, 120, 120, 100, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_faculty_and_staffs.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_faculty_and_staffs, i, tbl_widths_faculty_and_staffs[i]);
        }
        Dimension d = tbl_faculty_and_staffs.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_faculty_and_staffs.getTableHeader().setPreferredSize(d);
        tbl_faculty_and_staffs.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_faculty_and_staffs.setRowHeight(25);
        tbl_faculty_and_staffs.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_faculty_and_staffs(List<to_faculty_and_staffs> acc) {
        tbl_faculty_and_staffs_ALM.clear();
        tbl_faculty_and_staffs_ALM.addAll(acc);
    }

    public static class Tblfaculty_and_staffsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "ID No", "Last Name", "First Name", "Middle Name", "College", "status", "created_by", "updated_by", "created_at", "updated_at"
        };

        public Tblfaculty_and_staffsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_faculty_and_staffs tt = (to_faculty_and_staffs) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return "  " + tt.id_no;
                case 2:
                    return "  " + tt.fname;
                case 3:
                    return "  " + tt.mname;
                case 4:
                    return "  " + tt.lname;
                case 5:
                    return "  " + tt.college;
                case 6:
                    return tt.status;
                case 7:
                    return tt.created_by;
                case 8:
                    return tt.updated_by;
                case 9:
                    return tt.created_at;
                default:
                    return tt.updated_at;
            }
        }
    }
//</editor-fold> 

//</editor-fold> 
    private void import_to_db_staffs() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                final List<to_faculty_and_staffs> students = tbl_faculty_and_staffs_ALM;
                jProgressBar2.setString("Loading...Please wait...");
                jProgressBar2.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Faculty_and_staffs.add_data(students);
                        Alert.set(1, "");
                        tbl_faculty_and_staffs_ALM.clear();
                        tbl_faculty_and_staffs_M.fireTableDataChanged();
                        jLabel7.setText("");
                        jProgressBar2.setString("Finished...");
                        jProgressBar2.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}

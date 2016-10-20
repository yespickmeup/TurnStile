/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.dlg;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Field;
import turnstile.access_logs.Access_logs;
import turnstile.faculty_and_staffs.Faculty_and_staffs;
import turnstile.reports.Dlg_statistics;
import turnstile.students.Students;
import turnstile.util.DateType;
import turnstile.util.Port;

/**
 *
 * @author Maytopacka
 */
public class Dlg_turnstile extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_turnstile
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
    private Dlg_turnstile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_turnstile(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_turnstile() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_turnstile myRef;

    private void setThisRef(Dlg_turnstile myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_turnstile> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_turnstile create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_turnstile create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_turnstile dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_turnstile((java.awt.Frame) parent, false);
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
            Dlg_turnstile dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_turnstile((java.awt.Dialog) parent, false);
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

        Dlg_turnstile dialog = Dlg_turnstile.create(new javax.swing.JFrame(), true);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);

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
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 320));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("ID No");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Group");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField2.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Year Level");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField3.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Course");

        jXLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jXLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jXLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jXLabel2.setLineWrap(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(196, 6, 13));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Start search...");
        jLabel2.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("College");

        jXLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jXLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jXLabel1.setLineWrap(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
        search();
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/user-icon (Custom).png")).getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));
               
                jLabel1.setIcon(imageIcon);
                jTextField1.grabFocus();
            }
        });
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
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                 ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/user-icon (Custom).png")).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
//               
//                jXImagePanel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Guinness\\Student_ID_Number\\00-01-013E.JPG")); // NOI18N
//           
//                jXImagePanel1.setImage(imageIcon.getImage());
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F10, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                String id_no1 = "0000000001";
                String year_level = "";
                String course = "";
                String college = "";
                int status = 1;
                String created_by = "";
                String updated_by = "";
                String created_at = DateType.now();
                String updated_at = DateType.now();
                Access_logs.to_access_logs log = new Access_logs.to_access_logs(id, id_no1, "", "", "Student", year_level, course, college, status, created_by, updated_by, created_at, updated_at,1);
                Access_logs.add_data(log);
//            
                String stmt = System.getProperty("stmt", "01L");
                String port = System.getProperty("port", "COM11");
                try {
                    Port.command(stmt, port);
                } catch (Exception ex) {
                    System.out.println("Port exception!...");
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F11, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                String id_no1 = "0000000002";
                String year_level = "";
                String course = "";
                String college = "";
                int status = 1;
                String created_by = "";
                String updated_by = "";
                String created_at = DateType.now();
                String updated_at = DateType.now();
                Access_logs.to_access_logs log = new Access_logs.to_access_logs(id, id_no1, "", "", "Faculty/Staff", year_level, course, college, status, created_by, updated_by, created_at, updated_at,2);
                Access_logs.add_data(log);
//            
                String stmt = System.getProperty("stmt", "01L");
                String port = System.getProperty("port", "COM11");
                try {
                    Port.command(stmt, port);
                } catch (Exception ex) {
                    System.out.println("Port exception!...");
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F12, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                String id_no1 = "0000000003";
                String year_level = "";
                String course = "";
                String college = "";
                int status = 1;
                String created_by = "";
                String updated_by = "";
                String created_at = DateType.now();
                String updated_at = DateType.now();
                Access_logs.to_access_logs log = new Access_logs.to_access_logs(id, id_no1, "", "", "Guest", year_level, course, college, status, created_by, updated_by, created_at, updated_at,3);
                Access_logs.add_data(log);
//            
                String stmt = System.getProperty("stmt", "01L");
                String port = System.getProperty("port", "COM11");
                try {
                    Port.command(stmt, port);
                } catch (Exception ex) {
                    System.out.println("Port exception!...");
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                statistics();
            }
        });
    }

    private void statistics() {
        Window p = (Window) this;
        Dlg_statistics nd = Dlg_statistics.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_statistics.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_statistics.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    // </editor-fold>
    private void login() {
        Window p = (Window) this;
        Dlg_login nd = Dlg_login.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_login.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_login.OutputData data) {
                closeDialog.ok();
                settings();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void settings() {
        Window p = (Window) this;
        Dlg_settings nd = Dlg_settings.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_settings.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_settings.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    
    List<Students.to_students> students = new ArrayList();
    List<Faculty_and_staffs.to_faculty_and_staffs> staffs = new ArrayList();

    private void search() {
        String id_no = jTextField1.getText();
        int exists = 0;
        int group = -1;
        String fname = "";
        String mname = "";
        String lname = "";
        int access_type=1;
        jTextField1.setFocusable(false);

        students = Students.ret_data(" where id_no = '" + id_no + "' limit 1");

        if (!students.isEmpty()) {
            Students.to_students student = students.get(0);
            jTextField1.setText(id_no);
            jTextField2.setText("Student");
            jTextField3.setText(student.year_level);
            jXLabel2.setText(student.course);
            fname = student.fname;
            mname = student.mname;
            lname = student.lname;
            jXLabel1.setText("");
            String name = " " + student.lname + ", " + student.fname + " " + student.mname;
            jLabel2.setText(name);
            exists = 1;
            group = 0; //student
            access_type=1;
        } else {
            staffs = Faculty_and_staffs.ret_data(" where id_no = '" + id_no + "' limit 1");
            if (!staffs.isEmpty()) {
                Faculty_and_staffs.to_faculty_and_staffs staff = staffs.get(0);
                jTextField1.setText(id_no);
                jTextField2.setText("Faculty");
                jXLabel1.setText(staff.college);
                fname = staff.fname;
                mname = staff.mname;
                lname = staff.lname;
                jTextField3.setText("");
                jXLabel2.setText("");
                String name = " " + staff.lname + ", " + staff.fname + " " + staff.mname;
                jLabel2.setText(name);
                exists = 1;
                group = 1; //faculty
                access_type=2;
            }
        }

        if (exists == 0) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jXLabel2.setText("");
            jXLabel1.setText("");
            jLabel2.setText(" Record not found!");
            ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/kTMR6Bnpc.png")).getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));
            jLabel1.setIcon(imageIcon);

        } else {

//            insert to database
            int id = 0;
            String id_no1 = jTextField1.getText();
            String year_level = jTextField3.getText();
            String course = jXLabel2.getText();
            String college = jXLabel1.getText();
            int status = 1;
            String created_by = "";
            String updated_by = "";
            String created_at = DateType.now();
            String updated_at = DateType.now();
            Access_logs.to_access_logs log = new Access_logs.to_access_logs(id, id_no1, fname, mname, lname, year_level, course, college, status, created_by, updated_by, created_at, updated_at,access_type);
            Access_logs.add_data(log);
//            
            String stmt = System.getProperty("stmt", "01L");
            String port = System.getProperty("port", "COM11");
            try {
                Port.command(stmt, port);
            } catch (Exception e) {
                System.out.println("Port exception!...");
            }

            String home = System.getProperty("user.home", "");

            String path_to_student = home + "\\Student_ID_Number\\";
            path_to_student = path_to_student + "" + id_no + ".JPG";

//            System.out.println("path: " + path_to_student);
            File f = new File(path_to_student);
            final String  aw = path_to_student;
            if (f.exists()) {
                System.out.println("exists: " + path_to_student);
                jLabel1.setIcon(new javax.swing.ImageIcon(path_to_student)); // NOI18N
                final ImageIcon icon = new ImageIcon(path_to_student);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon imageIcon = new ImageIcon(icon.getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));
                        jLabel1.setIcon(imageIcon);
                       
                    }
                });

            } else {
                ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/no-image-icon-15.png")).getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));
                jLabel1.setIcon(imageIcon);
            }
//            jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Maytopacka\\Student_ID_Number\\15-1-00364.JPG"));

        }

        clear();
    }
    int interval = 1;

    private void clear() {
        int delay = 1000;
        int period = 1000;
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
//                System.out.println("interval: " + interval);
                if (interval == 1) {
                    timer.cancel();
                    interval = 0;
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jXLabel2.setText("");
                    jXLabel1.setText("");
                    jLabel2.setText(" Start search...");
                    ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/user-icon (Custom).png")).getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));

                    jLabel1.setIcon(imageIcon);
                    jTextField1.setFocusable(true);
                    jTextField1.grabFocus();
                    jTextField1.selectAll();
                }
                interval++;

            }
        }, delay, period);

    }

    private void student() {
        int delay = 1000;
        int period = 1000;
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
//                System.out.println("interval: " + interval);
                if (interval == 3) {
                    timer.cancel();
                    interval = 0;
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jXLabel2.setText("");
                    jXLabel1.setText("");
                    jLabel2.setText(" Start search...");
                    ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/turnstile/img/user-icon (Custom).png")).getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT));

                    jLabel1.setIcon(imageIcon);
                    jTextField1.setFocusable(true);
                    jTextField1.grabFocus();
                    jTextField1.selectAll();
                }
                interval++;

            }
        }, delay, period);

    }
}

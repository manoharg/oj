package oj;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import oj.Message;
import oj.Client;

/**
 *
 * @author manohar
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
     public int id;
     public boolean value;
     public String prb,language;
     Profilepage backpage;
    Client socket; Message msg;
    public NewJFrame(int id,Profilepage backpage,Client socket,Message msg) throws SQLException, Exception {
        initComponents();
        this.socket=socket;this.msg=msg;
        jComboBox.addItem("c");
        jComboBox.addItem("cpp");
        jComboBox.addItem("python");
       this.id=id;
       this.backpage=backpage;
       jTextArea2.setEditable(false);
       Output.setEditable(false);

        System.out.println("passed argument"+id);
        
       
        msg.code=4;//problem loading
        msg.problmno=id+1;
        socket.send(msg);
        
       msg=socket.receive();
       jTextArea2.setText(msg.prblm);
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        UsercodeTextarea = new javax.swing.JTextArea();
        compileB = new javax.swing.JButton();
        SubmitB = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/go-previous.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setText("Enter your code here :");

        UsercodeTextarea.setColumns(20);
        UsercodeTextarea.setRows(5);
        jScrollPane4.setViewportView(UsercodeTextarea);

        compileB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rsz_1proceed.png"))); // NOI18N
        compileB.setText("Compile");
        compileB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileBActionPerformed(evt);
            }
        });

        SubmitB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/submit.png"))); // NOI18N
        SubmitB.setText("Submit");
        SubmitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBActionPerformed(evt);
            }
        });

        Output.setColumns(20);
        Output.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Output.setRows(5);
        jScrollPane1.setViewportView(Output);

        jLabel2.setFont(new java.awt.Font("Cantarell", 3, 18)); // NOI18N
        jLabel2.setText("Output");

        jButton1.setText("Choose File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(157, 157, 157)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton1)
                .addGap(58, 58, 58)
                .addComponent(compileB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(SubmitB, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(compileB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SubmitB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        backpage.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void compileBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileBActionPerformed
     //   int selected=jComboBox.sele
    
     msg.language=jComboBox.getSelectedItem().toString();
     msg.inputcode=UsercodeTextarea.getText();
     msg.code=5;//comiple
     
     
     
         try {
             socket.send(msg);
          } catch (Exception ex) {
             Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             msg=socket.receive();
         } catch (IOException ex) {
             Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
          if(msg.cerror==1)
             {
            // JOptionPane.showMessageDialog(this, "Compilation success");
                //  Output.setText("Compiling......");
                 Output.setForeground(Color.GREEN);
                 Output.setText("Compilation Success\n");
                 
                 
             }else
             {
             //JOptionPane.showMessageDialog(this, "Compilation Error!!");}
                  //Output.setText("Compiling......");
                        Output.setForeground(Color.RED);
                 Output.setText("Compilation Error\n");
             }
                 
    }//GEN-LAST:event_compileBActionPerformed

    private void SubmitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBActionPerformed
        // TODO add your handling code here:
        
         msg.language=jComboBox.getSelectedItem().toString();
         if(msg.cerror==1)
         {//success of compilation 
                    
    
         try {
             //converttofile(language);
             msg.code=6;//execute
             socket.send(msg);
             msg=socket.receive();
                     
            // verdict = execute(language,"/home/manohar/Desktop/in/in.txt",200);
         } catch (IOException ex) {
             Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         } catch (Exception ex) {
             Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
         }
     if(msg.verdict==1)
     { //JOptionPane.showMessageDialog(this, "tle");
         Output.setForeground(Color.red);
         Output.setBackground(Color.gray);
                 Output.setText("TLE\n");
     }else if(msg.verdict==2)
     {
         Output.setBackground(Color.gray);
           Output.setForeground(Color.ORANGE);
                 Output.setText("Segmentation Fault\n");
         //JOptionPane.showMessageDialog(this, "segfault");
     }
     else if(msg.verdict==3)
     {
         //JOptionPane.showMessageDialog(this, "wrong answer");
         Output.setBackground(Color.gray);
              Output.setForeground(Color.RED);
                 Output.setText("Wrong Answer\nInput:\n"+msg.showinp+"Your Output:\n"+msg.showop+"\nExpected output:\n"+msg.myoutput);
                 
                
         
     }
     else if(msg.verdict==4)
     { Output.setBackground(Color.gray);
           Output.setForeground(Color.GREEN);
                      Output.setText("Correct Answer\nInput:\n"+msg.showinp+"Your Output:\n"+msg.showop+"\nExpected output:\n"+msg.myoutput);

         JOptionPane.showMessageDialog(this, "accepted");
         
     }   
    }//GEN-LAST:event_SubmitBActionPerformed
else
    {
            JOptionPane.showMessageDialog(this,"Compilation error");
    }
}
 
         
         
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser open = new JFileChooser(); // open up a file chooser (a dialog for the user to browse files to open)
int option = open.showOpenDialog(this); // get the option that the user selected (approve or cancel)
// NOTE: because we are OPENing a file, we call showOpenDialog~
// if the user clicked OK, we have "APPROVE_OPTION"// so we want to open the file
if (option == JFileChooser.APPROVE_OPTION) {
UsercodeTextarea.setText(""); // clear the TextArea before applying the file contents
try {
					// create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
while (scan.hasNext()) // while there's still something to read
UsercodeTextarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
} catch (Exception ex) { // catch any exceptions, and...
// ...write to the debug console
System.out.println(ex.getMessage());
	}
	}
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Output;
    private javax.swing.JButton SubmitB;
    private javax.swing.JTextArea UsercodeTextarea;
    private javax.swing.JButton compileB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}

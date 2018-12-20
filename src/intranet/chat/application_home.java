
package intranet.chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
    
    
public class application_home extends javax.swing.JFrame implements Runnable{
    private static Socket s= null;
    private static Socket mes=null;
    private static Socket fl=null;
    private static Socket perm=null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;
    private static DataInputStream mesin = null;
    private static DataOutputStream mesout = null;
    private static DataOutputStream permout = null;
    private static FileOutputStream fos;
    public static String id,lname,fname;
    public static Vector <String>ls=new Vector<String>();
    public static Vector <String>ds=new Vector<String>();
    public static Vector <String>pd=new Vector<String>();
    public static Thread th =null;
    public static byte[] barr=null;
    public static boolean first;
    public static int n;
    public static byte barr1[];
    public static File f=null;
    public application_home() {
        initComponents();
    }
    public application_home(Socket s1,Socket s2,Socket s3,Socket s4,byte barr[]) {
        initComponents();
        barr1=barr;
        s=s1;
        mes=s2;
        fl=s3;
        perm=s4;
        first=true;
        n=0;
       try{
        dout=new DataOutputStream(s.getOutputStream());
       din=new DataInputStream(s.getInputStream());
        mesout=new DataOutputStream(mes.getOutputStream());
       mesin=new DataInputStream(mes.getInputStream());
       permout=new DataOutputStream(perm.getOutputStream());
       }
       catch(IOException ae)
       { System.out.println(ae);
       JOptionPane.showMessageDialog(null,"Can't connect try again");}
    }
    
    public application_home(Socket s1,Socket s2,Socket s3,Socket s4) {
        initComponents();
        s=s1;
        mes=s2;
        fl=s3;
        perm=s4;
        first=true;
        n=0;
       try{
        dout=new DataOutputStream(s.getOutputStream());
       din=new DataInputStream(s.getInputStream());
        mesout=new DataOutputStream(mes.getOutputStream());
       mesin=new DataInputStream(mes.getInputStream());
       permout=new DataOutputStream(perm.getOutputStream());
       }
       catch(IOException ae)
       { System.out.println(ae);
       JOptionPane.showMessageDialog(null,"Can't connect try again");}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        friend = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chatingp = new javax.swing.JLabel();
        filesend = new javax.swing.JButton();
        profilepic = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        text = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(45, 36, 139));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intranet Chat App");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        friend.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        friend.setForeground(new java.awt.Color(45, 36, 139));
        friend.setAutoscrolls(false);
        friend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setBackground(new java.awt.Color(68, 0, 252));
        search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        info.setBackground(new java.awt.Color(153, 153, 153));
        info.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Connected to :");

        chatingp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        filesend.setBackground(new java.awt.Color(68, 0, 252));
        filesend.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        filesend.setForeground(new java.awt.Color(255, 255, 255));
        filesend.setText("Send File");
        filesend.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        filesend.setEnabled(false);
        filesend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesendActionPerformed(evt);
            }
        });

        profilepic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilepic.setText("Profile Picture");
        profilepic.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setBackground(new java.awt.Color(45, 36, 139));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pic");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel3.setMaximumSize(new java.awt.Dimension(68, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(68, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(68, 16));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(friend, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chatingp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(profilepic, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filesend, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 77, Short.MAX_VALUE)
                                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(filesend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(friend, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(chatingp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(profilepic, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(253, 151, 36));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList3.setBackground(new java.awt.Color(255, 202, 106));
        jList3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList3.setToolTipText("");
        jList3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jList3MouseMoved(evt);
            }
        });
        jList3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList3ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList3);

        text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text.setToolTipText("text");
        text.setAutoscrolls(false);
        text.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });

        send.setBackground(new java.awt.Color(253, 151, 36));
        send.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        send.setForeground(new java.awt.Color(102, 102, 102));
        send.setText("Send");
        send.setEnabled(false);
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jList4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jList4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 16)); // NOI18N
        jList4.setForeground(new java.awt.Color(45, 36, 139));
        jList4.setToolTipText("");
        jScrollPane5.setViewportView(jList4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(text)
                        .addGap(0, 0, 0)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu3.setText("File");

        jMenuItem1.setText("Save Chat");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        try{
            
        String s5=text.getText();
        mesout.writeUTF(id+": "+s5);
        ds.add("You to "+chatingp.getText()+" : "+s5);
        n++;
        pd.add("You to "+chatingp.getText()+" : "+s5);
        jList4.setAlignmentX(10);
        jList4.setListData(ds);
        text.setText("");
        }
        catch(IOException e){JOptionPane.showMessageDialog(null, "resend");}
    }//GEN-LAST:event_sendActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try{
                
        String select=friend.getText();
        if(select.equals(id))
        {
            JOptionPane.showMessageDialog(null,"Don't Enter your own id");
            friend.setText("");
            return;
        }
        dout.writeUTF(friend.getText());
        String pe=din.readUTF();
        if(pe.equals("no"))
            JOptionPane.showMessageDialog(null,"Your Friend is not Online");
        else if(pe.equals("yes"))
        {   
            System.out.println("\nThread condition :"+"\n");
            barr=new byte[din.readInt()];
            din.read(barr);
            Thread.sleep(500);
            ImageIcon icon=new ImageIcon(barr);
            profilepic.setIcon(icon);
            if(first)
            {
                first=false;
              //  permout.writeInt(125);
            }
            else
            {
                mesout.writeUTF("*#*#*#");
                permout.writeInt(1);
            }
            dout.writeUTF("Done");
            System.out.println(friend.getText()+" Connected");
            ls.add(friend.getText());
        jList3.setAlignmentX(10);
        jList3.setListData(ls);
        filesend.setEnabled(true);
        send.setEnabled(true);
        chatingp.setText(friend.getText());
        friend.setText("");
        //distribute();
        }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Try again"+e);} catch (InterruptedException ex) { 
            Logger.getLogger(application_home.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        info.setText(fname+" "+lname+"("+id+")");
                jList4.setAlignmentX(10);
                jList4.setListData(ds);
                jList4.updateUI();
                jList3.setAlignmentX(10);
                jList3.setListData(ls);
                jList3.updateUI();
                //ImageIcon icon=new ImageIcon(barr);
                //profilepic.setIcon(icon);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated
        
    public void distribute(){
    
        String label=chatingp.getText();
        Vector <String>temp=new Vector<String>();
        for(int i=0;i<n;i++)
        {
            String tex=ls.get(i);
            String checker=tex.substring(0, 8);
            if(checker.equals(label))
                temp.add(tex);
        }
        pd=temp;
        }
    private void jList3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList3ValueChanged
    // TODO add your handling code here:
    }//GEN-LAST:event_jList3ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String select=jList3.getSelectedValue();
            if(select.equals(chatingp.getText()))
        {
            JOptionPane.showMessageDialog(null,"Don't select already active friend");
            return;
        }
        try{
            dout.writeUTF(select);
        String pe=din.readUTF();
        if(pe.equals("no"))
            JOptionPane.showMessageDialog(null,"Your Friend is not Online");
        else if(pe.equals("yes"))
        {   
            System.out.println("\nThread condition :"+"\n");
            barr=new byte[din.readInt()];
            din.read(barr);
            Thread.sleep(500);
            ImageIcon icon=new ImageIcon(barr);
            profilepic.setIcon(icon);
            if(first)
            {
                first=false;
              //  permout.writeInt(125);
            }
            else
            {
                mesout.writeUTF("*#*#*#");
                permout.writeInt(1);
            }
            dout.writeUTF("Done");
            System.out.println(friend.getText()+" Connected");
            ls.add(friend.getText());
        jList3.setAlignmentX(10);
        jList3.setListData(ls);
        send.setEnabled(true);
        filesend.setEnabled(true);
        chatingp.setText(select);
        friend.setText("");
        //distribute();
        }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Try again"+e);} catch (InterruptedException ex) { 
            Logger.getLogger(application_home.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filesendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesendActionPerformed
            
        if(fl==null || perm==null)
            JOptionPane.showMessageDialog(null, "anyone pointer is empty");
            
        filechoice fc=new filechoice(id,fl,perm);
        fc.main(null);




        // TODO add your handling code here:
    }//GEN-LAST:event_filesendActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                ImageIcon icon=new ImageIcon(barr1);
                jLabel3.setIcon(icon); 

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jList3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseMoved
              //  jList4.setAlignmentX(10);
                //jList4.setListData(ds);
                //jList4.updateUI();
                //jList3.setAlignmentX(10);
                //jList3.setListData(ls);
                //jList3.updateUI();
    }//GEN-LAST:event_jList3MouseMoved

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String path = "C:" + File.separator + "Intranet-chat chat backup" + File.separator + "Chat file -"+id+".txt";
            File fc = new File(path);
            try{
                fc.getParentFile().mkdirs(); 
                fc.createNewFile();
                }
            catch(IOException e){   e.printStackTrace();    }
        try {
            fos = new FileOutputStream(fc);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(application_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(ds.size());
                for(int i=0;i<ds.size();i++)
                    {
                            String tex=ds.get(i)+"\n";
                            byte allchats[]=tex.getBytes();
                        try {
                            fos.write(allchats);
                        } catch (IOException ex) {
                            Logger.getLogger(application_home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try { 
                        JOptionPane.showMessageDialog(null, "Data saved successfully");
                        fos.flush();
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(application_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try {
            s.close();
            mes.close();
            fl.close();
            perm.close();
            setVisible(false);
            Login.main(null);   
            // TODO add your handling code here:
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"You are successfully Logouted.");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void run(){
        try{
            while(true){
                String mess;
                    System.out.println("waiting");
                    mess=mesin.readUTF();
                    n++;
                    String label=chatingp.getText();
                    String checker=mess.substring(0, 8);
                    Boolean add=true;
                   // System.out.println(ls.size());
                    for(int i=0;i<ls.size();i++)
                        {
                            String tex=ls.get(i);
                           System.out.println(tex);
                            if(checker.equals(tex))
                                add=false;
                        }
                    if(add)
                        ls.add(checker);
                    if(checker.equals(label))
                        pd.add(mess);
                System.out.println("*"+checker+"* message got");
                ds.add(mess);
                
        
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Network interrupted");
        }
    }
    
    public static void main(String args[]) {
                    
        id=args[0];
        lname=args[1];
        fname=args[2];
        th=new Thread(new application_home());
        th.start();
        savefile sf=new savefile(fl,perm);
        sf.start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new application_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatingp;
    private javax.swing.JButton filesend;
    private javax.swing.JTextField friend;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel profilepic;
    private javax.swing.JButton search;
    private javax.swing.JButton send;
    private javax.swing.JTextField text;
    // End of variables declaration//GEN-END:variables
}

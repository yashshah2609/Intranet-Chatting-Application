/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranet.chat;
import static intranet.chat.Server.db;
import java.io.*;
import java.net.*;
import java.sql.Blob;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author AmiYash
 */
class comm extends Thread
    {
    private static Socket s1[];
    private DataInputStream din1= null;
    private DataOutputStream dout1=null;
    private DataOutputStream dout2=null;
        
        public comm(Socket s01[],int i,int j){
            try{
                s1=s01;
                din1=new DataInputStream(s1[i].getInputStream());
                dout2=new DataOutputStream(s1[j].getOutputStream());
                dout1=new DataOutputStream(s1[i].getOutputStream());
                }catch(IOException e){
                System.out.println("problem while connecting to another node.");
                }
        }
        
        public void run(){
            try{
                System.out.print("started messing");
                 String s="";
                while(true){
                    s=din1.readUTF();
                    System.out.println("message recieved");
                    if(s.equals("*#*#*#"))              //break for client 1
                        break;
                    //dout2.writeUTF("online");
                    dout2.writeUTF(s);  
                    dout2.flush();
                    System.out.println("message send");
                    }  
                    //din1.close();
                    //dout2.close();
                    System.out.println("closed");
            }
            catch(Exception e){
            System.out.println("Client disconnected"+e);
            }
        }
    }

class connector extends Thread{
    
        private static Socket id[]=null;
        private static Socket mes[]=null;
        private static Socket fl[]=null;
        private static Socket perm[]=null;
        private Socket s=null;
        private DataInputStream din = null;
        private DataOutputStream dout = null;
        byte barr[]=null;
        int ind;
        public connector(Socket s1[],Socket s2[],Socket s3[],Socket s4[],int ind1) throws IOException
                {
                id=s1;
                mes=s2;
                fl=s3;
                perm=s4;
                ind=ind1;
                din=new DataInputStream(id[ind].getInputStream());
                dout=new DataOutputStream(id[ind].getOutputStream());
                }
        
public int search(String cust2)
{
    String sql = "SELECT * FROM info WHERE userid=?" ; 
      PreparedStatement ps;
             try {
                 ps = db.getCon().prepareStatement(sql);
                 ps.setString(1,cust2);
                 ResultSet rs  =  ps.executeQuery();
                 
                  if(rs.next()){
                      String number=rs.getString(2);
                      Blob b=rs.getBlob(6);
                      barr=b.getBytes(1,(int)b.length());
                      int index=Integer.parseInt(number);
                      System.out.println("index is :"+index);
                      if(id[index]!=null)
                     return index;
                 }
                  else
                      return 0;
             } catch (Exception ex) {
                                  JOptionPane.showMessageDialog(null,ex);
              }
             return 0;

}
public void run(){
    try{
    while(true){
    String cust2=din.readUTF();
    int index=search(cust2);
    if(index==0)
    {
        dout.writeUTF("no");
    }
    else{
    System.out.print("Index got");
        dout.writeUTF("yes");
        dout.writeInt(barr.length);
        dout.write(barr);
       din.readUTF();
    comm conv=new comm(mes,ind,index);
    conv.start();
    filemanage fm=new filemanage(fl,perm,ind,index);
    fm.start();
    }
    }
    }
    catch(Exception e)
    {
        id[ind]=mes[ind]=fl[ind]=perm[ind]=null;
        System.out.println("client disconnected");}
    
}
}
public class Server{
    
    public static DBConnect db = new DBConnect();
    private static ServerSocket ss[]=null;
    private static Socket s[]=null;
    private static Socket id[]=null;
    private static Socket mes[]=null;
    private static Socket fl[]=null;
    private static Socket perm[]=null;
   static byte barr1[]=null;
    private static DataInputStream din= null;
    private static DataOutputStream dout= null;
        static int rowCount;
        
        public static String pass[]=new String[2];
    public static int adddata()
    {
        try{
                String data[]=new String[5];
                for(int i=0;i<5;i++)
                data[i]=din.readUTF();  
                data[4]=""+ (rowCount+1);
                System.out.println("index is :"+data[4]);
                barr1=new byte[din.readInt()];
                din.read(barr1);
                if(barr1==null){
                File f1=new File("E:\\Imagere\\home.jpg");
                FileInputStream fis1=new FileInputStream(f1);
                barr1=new byte[(int)f1.length()];
                fis1.read(barr1);
                }
                pass[0]=data[1];
                pass[1]=data[0];
    String sql = "insert into info values(?,?,?,?,?,?)";
            PreparedStatement ps = db.getCon().prepareStatement(sql);
             ps.setString(1,data[2]);
             ps.setString(2,data[4]);
             ps.setString(3,data[3]);
             ps.setString(4,data[1]);
             ps.setString(5,data[0]);
             ps.setBinaryStream(6, new ByteArrayInputStream(barr1),barr1.length);
             ps.executeUpdate();
             rowCount++;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 0;
            //JOptionPane.showMessageDialog(null,"this user code is already in used");
        }
        return rowCount;
    }

    public static int verify(){
    String username,password;
      String sql = "SELECT * FROM info WHERE userid=? and password=?" ; 
      PreparedStatement ps;
             try {
                 username=din.readUTF();
                 password=din.readUTF();
                 ps = db.getCon().prepareStatement(sql);
                 ps.setString(1,username);
                 ps.setString(2,password);
                 ResultSet rs  =  ps.executeQuery();
                 
                  if(rs.next()){
                      pass[0]=rs.getString(4);
                      pass[1]=rs.getString(5);
                      String number=rs.getString(2);
                      Blob b=rs.getBlob(6);
                      barr1=b.getBytes(1,(int)b.length());
                      int index=Integer.parseInt(number);
                      System.out.println("index is :"+index);
                     return index;
                 }
                  
                 
             } catch (Exception ex) {
                                  JOptionPane.showMessageDialog(null,ex);
              }
             return 0;
    }
    
    
    
    public static void main(String[] args)throws Exception {
    try{
       PreparedStatement st = db.getCon().prepareStatement("SELECT COUNT(*) FROM info");
    ResultSet rs = st.executeQuery();
    // get the number of rows from the result set
    rs.next();
    rowCount = rs.getInt(1);
    System.out.println(rowCount);
        id=new Socket[rowCount+100];
        mes=new Socket[rowCount+100];
        fl=new Socket[rowCount+100];
        perm=new Socket[rowCount+100];
        ss=new ServerSocket[4];
        s=new Socket[4];
        while(true){
            ss[0]=new ServerSocket(3333);
            ss[1]=new ServerSocket(3334);
            ss[2]=new ServerSocket(3335);
            ss[3]=new ServerSocket(3332);
            //s=new Socket("localhost",3333);
            s[0]=ss[0].accept();
            s[1]=ss[1].accept();
            s[2]=ss[2].accept();
            s[3]=ss[3].accept();
            din=new DataInputStream(s[0].getInputStream()); 
            dout=new DataOutputStream(s[0].getOutputStream());
                if(ss[0].isBound())
                        System.out.println("Client connected");
                String ipAddress =  s[0].getRemoteSocketAddress().toString();
                System.out.println("IP Address: "+ipAddress);
                int go=0;
                String mode=din.readUTF();
                if(mode.equals("Register"))
                {     
                    System.out.println("going to register");
                    go=adddata();
                }
                else{
                    go=verify();
                    }
                if(go>0)
                    {    //JOptionPane.showMessageDialog(null,"Successfully login");
                        dout.writeUTF("permit");
                        dout.writeUTF(pass[0]);
                        dout.writeUTF(pass[1]);
                        dout.writeInt(barr1.length);
                        dout.write(barr1);
                        id[go]=s[0];
                        mes[go]=s[1];
                        fl[go]=s[2];
                        perm[go]=s[3];
                    }
                    else{
                        dout.writeUTF("nopermit");
                    }
                if(go>0)
                {
                    connector read=new connector(id,mes,fl,perm,go);
                    read.start();}
                   ss[0].close();
                   ss[1].close();
                   ss[2].close();
                   ss[3].close();
        }
    }
    catch(Exception e){
       e.printStackTrace();
             System.out.println(e);
    }
    }
    
}

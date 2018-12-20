/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranet.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author AmiYash
 */
public class filemanage extends Thread{
    public static Socket fl[] = null;
    public static Socket perm[] = null;
    private DataInputStream din1 = null;
    private DataOutputStream dout1 = null;
    private DataInputStream din2 = null;
    private DataOutputStream dout2 = null;
    private DataInputStream dinfl = null;
    private DataOutputStream doutfl = null;    
    int p1,p2;
    
    public filemanage(Socket s1[],Socket s2[],int i,int j) {
        try{
            fl=s1;
            perm=s2;
            p1=i;
            p2=j;
        din1=new DataInputStream(perm[p1].getInputStream());
        dout1=new DataOutputStream(fl[p1].getOutputStream());
        din2=new DataInputStream(perm[p2].getInputStream());
        dout2=new DataOutputStream(perm[p2].getOutputStream());
        dinfl=new DataInputStream(fl[p1].getInputStream());
        doutfl=new DataOutputStream(fl[p2].getOutputStream());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void run(){
    try{
        byte[] buffer; 
        while(true){
            System.out.println("waiting for change of user's friend");
            int in=din1.readInt();
            if(in==1)
            {
            System.out.println("1 got");
            break;
            }
            System.out.println("another got"+in);
            buffer = new byte[4096];
            String s1,s2;
            s1=s2=null;
            long s3;
            s1=din1.readUTF();
            s2=din1.readUTF();
            s3=din1.readLong();
            System.out.println(s1+"   "+s2+"   "+s3);
        dout2.writeUTF(s1);
        dout2.writeUTF(s2);
        dout2.writeLong(s3);
        System.out.println("File request sent");
        //byte flag=din2.readByte();
        //dout1.writeByte(flag);
        //System.out.println("watch"+flag+"watch");
        
          //  if(flag==1)
            //{   
                while(din1.readUTF().equals("true"))
                    {    
                        dinfl.read(buffer);
                        System.out.println("Data readed");
                        doutfl.write(buffer);
                        System.out.println("Data writen");
                    }
                buffer=null;
            //}
            doutfl.flush();
        }
        System.out.println("new friend to send");
    }
    catch(Exception e)
    {   System.out.println("File TRansfer intertupted");   }
    }
    
}

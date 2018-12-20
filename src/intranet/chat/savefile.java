/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranet.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AmiYash
 */
public class savefile extends Thread{
    private static Socket fl=null;
    private static Socket perm=null;
    private static DataInputStream din=null;
    private static DataOutputStream dout=null;
    private static DataInputStream dinfl=null;
    private static FileOutputStream fos=null;
    Object[] choice = {"Download",
            "Cancel"};
    JFrame frame=new JFrame();
    
    public savefile(Socket s1,Socket s2)
    {
        try{
                fl=s1;
                perm=s2;
                din=new DataInputStream(perm.getInputStream());
                dinfl=new DataInputStream(fl.getInputStream());
                dout=new DataOutputStream(perm.getOutputStream());
            }
        catch(IOException e){   e.printStackTrace();   }
    }
    
    static File makedir(String filename)
    {
            String path = "C:" + File.separator + "Intranet-chat Downloads" + File.separator + filename;
            File f = new File(path);
            try{
                f.getParentFile().mkdirs(); 
                f.createNewFile();
                }
            catch(IOException e){   e.printStackTrace();    }
            return f;
    }
    
    public void run(){
    try{
        System.out.println("Enter into file saving");
        while(true){  
            String sender,filename;
            Long filesize;
            sender=null;
            filename=null;
            sender=din.readUTF();
            filename=din.readUTF();
            filesize=din.readLong();
        System.out.println("Enter into file saving all got");
            
            //int n = JOptionPane.showOptionDialog(frame,
            //sender+" has sent you\n"+ "File : "+filename+"\nFileSize :"+filesize,"Download",
            //JOptionPane.YES_OPTION,
            //JOptionPane.QUESTION_MESSAGE,
            //null,    
            //choice,  
            //choice[0]);
            //System.out.println(n);
            //frame.dispose();
            File fl=null;
            //if(n==0)
            //{
              //  dout.writeByte(1);
                //dout.writeUTF("yes");
                fl=makedir(filename);
                fos = new FileOutputStream(fl);
		byte[] buffer = new byte[4096]; 
		long read = 0;
		long totalRead = 0;
		long remaining = filesize;
		while((read = dinfl.read(buffer, 0, Math.min(buffer.length, (int)remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0,(int)read);
		}
		System.out.println("File received");
                JOptionPane.showMessageDialog(null,sender+" has sent you\n"+ "File : "+filename+"\nFileSize :"+filesize+"\nFile received and saved at c->Intranet-chat Downloads.");
		fos.close();
                
            //}
            //else{
             //   dout.writeInt(0);
            //}
            //n=0;
    }
    }
    catch(Exception e){
    System.out.println("coming out from save file");   
    // e.printStackTrace();
    }
    }
    
    /*public static void main(String args[]){
            
            String sender,filename,filesize;
            sender="16bit055";
            filename="anything.txt";
            filesize="123456";
            Object[] choice = {"Download",
                    "Cancel"};
            JFrame frame=new JFrame();
            int n = JOptionPane.showOptionDialog(frame,
            sender+" want to send you\n"+ "File : "+filename+"\nFileSize :"+filesize,"Download",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    
            choice,  
            choice[0]);
            System.out.println(n);
            frame.dispose();
            if(n==0)
                makedir("yash.exe");
    }
    */
}

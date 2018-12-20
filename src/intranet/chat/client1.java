/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranet.chat;
import java.net.*;  
import java.io.*;
import java.util.*;
/**
 *
 * @author AmiYash
 */
public class client1 implements Runnable{
   
    
    private static Socket s= null;
    private static DataInputStream din = null;
    
    
    @Override
    public void run(){
    try{    String str2="";
    while(!str2.equals("stop")){
        str2=din.readUTF();  
        System.out.println("Server says: "+str2);
    }}
    catch(Exception e){}
    }
   
    
    public static void main(String args[]){
        try{
        s=new Socket("localhost",3333); 
        System.out.println(" Server Connected");
        din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        Scanner scan=new Scanner(System.in);
        String str=""; 
        client1 th=new client1();
        Thread read=new Thread(th);
        read.start();
        while(!str.equals("stop")){  
            str=scan.nextLine();
        dout.writeUTF(str);  
        dout.flush();  
        }  

        dout.close();  
        s.close();  
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}

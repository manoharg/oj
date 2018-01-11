/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oj;
    import java.io.*;
import java.net.*;
import java.sql.Connection;
import static oj.Homepage.ois;
import static oj.Homepage.oos;


/**
 *
 * @author manohar
 */
public class Client{
static String username,pwd,email,usercode;
static int i;
public Socket socket;
public  ObjectOutputStream oos; ObjectInputStream  ois;
Message rply=new Message();
public void create() throws IOException
{

       socket=new Socket("127.0.0.1",5000);
        System.out.println("client sock created");
             oos = new ObjectOutputStream(socket.getOutputStream());
             ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("client sock created");
}
  public  void send (Message msg) throws Exception
  {
 oos.writeObject(msg);
 oos.flush();
      System.out.println("Msg written ");
 //Homepage.oos.close();
                               // reading from keyboard (keyRead object)
  }
  public Message receive () throws IOException, ClassNotFoundException
  {
      rply=(Message)ois.readObject();
      return rply;
  }
  
}
                     
    


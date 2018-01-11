package ojserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import oj.Message;

public class Serverthread extends Thread {

     Message msg = new Message();
      Socket pipe;
    Serverthread(Socket pipe) 
        {
        this.pipe=pipe;
        }
      @Override
        public  void run()
        {
       try{
 ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());
ObjectOutputStream serverOutputStream = new  ObjectOutputStream(pipe.getOutputStream());
while(true)
{
 msg= (Message )serverInputStream.readObject();
 if(msg.code==1)
 {  
    
    int i=jdbc.checkRegistration(msg.username, msg.password, msg.email);
    if(i==1)
        msg.status=1;
    else
    {msg.status=0;
       
    }
            serverOutputStream.writeObject(msg);serverOutputStream.flush();
    }
               
 else if(msg.code==2)
 {//login
        msg=jdbc.Login(msg);
     
   serverOutputStream.writeObject(msg);serverOutputStream.flush();
 }else if(msg.code==3)//logout
 {          
   serverOutputStream.writeObject(msg);serverOutputStream.flush();
        pipe.close();
        Thread.currentThread().interrupt();
        return ;        
        
 }else if(msg.code==4)
 {System.out.print("in else if \n");
        msg.prblm=jdbc.loadprblm(msg.problmno);
        //System.out.print(msg.prblm);
        serverOutputStream.writeObject(msg);serverOutputStream.flush();//write and flush
        
 }else if(msg.code==5)
 {System.out.print("in compile \n");
       
        msg.cerror=jdbc.compile(msg.language,msg.inputcode,currentThread().getName());
        //update here 
        serverOutputStream.writeObject(msg);serverOutputStream.flush();//write and flush
        
 }
 else if(msg.code==6)
 {
        //execute
     System.out.println("In else if of execute\n");
     System.out.print("id"+msg.problmno);
     msg.verdict=jdbc.execute(msg.language,100,msg.problmno,currentThread().getName(),msg);
     //update here
     System.out.println("update");
     
     jdbc.update(msg.username, msg); System.out.println("after update");
     
     serverOutputStream.writeObject(msg);serverOutputStream.flush();//write and flush
     
 }else if(msg.code==7)
 {
     jdbc.refresh( msg); System.out.println("after update");
     serverOutputStream.writeObject(msg);serverOutputStream.flush();
     
 }
     
 
 
   //dont change these order   
                //serverOutputStream.close();
                //serverInputStream.close();
                
         }
       }
        
         catch(Exception e)
         {
            // System.out.println(e); this is for eof exception
         }
        }
    }

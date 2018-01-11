
package ojserver;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

   public static void main(String[] arg) {

Thread[] thrd=new Thread[10];
int count=-1;
      try {

         ServerSocket socketConnection = new ServerSocket(5000);

         System.out.println("Server Waiting");
         
while(true)
{
         Socket pipe = socketConnection.accept();
         count++;
         
             thrd[count] = new Thread( new Serverthread(pipe));
         thrd[count].start();
        
}
      


      
      }catch(Exception e) {System.out.println(e); 
      }
      
   }

}
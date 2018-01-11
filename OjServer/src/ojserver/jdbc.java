/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojserver;

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
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import oj.Message;

/**
 *
 * @author manohar
 */
public class jdbc {
    //Message msg=new Message();
    public static String prb="";
     public static  int checkRegistration(String username, String passwd, String email) throws SQLException {
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        System.out.println("connection success  1");

        PreparedStatement stmt = conn.prepareStatement("select * from users where username=? or email=?");
        stmt.setString(1, username);
        stmt.setString(2, email);
        ResultSet rs = stmt.executeQuery();
        //System.out.println("result ok");

        if (rs.next()) {
            ///JOptionPane.showMessageDialog(this, " Username or email already exits!!");
            
            conn.close();
            return 0;

        } else {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
            //Syst]em.out.println("connection success");
            stmt = conn.prepareStatement("insert into users(username,password,email) values(?,?,?)");

            stmt.setString(1, username);
            stmt.setString(3, email);
            stmt.setString(2, passwd);

            int kk = stmt.executeUpdate();
           /* if (kk > 0) {
               // JOptionPane.showMessageDialog(this, "Successfully Registered!!");
               
            } else {
                //JOptionPane.showMessageDialog(this, "Sorry !!! 404 Error");
            }
            */
            conn.close();

            return 1;

        }
    }

     public static Message  Login(Message msg) throws SQLException {
       int rtn;
       Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        //System.out.println("connection success  1");
        PreparedStatement stmt = conn.prepareStatement("select * from users where username=? and password=?");
        stmt.setString(1, msg.username);
        stmt.setString(2, msg.password);
        ResultSet rs = stmt.executeQuery();
        //System.out.print(rs.getString("username"));
        if (rs.next()) {
             msg.loginstatus =1;
             //msg.cAnswer=rs.getInt(5);
          msg.cAnswers=rs.getInt(5);
          msg.submissions=rs.getInt(6);
          msg.wrong=rs.getInt(7);
          msg.tle=rs.getInt(8);
          msg.segfault=rs.getInt(9);
        } else {
            msg.loginstatus = 0;

        }

        conn.close();
        
        return msg;
    }
     
     public static Message refresh(Message msg) throws SQLException
     {
        
         Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        //System.out.println("connection success  1");
        PreparedStatement stmt = conn.prepareStatement("select * from users where username=? and password=?");
        stmt.setString(1, msg.username);
        stmt.setString(2, msg.password);
        ResultSet rs = stmt.executeQuery();
        //System.out.print(rs.getString("username"));
        if (rs.next()) {
             msg.loginstatus =1;
             //msg.cAnswer=rs.getInt(5);
          msg.cAnswers=rs.getInt(5)-1;
          msg.submissions=rs.getInt(6)-1;
          msg.wrong=rs.getInt(7)-1;
          msg.tle=rs.getInt(8)-1;
          msg.segfault=rs.getInt(9)-1;
        } else {
            msg.loginstatus = 0;

        }

        conn.close();
        
        return msg;
         
     }
     
     
      public  static String  loadprblm(int id) throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        System.out.println("connection success id is "+id);
                PreparedStatement stmt = conn.prepareStatement("select * from problems where id=?");
                stmt.setInt(1,id);
                ResultSet  st=stmt.executeQuery();
               while( st.next()){
               
                prb=st.getInt(1)+st.getString(3)+"\n";
           
    }
              // System.out.print(prb);
               conn.close();
               return prb;
    
        
    }
      
    public  static int  compile (String l ,String code,String name) throws IOException
    {       System.out.print(l+code);
       // converttofile(l,code);
        
        
         BufferedWriter buf;
      System.out.print("converting");
    if(l.equals("c"))
    { buf=new BufferedWriter(new FileWriter("/home/manohar/Desktop/"+name+".c",false));
      buf.write(code);
      System.out.print("converting");
        buf.newLine();
        buf.close();
        System.out.print("writing wait");
      /*  PrintWriter out =new PrintWriter("/home/manohar/Desktop/pro2.c");
        out.println(code);
        */
    }
    else if(l.equals("cpp"))
    {
        buf=new BufferedWriter(new FileWriter("/home/manohar/Desktop/"+name+".cpp",false));
        buf.write(code);
        buf.newLine();
        buf.close();}
    else if(l.equals("python"))
    {buf=new BufferedWriter(new FileWriter("/home/manohar/Desktop/"+name+".py",false));
    buf.write(code);
        buf.newLine();
        buf.close();}
        
        
        
        
        
        
        System.out.println("Code compilation started...");
        ProcessBuilder p;
        boolean compiled = true;
       if (l.equals("c")) {
            p = new ProcessBuilder("gcc","-std=c++0x","-w","-o", "Main"+name, "/home/manohar/Desktop/"+name+".c");
        } else {
           p = new ProcessBuilder("g++","-std=c++0x","-w", "-o", "Main"+name, "/home/manohar/Desktop/"+name+".cpp");
        }
//        p.directory(new File(System.getProperty("/home/manohar")));
        p.redirectErrorStream(true);

        try {
            Process pp = p.start();
            pp.waitFor();
            InputStream is = pp.getInputStream();
            String temp;
            try (BufferedReader b = new BufferedReader(new InputStreamReader(is))) {
                while ((temp = b.readLine()) != null) {
                    compiled = false;
                    System.out.println(temp);
                }
                //pp.waitFor();
            }

            if (!compiled) {
                is.close();
                return 0;
            }
            is.close();
            return 1;

        } catch (IOException | InterruptedException e) {
            System.out.println("in compile() " + e);
        }

        return 0;
    
    }
    
 
     public  static int execute(String l,long timeInMillis,int id,String name,Message msg) throws FileNotFoundException, IOException, SQLException
    {String n;// n is input file
       n=getinput(id);
        System.out.println("Code started executing.");
        System.out.println("Input ksdhflskhfsl"+n);
        ProcessBuilder p;
        if (l.equals("c")) {
            p = new ProcessBuilder("./Main"+name);
        } else  {
            p = new ProcessBuilder("./Main"+name);
        }
        //p.directory(new File(System.getProperty("dir")));
        //File in = new File(n);
        File in =new File("/home/manohar/Desktop/inp"+name+".txt");//input file from database
         BufferedWriter buf=new BufferedWriter(new FileWriter(in,false));
      buf.write(n);
      System.out.print("converting");
        buf.newLine();
        buf.close();
        System.out.println("Input file is made\n");
        
        
        
        p.redirectInput(in);
        if(in.exists())
            System.out.println("Input file " + in.getAbsolutePath());
        p.redirectErrorStream(true);
       // System.out.println("Current directory " + System.getProperty("dir"));
        File out = new File( "/home/manohar/Desktop/output"+name+".txt");//user o/p file

        p.redirectOutput(out);
        if(out.exists())
            System.out.println("Output file generated " + out.getAbsolutePath());
        try {

            Process pp = p.start();
            if (!pp.waitFor(timeInMillis, TimeUnit.MILLISECONDS)) {
                return 1;//1 for tle
            }
            int exitCode = pp.exitValue();
            System.out.println("Exit Value = " + pp.exitValue());
            if(exitCode != 0)
                return 2;//run time error
        } catch (IOException ioe) {
            System.err.println("in execute() in process builder  "+ioe);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        System.out.println("Code execution finished!");
         String myoutput=getoutput(id);
        System.out.print("output from db"+myoutput);
        
        msg.showinp=n;
        msg.myoutput=myoutput;
        
        
        Scanner scan=new Scanner( new File("/home/manohar/Desktop/output"+name+".txt"));//output file conversion to string 
        String text=scan.useDelimiter("\\A").next();//above is same as 255 line
        scan.close();
        msg.showop=text;//user o/p
        text=text.trim();
        
        myoutput=myoutput.trim();
        System.out.print("-------------"+myoutput+"-------------user"+text);
        if(text.equals(myoutput))
            return 4;//Correct answer
        else
            return 3;//Wrong answer
    }
    
     public  static String  getinput(int id) throws SQLException
    {prb="";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        System.out.println("connection success id is "+id);
         System.out.println("In getinput \n ");
                PreparedStatement stmt = conn.prepareStatement("select inp from input where id=?");
                stmt.setInt(1,id);
                ResultSet  st=stmt.executeQuery();
               while( st.next()){
               
                prb=st.getString(1)+"\n";
           
    }    System.out.print("Input from database is\n");
              System.out.print(prb);
               conn.close();
               return prb;
    
        
    }
       public  static String  getoutput(int id) throws SQLException
    {prb="";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        System.out.println("connection success id is "+id);
                PreparedStatement stmt = conn.prepareStatement("select output  from input where id=?");
                stmt.setInt(1,id);
                ResultSet  st=stmt.executeQuery();
               while( st.next()){
                prb=st.getString(1)+"\n";
           
    } System.out.print("In GEtoutpt fn\n");
               System.out.print(prb);
               conn.close();
               return prb;
    
        
    }
       public static void update(String username,Message msg) throws SQLException
       {
           int i=0,j=0,k=0,l=0,m=0;
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "cccc");
        System.out.println("connection success id is "+username);
         System.out.println("In getinput \n ");
 PreparedStatement stmt = conn.prepareStatement("select correct,submissions,wrong ,tle,segfault from users where username=?");
                stmt.setString(1,username);
                ResultSet  st=stmt.executeQuery();
              
               while(st.next())
               { i= st.getInt(1); j= st.getInt(2); k= st.getInt(3); l= st.getInt(4); m= st.getInt(5); }
           System.out.println("In Updating========");
       // System.out.print(" "+ i + " " + j + " "+" "+k+" "+" "+l);
    if(msg.verdict==4)
        i++;
    if(msg.verdict==3)
        k++;
    if(msg.verdict==2)
        m++;
    if(msg.verdict==1)
        l++;
    j++;
  PreparedStatement tmt = conn.prepareStatement("update users set correct=?,submissions=?,wrong=?,tle=?,segfault=? where username=?");
tmt.setString(6,username);
tmt.setInt(1,i);tmt.setInt(2,j);tmt.setInt(3,k);tmt.setInt(4,l);tmt.setInt(5,m);
           System.out.println("after execute1");
     tmt.executeUpdate();
     
     System.out.println("after execute2");
      conn.close();     
       }
    
}

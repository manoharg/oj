/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oj;

import java.io.Serializable;

/**
 *
 * @author manohar
 */
public class Message implements Serializable{
    public String username="";
    public int code=0;
    public String password="";
    public String email="";
    public int status=0;
    public int loginstatus=0;
  
    public String inputcode="";
    public String language="";
    
    public int cAnswers=0;
    public int submissions=0;
    public int segfault=0;
    public int verdict=0;
    public int tle=0;
    public int cerror=0;
    public int wrong=0;
    
    
    public String answer="";
    public int noofw=0;
    public int noofc=0;
    public int noofr=0;
    
    public int problmno;
    public String prblm;
    
    
    public String showinp="";
    public String showop="";
    public String myoutput="";
    
    
    
    
    
    
}

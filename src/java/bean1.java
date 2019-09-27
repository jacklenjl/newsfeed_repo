
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kunal Baghel
 */
public class bean1 {

 private String user;
private String passwd;
private String status;
private static int stat;

  

  


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


  

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

 
    
    public String loginpass() throws ClassNotFoundException, SQLException
    {
      Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select usercheck,passcheck from checkuser where usercheck=? and passcheck=?");
String test;
ps.setString(1, user);
ps.setString(2, passwd);
ResultSet rs=ps.executeQuery();
//rs.next();
//test=rs.getString(1);
//if(test.equals("admin"))
  //  {return "yesadmin";}
if(!rs.isBeforeFirst())
{ 
  status="User name or password incorrect";
  stat=1;
    return "no";
}
else
    {
        stat=0;
        rs.next();
    test=rs.getString(1);
    if(test.equals("admin"))
        return "yesadmin";
    else
    {return "yes";}
    
    }
        
        
    }
    
   /*public String redirectlogin() throws IOException
    {
   ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();     
    if(stat==0)
    {
      
    stat=1;
        return null;
    
    }
else    
    {  context.redirect("login.xhtml");
    return null;
    }   
    }*/
     
   
    
     
     public  void valuechange()
     {
     
     stat=1;
     
     }
    public bean1() {
    }
    
}

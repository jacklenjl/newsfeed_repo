/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.servlet.http.Part;

@Named(value = "bean2")
@Dependent
public class bean2 {

    private String user;
    private String title;
    private int sr_no;
    private String l_title;
    private String result;
    private String test="hello";
    private Part file1,proj_file,ebook_file;
    private String ad;

    public Part getEbook_file() {
        return ebook_file;
    }
    public void setEbook_file(Part ebook_file) {
        this.ebook_file = ebook_file;
    }
    public Part getProj_file() {
        return proj_file;
    }
    public void setProj_file(Part proj_file) {
        this.proj_file = proj_file;
    }
    public String getL_title() {
        return l_title;
    }
    public void setL_title(String l_title) {
        this.l_title = l_title;
    }
    public int getSr_no() {
        return sr_no;
    }
    public void setSr_no(int sr_no) {
        this.sr_no = sr_no;
    }     
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public Part getFile1() {
        return file1;
    }
    public void setFile1(Part file1) {
        this.file1 = file1;
    }
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
String field_p,field_e;

    public String getField_p() {
        return field_p;
    }

    public void setField_p(String field_p) {
        this.field_p = field_p;
    }

    public String getField_e() {
        return field_e;
    }

    public void setField_e(String field_e) {
        this.field_e = field_e;
    }
   public void upload_news() throws ClassNotFoundException, SQLException, IOException
   {
 
 
   InputStream inputStream = file1.getInputStream();        
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\images\\"+getFilename(file1));
         
        byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = inputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
        outputStream.close();
        inputStream.close();
           Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into newsfeed_admin values(?,?,?,null)");
   ps.setString(1, user);
   ad="/resources/images/"+getFilename(file1);
        ps.setString(2, ad);
        ps.setString(3, title);
        ps.executeUpdate();
        con.close();
   }
   
   public void upload_latest_news() throws ClassNotFoundException, SQLException
   {
       Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into latest_news values (?)");

ps.setString(1, l_title);
ps.executeUpdate();
con.close();
       
   }
   
 
   

      public void delete_news() throws ClassNotFoundException, SQLException
   {
       //int x=Integer.parseInt(srno);
   Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("delete from newsfeed_admin where id=?;");
Statement st=con.createStatement();
       
   ps.setInt(1, sr_no);
   ps.executeUpdate();
   st.executeUpdate("ALTER TABLE newsfeed_admin DROP id;");
   st.executeUpdate("ALTER TABLE newsfeed_admin ADD id int PRIMARY KEY AUTO_INCREMENT;");
   con.close();
   }
   
   public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
     public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    
     
 private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
 
    public void upload_projects() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
   {
       InputStream inputStream = proj_file.getInputStream();        
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+getFilename(proj_file));
         
        byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = inputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
        outputStream.close();
        inputStream.close();
        if(field_p.equals("IT"))
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into projects_it values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(proj_file));
        ad="C:\\Users\\root\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+getFilename(proj_file);
        ps.setString(2, ad);
        ps.executeUpdate();
        con.close();
        }
        
        else if(field_p.equals("BMS")){
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into projects_bms values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(proj_file));
        ad="C:\\Users\\root\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+getFilename(proj_file);
        ps.setString(2, ad);
        ps.executeUpdate();
        con.close();}
        else if(field_p.equals("BAF")){
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into projects_baf values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(proj_file));
        ad="C:\\Users\\root\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+getFilename(proj_file);
        ps.setString(2, ad);
        ps.executeUpdate();
        con.close();}
   }
   
   public void upload_ebooks() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
   {
       InputStream inputStream = ebook_file.getInputStream();        
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+getFilename(ebook_file));
         
        byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = inputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
        outputStream.close();
        inputStream.close();
        if(field_e.equals("IT"))
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into ebooks_it values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(ebook_file));
        ad="/resources/ebooks/"+getFilename(ebook_file);
        ps.setString(2, ad);
        ps.executeUpdate(); 
        con.close();
        }
        else if(field_e.equals("BMS"))
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into ebooks_bms values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(ebook_file));
        ad="/resources/ebooks/"+getFilename(ebook_file);
        ps.setString(2, ad);
        ps.executeUpdate(); 
        con.close();
        }
        else if(field_e.equals("BAF"))
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into ebooks_baf values(?,?,null)");//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        ps.setString(1, getFilename(ebook_file));
        ad="/resources/ebooks/"+getFilename(ebook_file);
        ps.setString(2, ad);
        ps.executeUpdate(); 
        con.close();
        }
   }
  public void contact_detail() throws IOException, ClassNotFoundException, SQLException
  {
  Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=con.prepareStatement("insert into contact values(?,?,?,null)");
ps.setString(1,title);
ps.setString(2, l_title);
ps.setString(3, ad);
ps.executeUpdate();
con.close();
  
  
  
  }
  
  private String[] contact_name=new String[5000];
  private String[] contact_email=new String[5000];
  private String[] contact_messages=new String[50000];

    public String[] getContact_name() {
        return contact_name;
    }

    public void setContact_name(String[] contact_name) {
        this.contact_name = contact_name;
    }

    public String[] getContact_email() {
        return contact_email;
    }

    public void setContact_email(String[] contact_email) {
        this.contact_email = contact_email;
    }

    public String[] getContact_messages() {
        return contact_messages;
    }

    public void setContact_messages(String[] contact_messages) {
        this.contact_messages = contact_messages;
    }
  
  public void contact_retrive() throws ClassNotFoundException, SQLException
  {
      int j=0;
  Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from contact;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
  while(rs.next())
{   
    //for filling filenames and all those arrays
 contact_name[j]=(rs.getString(1));
    contact_email[j]=(rs.getString(2));
    contact_messages[j]=(rs.getString(3));
    j++;
}
  con.close();
  }
  
  
  
  
    public bean2() {
    }
    
}

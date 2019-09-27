/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TitledPane;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kunalbaghel
 */
@Named(value = "bean3")
@Dependent
public class bean3 {

  //static String f=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("listmehaha");

   // HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//private int f =Integer.parseInt(request.getParameter("hello"));
private static int f;
 public int getf(){
return f;
}
  
private String user;
private String[] title1=new String[1000];
private String[] titlell=new String[1000];

    public String[] getTitlell() {
        return titlell;
    }

    public void setTitlell(String[] titlell) {
        this.titlell = titlell;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
private String[] filedownloadname=new String[1000];

    public String[] getFiledownloadname() {
        return filedownloadname;
    }

    public String[] getTitle1() {
        return title1;
    }

    public void setTitle1(String[] title1) {
        this.title1 = title1;
    }

    public void setFiledownloadname(String[] filedownloadname) {
        this.filedownloadname = filedownloadname;
    }
 

  public void getvalueset(int i)
  {
 
 f=i;
  }
  

  

    public String[] getFilename() {
        return filename;
    }

    public void setFilename(String[] filename) {
        this.filename = filename;
    }

    public String[] getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String[] filelocation) {
        this.filelocation = filelocation;
    }

private String number[]=new String[5000];
private String filename[]=new String[5000];
private String filelocation[]=new String[5000];
   private String result;
   private String test[]=new String[5000];
   
   
  private String[] testreverse=new String[5000];
private String[] addreverse=new String[5000];
private String[] titlereverse=new String[5000];
private String[] ttitle2reverse=new String[5000];
private int[]idreverse=new int[10000];

    public String[] getTestreverse() {
        return testreverse;
    }

    public void setTestreverse(String[] testreverse) {
        this.testreverse = testreverse;
    }

    public String[] getAddreverse() {
        return addreverse;
    }

    public void setAddreverse(String[] addreverse) {
        this.addreverse = addreverse;
    }

    public String[] getTitlereverse() {
        return titlereverse;
    }

    public void setTitlereverse(String[] titlereverse) {
        this.titlereverse = titlereverse;
    }

    public String[] getTtitle2reverse() {
        return ttitle2reverse;
    }

    public void setTtitle2reverse(String[] ttitle2reverse) {
        this.ttitle2reverse = ttitle2reverse;
    }

    public int[] getIdreverse() {
        return idreverse;
    }

    public void setIdreverse(int[] idreverse) {
        this.idreverse = idreverse;
    }
   
   
private  StringBuilder sb=new StringBuilder();

    public String[] getNumber() {
        return number;
    }

    public void setNumber(String[] number) {
        this.number = number;
    }
int j=0,k=0;
private String[] address=new String[5000];
   public String[] getAddress() {
        return address;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }
    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

   

    public StringBuilder getSb() {
        return sb;
    }

    public String[] getTest() {
        return test;
    }

    public void setTest(String[] test) {
        this.test = test;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
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
private int[]id=new int[10000];

    public static int getF() {
        return f;
    }

    public static void setF(int f) {
        bean3.f = f;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
   public String submit() throws ClassNotFoundException, SQLException
   {j=0;
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from newsfeed_admin");
ResultSet rs=ps.executeQuery();


while(rs.next())
{ //  test[j]=(rs.getString(1));
 testreverse[j]=rs.getString(1);
  //  address[j]=(rs.getString(2));
 addreverse[j]=rs.getString(2);
  //title1[j]=(rs.getString(3));
  titlereverse[j]=rs.getString(3);
 idreverse[j]=(rs.getInt(4));
    j++;
}
j=j-1;
int nu=0;

 
PreparedStatement ps1=(PreparedStatement) con.prepareStatement("Select * from latest_news");
ResultSet rs1=ps1.executeQuery();
while(rs1.next())
{  ttitle2reverse[k]=(rs1.getString(1));
k++;
}
for(int i=j;i>=0;i--)
{

test[nu]=testreverse[i];
address[nu]=addreverse[i];
title1[nu]=titlereverse[i];
titlell[nu]=ttitle2reverse[i];
id[nu]=idreverse[i];
nu++;
}
con.close();

return "yes";

   }
   

 public void download(int i) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from bscrepo");
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}

    //File file = new File("/path/to/file.ext");
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+filename[i]);
    String fileName = file.getName();
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();


String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+fileName);
    
    byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
    fileInputStream.close();
// Now you can write the InputStream of the file to the above OutputStream the usual way.
    // ...

    fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}   
 
 public void downloadretriveprojects(String classify) throws ClassNotFoundException, SQLException//String classify parameter added
{
   if(classify.equals("IT"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_it");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
   if(classify.equals("BMS"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_bms");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
   if(classify.equals("BAF"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_baf");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
}

 public void downloadretriveebooks(String classify) throws ClassNotFoundException, SQLException//String classify parameter added
{
   if(classify.equals("IT"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_it");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
   if(classify.equals("BMS"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_bms");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
   if(classify.equals("BAF"))
   {
   Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_baf");//XXXXXXXXXXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
while(rs.next())
{   
 filename[j]=(rs.getString(1));
 filedownloadname[j]="Download";
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));//XXXXXXXXXXXXXXXXXXXXXXXX
   j++;
}
   }
}

 public void download_proj_IT(int i) throws IOException, ClassNotFoundException, SQLException 
 {
     //here variable i indicates file at i^th position in the database
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_it;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    //for filling filenames and all those arrays
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    //File file = new File("/path/to/file.ext");
    //--defining i^th filename and location from where we have to retrive the files in "File" types
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();


String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); //--The Save As popup magic is done here. You can give it any file name you want, we are giving the name of the project itself, (by-default)it will use current request URL as file name instead.
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+fileName);//The source file inputted
    
    byte[] buffer = new byte[4096]; //--Byte buffer       
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);//--The source file sent via http response as Byte Stream
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}   
 
  public void download_proj_BMS(int i) throws IOException, ClassNotFoundException, SQLException 
 {
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_bms;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+fileName);
    
    byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important
}
  
   public void download_proj_BAF(int i) throws IOException, ClassNotFoundException, SQLException 
 {
     //here variable i indicates file at i^th position in the database
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from projects_baf;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    //for filling filenames and all those arrays
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    //File file = new File("/path/to/file.ext");
    //--defining i^th filename and location from where we have to retrive the files in "File" types
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();


String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); //--The Save As popup magic is done here. You can give it any file name you want, we are giving the name of the project itself, (by-default)it will use current request URL as file name instead.
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\projects\\"+fileName);//The source file inputted
    
    byte[] buffer = new byte[4096]; //--Byte buffer       
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);//--The source file sent via http response as Byte Stream
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
} 

    public void download_ebooks_IT(int i) throws IOException, ClassNotFoundException, SQLException 
 {
     //here variable i indicates file at i^th position in the database
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_it;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    //for filling filenames and all those arrays
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    //File file = new File("/path/to/file.ext");
    //--defining i^th filename and location from where we have to retrive the files in "File" types
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();


String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); //--The Save As popup magic is done here. You can give it any file name you want, we are giving the name of the project itself, (by-default)it will use current request URL as file name instead.
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+fileName);//The source file inputted
    
    byte[] buffer = new byte[4096]; //--Byte buffer       
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);//--The source file sent via http response as Byte Stream
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}   
 
  public void download_ebooks_BMS(int i) throws IOException, ClassNotFoundException, SQLException 
 {
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_bms;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+fileName);
    
    byte[] buffer = new byte[4096];        
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important
}
  
   public void download_ebooks_BAF(int i) throws IOException, ClassNotFoundException, SQLException 
 {
     //here variable i indicates file at i^th position in the database
        Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tyaf","root","tiger");
PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from ebooks_baf;");//XXXXXXXXXXXXXXXX
ResultSet rs=ps.executeQuery(); 
j=0;
while(rs.next())
{   
    //for filling filenames and all those arrays
 filename[j]=(rs.getString(1));
    filelocation[j]=(rs.getString(2));
    number[j]=(rs.getString(3));
    j++;
}
    //File file = new File("/path/to/file.ext");
    //--defining i^th filename and location from where we have to retrive the files in "File" types
    File file=new File("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+filename[i]);
    String fileName = file.getName();//--to extract file name from 'file-type' and storing it in 'string-type'
     
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();


String contentType = ec.getMimeType(fileName);
int contentLength = (int) file.length();
        
    ec.responseReset();
    ec.setResponseContentType(contentType); 
    ec.setResponseContentLength(contentLength);
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); //--The Save As popup magic is done here. You can give it any file name you want, we are giving the name of the project itself, (by-default)it will use current request URL as file name instead.
    OutputStream outputStream = ec.getResponseOutputStream();
    FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Kunal Baghel\\Documents\\NetBeansProjects\\newsfeed_repo\\web\\resources\\ebooks\\"+fileName);//The source file inputted
    
    byte[] buffer = new byte[4096]; //--Byte buffer       
        int bytesRead;
        while(true) {                        
            bytesRead = fileInputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);//--The source file sent via http response as Byte Stream
            }else {
                break;
            }                       
        }
    fileInputStream.close();
fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
} 
 
 
 
 public static  Object[] createArray(int size) {
 
     return new Object[size];
}
    public bean3() {
        
    }
    
}

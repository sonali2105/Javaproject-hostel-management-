/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class db1 
{ 
    public static Statement st;  
       public static Connection c;
       public static PreparedStatement insertClient,updateClient,getClient;
    static
    {
    try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hosteldb","hosteldb");
    st=c.createStatement();
    insertClient=c.prepareStatement("insert into  hostel_info (name,fathername,"
            + "collegename,mobno,course,year,dob,address,state,email,room,roomno,fees) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
   getClient=c.prepareStatement("Select * from hostel_info where name like ?");
   updateClient=c.prepareStatement("Update hostel_info set name=?,fathername=?,collegename=?,"
           + "mobno=?,course=?,year=?,dob=?,address=?,state=?,email=?,room=?,roomno=?,fees=? where cid =?");
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null,ex); 
  }
  
}
      public static void dbClose()
    {
       try
       {
         c.close();  
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
    }
}

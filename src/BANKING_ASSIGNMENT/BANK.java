package BANKING_ASSIGNMENT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class BANK {

public static void main(String args[]) {
int i=0;
    Scanner sc= new Scanner(System.in);
    while(i<5){
    System.out.println("BANKING");

    System.out.println("ENTER THE SERVICE YOU WANT: ");

    System.out.println("1.Create Account");

    System.out.println("2.Check Balance");

    System.out.println("3.Withdraw Money ");

    System.out.println("4.Deposit Money");

    System.out.println("5.EXIT");

    int a= sc.nextInt();
	  try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "SYS AS SYSDBA";
	String password = "Qwerty123#";
	Connection con = DriverManager.getConnection(url,userName,password);
  
    switch(a){ 

    //Case statements 

    case 1: 

    System.out.println("Enter the  name");
   String s1=sc.next();
   System.out.println("Enter the account number");
   int s2=sc.nextInt(); 
   System.out.println("Enter the account Type");
   String s3=sc.next();
  System.out.println("Enter the Total balance");
  int s4=sc.nextInt();
	Statement stmt = con.createStatement();
    String query1 =  "INSERT INTO bank VALUES ('"+s1+"', '"+s2+"', '"+s3+"' ,'"+s4+"')";
    stmt.executeUpdate(query1);
    i++;
    break; 
    case 2:
    	System.out.println("Enter the  name");
     s1=sc.next();
    System.out.println("Enter the account number");
    s2=sc.nextInt(); 
    Statement stmt1 = con.createStatement();
    String q="select * from bank where name='"+s1+"' and Accountno='"+s2+"'";
    ResultSet rs= stmt1.executeQuery(q);
    
    if(rs.next())
    {
    System.out.println("Name of account holder: '"+rs.getString(1)+"'"); 

    System.out.println("Account no.: '"+rs.getString(2)+"'" ); 

    System.out.println("Account type:'"+rs.getString(3)+"' " ); 

    System.out.println("Balance: '"+rs.getString(4)+"'" ); 
    }
    else
    {
    	System.out.println("DATA NOT MATCHED"); 
    }
     i++;
    break; 
    case 3:
    System.out.println("Enter the  name");
    s1=sc.next();
   System.out.println("Enter the account number");
   s2=sc.nextInt(); 
   Statement stmt5 = con.createStatement();
   String q5="select Balance from bank where name='"+s1+"' and Accountno='"+s2+"'";
   ResultSet rs5= stmt5.executeQuery(q5);
   if(rs5.next())
   {
	   System.out.println("Enter the Withdraw Money");
       s4=sc.nextInt();
       int a1= rs5.getInt(1);
       if(a1>=s4) {
     int sum=a1-s4;
     Statement stmt3 = con.createStatement();
     stmt3.executeQuery("update bank set Balance='"+sum+"' where name='"+s1+"' and Accountno='"+s2+"'");
     System.out.println("Money withdrawn and Balance: "+sum); 
       }
       else
       {
    	   	System.out.println("Balance not available"); 
    	   
       }
   }
   else
   {
   	System.out.println("DATA NOT MATCHED"); 
   }

    i++;     
    break; 
    case 4: 
    	System.out.println("Enter the  name");
     s1=sc.next();
    System.out.println("Enter the account number");
    s2=sc.nextInt(); 
    Statement stmt2 = con.createStatement();
    String q1="select Balance from bank where name='"+s1+"' and Accountno='"+s2+"'";
    ResultSet rs1= stmt2.executeQuery(q1);
    if(rs1.next())
    {
    	System.out.println("Enter the Deposit Money");
        s4=sc.nextInt();
      int a1= rs1.getInt(1);
      int sum=s4+a1;
      Statement stmt3 = con.createStatement();
      stmt3.executeQuery("update bank set Balance='"+sum+"' where name='"+s1+"' and Accountno='"+s2+"'");
      System.out.println("Balance Updated"); 
    }
    else
    {
    	System.out.println("DATA NOT MATCHED"); 
    }

    i++;     
    break; 

    //Default case statement 

    default:System.out.println("THANK YOU2"); 
    i=5;
    break;

    }
		  con.close();  
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
    
}
		
} 	


}

package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Dbconnection {

	public static void main(String[] args)throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String user = "scott";
		String pwd = "tiger";
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select*from customer");
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		int ch1,Acc_No,pass_word,DAcc_No,Balance;
		String cus_name,sql;
           
		float deposit,withdraw;
		
	do
	{
		System.out.println("1.Create Account\n");
		System.out.println("2.Deposit\n");
		System.out.println("3.Withdraw\n");
		System.out.println("4.Balance\n");
		System.out.println("5.Exit\n");
		System.out.println("Enter your Choice");
		ch1=Integer.parseInt(b.readLine());
		switch(ch1)
		{
		case 1:
			
			System.out.println("Enter the Acc_NO");
			Acc_No=Integer.parseInt(b.readLine());
			System.out.println("Enter the name");
			cus_name=b.readLine();
			System.out.println("Enter the password");
			pass_word=Integer.parseInt(b.readLine());
			System.out.println("Enter the amount");
			Balance=Integer.parseInt(b.readLine());
			 stmt.executeQuery("select*from customer");
			 stmt.executeUpdate("insert into customer"+"values('"+Acc_No+"','"+cus_name+"','"+pass_word+"','"+Balance+"')");
			
			 
		break;
			
			
		case 2:
			System.out.println("Enter the account number");
			DAcc_No=Integer.parseInt(b.readLine());
			System.out.println("Enter the Amount to deposit");
			deposit=Float.parseFloat(b.readLine());
			sql="update customer set Balance=Balance +'"+deposit+"' where Acc_No ='"+DAcc_No+"'";
			stmt.executeUpdate(sql);
			
			System.out.println("----------------------------------------------------------------");
			break;
			
			
		case 3:
			System.out.println("Enter the Account number");
			DAcc_No=Integer.parseInt(b.readLine());
			System.out.println("Enter the Amount to Withdraw");
			withdraw=Float.parseFloat(b.readLine());
			sql="update customer set Balance=Balance - '"+withdraw+"'where Acc_No = '"+DAcc_No+"'";
			stmt.executeUpdate(sql);
			
			System.out.println("----------------------------------------------------------------");
			break;
			
			
		case 4:
			sql="select*from customer";
			rs=stmt.executeQuery(sql);
			
			System.out.println("Acc_No"+"    "+"cus_name"+"    "+"Balance");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("Acc_No")+"  "+rs.getString("cus_name")+"  "+rs.getFloat("Balance"));
			}
			rs.close();
			
			System.out.println("----------------------------------------------------------------");
			break;
			
			
		case 5: break;
		default: System.out.println("invalid choice");
		}
	}while(ch1<5);
			
	
		
	}	
		

	
}



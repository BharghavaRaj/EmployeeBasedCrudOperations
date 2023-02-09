package com.technologiespalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperations {
	//Req: When we run the programm, it should give below options to user.
	
		Connection con = null;
		Statement s = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		public static String url="jdbc:mysql://localhost:3306/jdbccrudproj";
		public static String username="root";
		public static String password="admin";
		
		public void creating() //Creating the table
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				s=con.createStatement();
				
				String qry = "create table employee(eid int primary key,ename varchar(40),esalary int)";
				
				s.executeUpdate(qry);
			}
			catch(ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if(s != null) 
					{
						s.close();
					}
					if(con != null) 
					{
						con.close();
					}
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		public void inserting(int eid,String ename,int esalary)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				ps=con.prepareStatement("insert into employee(eid,ename,esalary)values(?,?,?)");				
				ps.setInt(1, eid);
				ps.setString(2, ename);
				ps.setInt(3,esalary);
					
				ps.executeUpdate();

				rs =ps.executeQuery("select * from employee");
					
				while(rs.next()==true)
				{
					System.out.println(rs.getInt("eid"));
					System.out.println(rs.getString("ename"));
					System.out.println(rs.getInt("esalary"));
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		public void updating(int eid,String ename,int esalary)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				ps=con.prepareStatement("update employee set ename=?,esalary=? where eid=?");
				ps.setString(1, ename);
				ps.setInt(2, esalary);
				ps.setInt(3, eid);
				
				ps.executeUpdate();
				
				rs =ps.executeQuery("select * from employee");
				
				while(rs.next()==true)
				{
					System.out.println(rs.getInt("eid"));
					System.out.println(rs.getString("ename"));
					System.out.println(rs.getInt("esalary"));
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
	
		}
		public void deleting(int eid) 
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				ps=con.prepareStatement("delete from employee where eid=?");
				ps.setInt(1, eid);
				
				ps.executeUpdate();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		
	}


package com.ty.appdevelopment.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.appdevelopment.app.App;
import com.ty.appdevelopment.dto.AppBean;

public class AppDAOImpl implements AppDAO {

	public List<AppBean> getAllContactData(){
		
		String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
		String sql = "select name from Contact";
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<AppBean> result = new ArrayList<>();
			while(rs.next()) {
			AppBean bean = new AppBean();
			String name = rs.getString("name");
					bean.setName(name);
					
					result.add(bean);
			}		
			return result;
			}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}else if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}	
		public AppBean searchContact(String name) {
			String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
			String sql = "select * from Contact where name=?";
			java.sql.Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
				AppBean bean = new AppBean();
				bean.setName(rs.getString("Name"));
				bean.setNumber(rs.getInt("Number"));
				bean.setGroupName(rs.getString("Group_name"));
				return bean;
				}	else {
					return null;
				}
				
				}catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}else if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
}
		
		
		public int add(AppBean bean) {
			String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
			String sql = "insert into Contact values(?,?,?)";
			java.sql.Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);
				
				
				String name = bean.getName();
				pstmt.setString(1, name);
				
				int number  = bean.getNumber();
				pstmt.setInt(2, number);
				
				String groupName = bean.getGroupName();
				pstmt.setString(3, groupName);
			
				
				int count = pstmt.executeUpdate();
				return count;
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		public int delete(String name) {
			String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
			String sql = "delete from Contact where name=?";
			java.sql.Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				int count = pstmt.executeUpdate();
				return count;
				
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		public int update(AppBean bean) {
			String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
			String sql = "update Contact set Number=?,Group_name=? where Name=?";
			java.sql.Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);
				
				int number = bean.getNumber();
				pstmt.setInt(1, number);
				
				
				String groupName = bean.getGroupName();
				pstmt.setString(2, groupName);
				
				String name = bean.getName();
				pstmt.setString(3, name);
				
				int count = pstmt.executeUpdate();
				return count;
				
				
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		@Override
		public void mainmanu() {
	     App a=new App();
	     a.main(null);
			
		}
		}
	
		


package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import test.Friend;


public class FriendDBAImpl implements FriendDBA {
	String url,user,pwd;
	public FriendDBAImpl() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
	}
	
	//ÏπúÍµ¨Ï∂îÍ?
	@Override
	public void friendInsert(Friend f) {
		// TODO Auto-generated method stub
		
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = DriverManager.getConnection(url,user,pwd);
				String sql = "insert into friend "
						+ "values(FRIEND_SEQ.nextval,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, f.getName());
				ps.setString(2, f.getBirth());
				ps.setString(3, f.getPhone());
				ps.setString(4, f.getAddr());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}

	//ÏπúÍµ¨?†ÑÏ≤¥Î≥¥Í∏?
	@Override
	public ArrayList<Friend> friendView() {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			ArrayList<Friend> arr = new ArrayList<>();
			
			try {
				con = DriverManager.getConnection(url, user, pwd);
				String sql = "select * from friend";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					Friend f = new Friend();
					f.setName(rs.getString("name"));
					f.setBirth(rs.getString("birth"));
					f.setPhone(rs.getString("phone"));
					f.setAddr(rs.getString("addr"));
					arr.add(f);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(con!=null) con.close();
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return arr;
			}
	

	//ÏπúÍµ¨Í≤??Éâ
	@Override
	public ArrayList<Friend> friendSearch(String str, String word) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend>arr = new ArrayList<>();
		
		try {
		con=DriverManager.getConnection(url, user, pwd);
		st = con.createStatement();
		String sql = "select*from friend where "+ str + " like '%"+word+"%'";
		rs=st.executeQuery(sql);
		while(rs.next()) {
			Friend f = new Friend();
			f.setNum(rs.getInt(1));
			f.setAddr(rs.getString("addr"));
			f.setBirth(rs.getString("birth"));
			f.setName(rs.getString("name"));
			f.setPhone(rs.getString("phone"));
			arr.add(f);
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return arr;
	}

	//?ÉÅ?Ñ∏Î≥¥Í∏∞
	public Friend friendSelect(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			String sql = "select*from friend where num="+num;
			rs = st.executeQuery(sql);
			while(rs.next()) {
				f = new Friend();
				f.setNum(rs.getInt(1));
				f.setAddr(rs.getString("addr"));
				f.setBirth(rs.getString("birth"));
				f.setName(rs.getString("name"));
				f.setPhone(rs.getString("phone"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
		
		//?Ç≠?†ú
		public void friendDelete(int num) {
			Connection con = null;
			Statement st = null;
			
			try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from friend where num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(st!=null)st.close();
					if(con!=null)con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//?àò?†ï
		public void friendUpdate(Friend f) {
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = DriverManager.getConnection(url,user,pwd);
				String sql = "update friend"
						+ "set Name=?, Birth=?, indate=?, outdate=?, gubun=?, price=?, where num=?";
				ps = con.prepareStatement(sql);
			
				ps.setString(1, f.getName());
				ps.setString(2, f.getBirth());
				ps.setString(3, f.getIndate());
				ps.setString(4, f.getOutdate());
				ps.setString(5, f.getGubun());
				ps.setInt(6, f.getPrice());
				ps.setInt(7, f.getNum());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
		

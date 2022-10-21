package com.ssafy.empapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.User;
import com.ssafy.empapp.util.DBUtil;
@Repository
public class UserDAOImpl implements UserDAO {

	
	@Override
	public String login(String userId,String password) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name from userinfo where userid=? and password=?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} finally {
			DBUtil.close(rs,pstmt,conn);
		}
		return null;
	}

	@Override
	public int regist(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into userinfo(userid,password,name,email) values(?,?,?,?)";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			
			int rowCnt = pstmt.executeUpdate();
			System.out.println("user insert");
			
			return rowCnt;
		}finally {
			DBUtil.close(pstmt,conn);
		}
		
		
	}
}










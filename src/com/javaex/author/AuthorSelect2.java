package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorSelect2 {	// 리스트에 담아서 확인하기
	
	public static void main(String[] args) {
		
		
		List<AuthorVo> vlist=new ArrayList<AuthorVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    // 2. Connection 얻어오기
			String url="jdbc:mysql://localhost:3306/book_db";
			conn=DriverManager.getConnection(url, "book", "book");

		    // 3. SQL문 준비 / 바인딩 / 실행
			String query="";
			query+=" select author_id, ";
			query+=" 		author_name, ";
			query+="		author_desc ";
			query+=" from author ";
			
			pstmt=conn.prepareStatement(query);
			
			rs=pstmt.executeQuery();
		    
		    // 4.결과처리
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String na=rs.getString(2);
				String de=rs.getString(3);
				AuthorVo v01=new AuthorVo(id , na , de);
				vlist.add(v01);
			}
			
			System.out.println(vlist.toString());
			
			for(int i=0; i<vlist.size(); i++) {
				int no=vlist.get(i).getAuthorID();
				String na=vlist.get(i).getAuthorName();
				String de=vlist.get(i).getAuthorDesc();
				System.out.println(no+"\t"+ na+"\t"+ de);
			}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		
		
	}
}

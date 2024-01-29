package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorSelectOne {
	
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
			query += " select 	author_id, ";
			query += "          author_name, ";
			query += "          author_desc ";
			query += " from author ";

		    pstmt=conn.prepareStatement(query);
		    
		    rs=pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	int id=rs.getInt("author_id");
		    	String na=rs.getString("author_name");
		    	String de=rs.getString("author_desc");
		    	
		    	AuthorVo v00=new AuthorVo(id, na, de);
		    	vlist.add(v00);
		    }
		    
		    System.out.println("작가 번호를 입력하세요");
		    Scanner sc=new Scanner(System.in);
		    int i=sc.nextInt()-1;
		    
		    System.out.println(vlist.get(i));
		    
		    sc.close();
		    // 4.결과처리

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

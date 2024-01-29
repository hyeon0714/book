package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelect {
	
	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

		    // 2. Connection 얻어오기
			String url="jdbc:mysql://localhost:3306/book_db";
			conn=DriverManager.getConnection(url,"book","book");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//준비
			String query="";				//mysql 쿼리문을 가져와서 실행
			query+=" select	author_id, ";
			query+="		author_name, ";
			query+=" 		author_desc ";
	        query+=" from author ";
			
	        //조인도 연결 이상없음
	        
			//바인딩
			pstmt=conn.prepareStatement(query);
			
			
			//실행
			rs = pstmt.executeQuery();	//ResultSet은 생략후 rs만 사용
			
		    // 4.결과처리
			/*
			rs.next();						//첫번째 줄은 컬럼명이기에 줄바꿈을 실행
			int id=rs.getInt("author_id");
			System.out.println(id);
			String na=rs.getString(2);		//컬럼의 순서대로 출력한다면 컬럼명 대신에 숫자를 넣을수도 있다
			System.out.println(na);
			String de=rs.getString("author_desc");
			System.out.println(de);			//next 줄바꿈이 1개 이므로 컬럼명을 스킵하고 1번 row의 값을 출력한다
			*/
			
			while(rs.next()) {		//rs.next()는 바꿀 줄이 없으면 false값이 나온다
				int id=rs.getInt("author_id");
				String na=rs.getString(2);
				String de=rs.getString("author_desc");
				System.out.println(id+"\t"+na+"\t"+de);
				
			}// 반복문으로 전체 출력해보기
			

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

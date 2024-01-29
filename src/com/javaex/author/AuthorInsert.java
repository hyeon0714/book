package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		
		//현재 book_db에서 작가 추가
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// (프로젝트의 드라이버 클래스를 올리는것)
			
		    // 2. Connection 얻어오기
			String url="jdbc:mysql://localhost:3306/book_db";
			// (jdbc의 mysql을 불러오고, 호스트 주소를 입력, 불러올 db명을 입력한다) 
			
			conn = DriverManager.getConnection(url,"book","book");
			// (conn이라는 connection을 이용해서 드라이버에서 위에 입력한 호스트명과, db명이 입력된 변수를 가져오고)
			// (해당 db의 아이디:'book', 비번'book'을 입력해준다 
			
		    // 3. SQL문 준비 / 바인딩 / 실행	//insert,delete,update
			
			// SQL문 준비
			String query ="";
			query +="insert into author ";		//query를 작성할때 공백 한칸을 줘야 밑에 문과 연결된다
			query +="values(null,?,?)";			//데이터 값을 입력해야 할곳은 ? 처리를 해준다 null은 auto_increment로 자동 입력된다
		    /*
		     *	insert into author
		     *	values(null,'황일영','학원강사'); 이런 결과가 나온다
			*/
			
			// 바인딩
			pstmt=conn.prepareStatement(query);	//위에서 준비된 문법을 conn이라는 연결문에 prepareStatement라는 준비된 문법에 넣어준다
			pstmt.setString(1, "이문열");
			pstmt.setString(2, "경북 영양");	//준비된 query에서 첫번째 ?와 두번째 ?에 들어갈 값을 하나씩 세팅
			
			// 실행
			int count = pstmt.executeUpdate();
			
			
		    // 4.결과처리
			System.out.println(count +"건 등록되었습니다");
			
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

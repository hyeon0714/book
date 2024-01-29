package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectOne {
	
	public static void main(String[] args) {
		
		List<BookVo> bList=new ArrayList<BookVo>();
		
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
					String query="";
					query+=" select	book_id, ";
					query+="		title, ";
					query+="		pubs, ";
					query+="		date_format(pub_date, '%Y- %m- %d') date, ";
					query+="		author_id ";
					query+=" from book ";
					
					pstmt=conn.prepareStatement(query);
					
					rs=pstmt.executeQuery();
					
					while(rs.next()) {
						int id=rs.getInt("book_id");
						String title=rs.getString("title");
						String pubs=rs.getString("pubs");
						String date=rs.getString("date");
						int id2=rs.getInt("author_id");
						
						BookVo bv=new BookVo(id, title, pubs, date, id2);
						bList.add(bv);
					}
					System.out.println("책번호를 입력하세요");
					
					Scanner sc=new Scanner(System.in);
					int i=sc.nextInt()-1;
					
					System.out.println(bList.get(i));
					
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

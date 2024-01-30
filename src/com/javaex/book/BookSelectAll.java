package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

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
					query+="		date_format(pub_date, '%Y-%m-%d') date, ";
					query+="		b.author_id, ";
					query+="		a.author_id, ";
					query+="		author_name, ";
					query+="		author_desc ";
					query+=" from book b, author a ";
					query+=" where b.author_id=a.author_id ";
					
					pstmt=conn.prepareStatement(query);
					
					rs=pstmt.executeQuery();
					
					while(rs.next()) {
						int id=rs.getInt("book_id");
						String title=rs.getString("title");
						String pubs=rs.getString("pubs");
						String date=rs.getString("date");
						int id2=rs.getInt("b.author_id");
						int id3=rs.getInt("a.author_id");
						String name=rs.getString("author_name");
						String desc=rs.getString("author_desc");
						
						BookVo bv=new BookVo(id, title, pubs, date, id2, id3, name, desc);
						bList.add(bv);
					}
					
					for(int i=0; i<bList.size(); i++) {
						int id=bList.get(i).getBook_id();
						String title=bList.get(i).getTitle();
						if(title.length()<8) {
							title=String.format("%-25S", title);
						}else {
							title=String.format("%-15S", title);
						};
						String pubs=bList.get(i).getPubs();
						pubs=String.format("%-25S", pubs);
						String date=bList.get(i).getDate();
						int id2=bList.get(i).getAuthor_id1();
						int id3=bList.get(i).getAuthor_id2();
						String name=bList.get(i).getName();
						String desc=bList.get(i).getDesc();
						System.out.println(id+"\t"+title+"\t"+pubs+"\t"+date+"\t"+id2+"\t"+id3+"\t"+name+"\t"+desc);
					}
				    
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



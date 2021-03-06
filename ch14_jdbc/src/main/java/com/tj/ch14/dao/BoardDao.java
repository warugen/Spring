package com.tj.ch14.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tj.ch14.constant.Constant;
import com.tj.ch14.dto.BoardDto;

public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private JdbcTemplate template;		// template 추가
	
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		template = Constant.template;
	}
	/*
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	*/
	
	// 글 목록
	public ArrayList<BoardDto> list(final int startRow, final int endRow){
		
		//Connection conn = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"    FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, BSTEP) A) " + 
				"WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		/*
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		*/
	}
	
	// 글 갯수 가져오기
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForInt(sql);
		/*
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				totCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return totCnt;
		*/
	}
	
	// 원글쓰기
	public int write(final BoardDto dto) {
		String sql = "INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip());
				
			}
		});
		/*
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "글쓰기 성공" : "글쓰기 실패");
			
		} catch (Exception e) {
			System.out.println("글쓰기 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
		*/
	}
	
	// hit수 올리기
	public void hitUp(int bid) {
		String sql = "UPDATE MVC_BOARD SET bHIT = bHIT + 1 " + 
				"WHERE bID = " + bid;
		template.update(sql);
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET bHIT = bHIT + 1 " + 
				"WHERE bID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, bid);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("조회수 올리기 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		*/
	}
	
	// 글 상세보기(글상세보기 할때 조회수 1올리기)
	public BoardDto contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE bID = " + bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		/*
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE bID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dto;
		*/
	}
	
	// bid로 dto가져오기 (답변글 쓰기 버튼 + 수정글 쓰기 버튼 누를때)
	public BoardDto modfy_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE bID = " + bid;
		return (BoardDto)template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		/*
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE bID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return dto;
		*/
	}
	
	// 글 수정하기
	public int modify(final BoardDto dto) {
		
		return template.update(new PreparedStatementCreator() {
			
			String sql = "UPDATE MVC_BOARD SET bNAME = ?, " + 
					"                    bTITLE = ?, " + 
					"                    bCONTENT = ?, " + 
					"                    bIP = ? " + 
					"WHERE bID = ?";
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip());
				pstmt.setInt(5, dto.getBid());
				return pstmt;
			}
		});
		
		/*
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET bNAME = ?, " + 
				"                    bTITLE = ?, " + 
				"                    bCONTENT = ?, " + 
				"                    bIP = ? " + 
				"WHERE bID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			pstmt.setInt(5, dto.getBid());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "글수정 성공" : "글수정 실패");
			
		} catch (Exception e) {
			System.out.println("글수정 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
		*/
	}
	
	// 글 삭제하기
	public int delete(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE bID = " + bid;
		return template.update(sql);
		/*
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MVC_BOARD WHERE bID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "글삭제 성공" : "글삭제 실패");
			
		} catch (Exception e) {
			System.out.println("글삭제 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
		*/
	}
	
	
	// 답변글 쓰기전 step-A
	private void preReplyStepA(final int bgroup, final int bstep) {
		String sql = "UPDATE MVC_BOARD SET bSTEP = bSTEP +1 WHERE bGROUP = ? AND bSTEP > ?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);		
			}
		});
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET bSTEP = bSTEP +1 WHERE bGROUP = ? AND bSTEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("답변글쓰기 stepA 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		*/
	}
	
	// 답변글 쓰기
	public int reply(final BoardDto dto) {
		// bname, btitle, bcontent, bip : 답변글에 대한 정보
		// bgroup, bstep, bindent : 원글에 대한 정보
		preReplyStepA(dto.getBgroup(), dto.getBstep());
		
		String sql = "INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setInt(4, dto.getBgroup());
				pstmt.setInt(5, dto.getBstep() + 1);
				pstmt.setInt(6, dto.getBindent() + 1);
				pstmt.setString(7, dto.getBip());
				
			}
		});
		/*
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, dto.getBgroup());
			pstmt.setInt(5, dto.getBstep() + 1);
			pstmt.setInt(6, dto.getBindent() + 1);
			pstmt.setString(7, dto.getBip());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "답변쓰기 성공" : "답변쓰기 실패");
			
		} catch (Exception e) {
			System.out.println("답변쓰기 예외" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
		*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

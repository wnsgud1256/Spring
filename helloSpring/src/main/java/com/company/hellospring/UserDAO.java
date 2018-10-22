package com.company.hellospring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

@Repository //bean 등록.
//sql구문과 DTO만 있으면됨
public class UserDAO {

	Connection conn ;
	PreparedStatement pstmt;
	ResultSet rs;			//자주 쓰이는 변수 3개 전역변수 선언
	
	//싱글톤 필요x
	
	//등록
	public int insertUser(UserDTO dto) { //DB에 컬럼에 대한 변수가 선언 되어 있는 dto
		int r= 0;
		
		//1단계 : connect
		//2단계 : statement sql 구문을 시작해 주는 클래스   prepared : sql 구문을 미리 준비해라.
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO Users(ID,PASSWORD,NAME,ROLE) VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//3단계 : 실행
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
			r = pstmt.executeUpdate(); //   resultsert 결과를 얻어오는것
			//4단계 결과처리
			System.out.println(r + "건이 처리됨");
		} catch (Exception e) {
			System.out.println("오류");
		} finally {
			//5단계 : 연결해제        finally
			try {
				if (pstmt !=null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn !=null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return r;
	}
	
	//단건조회
	public UserDTO getUser(UserDTO dto) {
		UserDTO userDTO = null; //변수생성 후 초기화
		
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM USERS WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {	//넥스트를 하면 커서가 첫번째로 이동
				userDTO = new UserDTO();
				userDTO.setId(rs.getString("Id"));
				userDTO.setPassword(rs.getString("Password"));
				userDTO.setName(rs.getString("Name"));
				userDTO.setRole(rs.getString("Role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt !=null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn !=null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return userDTO;
	}
	
	//전체조회
	public List<UserDTO> getUsers() {
		//항상 리턴 타입이 있으면 그값을 담을 변수를 생성 해야함
		List<UserDTO> list = new ArrayList<UserDTO>();
		UserDTO userDTO = null; //변수생성 후 초기화
		
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM USERS order by id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	//넥스트를 하면 커서가 첫번째로 이동 , 전체조회라서 while문으로 바뀜
				userDTO = new UserDTO(); //조회되는 건수만큼 객체를 생성 해야함.
				userDTO.setId(rs.getString("Id"));
				userDTO.setPassword(rs.getString("Password"));
				userDTO.setName(rs.getString("Name"));
				userDTO.setRole(rs.getString("Role"));
				list.add(userDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt !=null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn !=null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	//수정
	
	//삭제
	  
}
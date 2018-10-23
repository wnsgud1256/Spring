package com.company.hellospring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.hellospring.board.BoardDAOmybatis;
import com.company.hellospring.board.BoardDTO;
import com.company.hellospring.emp.EmpDAO;
import com.company.hellospring.emp.EmpDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context-test.xml") //클래스 패치는 자바 파일의 경로를 알려줌
public class EmpDAOClient {

		@Autowired EmpDAO dao;
		@Autowired BoardDAOmybatis boarddao;  //인젝션 걸어줌.
		
		@Test
		public void getCnt() {
			//System.out.println("전체 건수: " + dao.getCnt());
/*			List<EmpDTO> list = dao.getSalaryTOP3();
			for(EmpDTO emp : list) {
				System.out.println(emp.getFirstName()+":"+emp.getLastName() + ":" + emp.getSalary());*/
				//EmpDTO dto = new EmpDTO();
				//dto.setFirstName("Den");
				//dto.setDepartmentId("110");
				//List<EmpDTO> list = dao.getEmps(dto);
				//System.out.println("조회건수:" + list.size());
				//for(EmpDTO emp : list ) {
					//System.out.println(emp);
	//	List<Map<String,Object>> list = dao.getEmpDept();
				//System.out.println(list);
			/*	for(int i=0; i<list.size(); i++) {
					HashMap<String, Object> map= (HashMap<String, Object>) list.get(i);
					
				
				System.out.println("부서이름 :" + map.get("deptName") +"===="+ "이름 : "+ map.get("fname"));
				}
				
				EmpDTO dto = new EmpDTO();
				dto.setLastName("홍길동");
				dto.setEmail("a@b.f");
				dto.setHireDate("2018/01/01");
				dto.setJobId("IT_PROG");
				dao.insertEmp(dto);
				System.out.println("등록 사원 번호: " + dto.getEmployeeId());*/
				
				//게시글 등록
			  BoardDTO dto = new BoardDTO();
			  dto.setTitle("프로시저 테스트1");
			  dto.setWriter("유재석");
			  dto.setContent("등록 테스트2 입니다.");
			  boarddao.insertBoardProc(dto);  //insertboardproc를 호출
			  System.out.println(dto.getSeq());
			  System.out.println(dto.getOutmsg());
			}
		}
		


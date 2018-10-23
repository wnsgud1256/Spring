package com.company.hellospring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.company.hellospring.emp.EmpDTO;

//List, set, Map
//많이사용함
public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List
		List<String> list =new ArrayList<String>();
		//추가
		list.add("바나나");
		list.add("딸기");
		list.add(0,"딸기");
		System.out.println(list);
		//변경
		list.set(1, "포도");
		System.out.println(list);
		//조회
	//	System.out.println( list.get(1));
		//삭제
		list.remove(1);
		System.out.println(list);
		//전체조회
		for(int i=0; i<list.size(); i++) {
			String temp = list.get(i);
			System.out.println();	
		}
		System.out.println("확장 ============================================");
		for( String temp : list ) {			//list에 있는 갯수 만큼 자동으로 for문을 돔 temp는 임시변수, 
			System.out.println(temp);
		}
		System.out.println("iterator===============================");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			
			
		}
		List<EmpDTO> empList =new ArrayList<EmpDTO>();
		empList.add(new EmpDTO("100","kim","a@b.c","99/11/01","IT"));
		empList.add(new EmpDTO("101","park","a@b.c","99/11/01","IT"));
		empList.add(new EmpDTO("102","choi","a@b.c","99/11/01","IT"));
		System.out.println(empList);
		
		System.out.println("확장 for====================");
		for( EmpDTO emp : empList) {
			System.out.println( " 사원번호 : "+emp.getEmployeeId()+
								" 이름 : " +emp.getLastName() );
		}
		
		System.out.println("iterator2=====================");
		Iterator<EmpDTO> iteremp = empList.iterator();
		while(iteremp.hasNext()) {
			EmpDTO emp = iteremp.next();
			System.out.println(" 사원번호 : "+emp.getEmployeeId() +
							   " 이름 : " + emp.getLastName() );
		}
	}

}

package polymorphism.coupling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV)factory.getBean(SamsungTV.class); //여기서의 tv는 applicationContext에 있는 id 값을 뜻함
		//클래스명의 맨앞글자를 소문자로 바꾼후 클래스를 입력하면 해당 클래스에 있는 객체가 사용됨 
		//클래스 타입으로도 검색 가능.
		//아이디 타입으로도 검색 가능.
		
		tv.powerOn();
		tv.volumeUp();
		System.out.println(((SamsungTV)tv).getProgram()); //캐스팅 = 형변환
	//	tv.volumeDown();
	//	tv.powerOff();
		
	//	TV tv2 = (TV)factory.getBean("tv"); 
	//	tv2.powerOn();
	}
}

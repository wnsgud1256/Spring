package polymorphism.coupling;

import java.util.List;

import javax.annotation.Resource;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;*/
import org.springframework.stereotype.Component;

@Component //어플리케이션 컨텍스트에 자동으로 아이디는 tv 클래스는 samsungtv로 됨.
public class SamsungTV implements TV {
	//@Autowired 의존관계의 객체를 찾아서 주입시켜줌, 타입만 찾음
	//@Qualifier 이름,  구현클래스가 여러개일때 쓰면 좋음.
	@Resource(name="sony")// Autowired 와 Qualifier의 기능을 합쳐놓은기능, name을 쓰면 이름을 가지고 찾아오고 name을 쓰지 않으면 클래스를 찾아줌. 
	private Speaker speaker; // 필드(멤버변수)가 정확한 명칭 = 속성/property(설계사의 명칭) 
	private int price;
	private List<String> program;
	
	public List<String> getProgram() {
		return program;
	}
	public void setProgram(List<String> program) {
		this.program = program;
	}
	//DI방식 : set,get방식
	public Speaker getSpeaker() {	//set,get 메소드를 이용해 초기화를함.
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	//DI방식 : 생성자
	public SamsungTV() {}
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV 생성자 호출");
		this.speaker = speaker;
	}
	
	

public SamsungTV(Speaker speaker, int price) {
	System.out.println("===> SamsungTV 생성자 호출 - 인수 2");
		this.speaker = speaker;
		this.price = price;		//price초기화
	}


public void initMethod() {	//객체 생성 시점에 초기화 메소드 실행. 객체를 요청할때마다 생성해주는것이 아닌 객체최초 요청시만 생성함.
		System.out.println("초기화 작업 처리^_^...");
	}
	
	public void destoryMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
	
}

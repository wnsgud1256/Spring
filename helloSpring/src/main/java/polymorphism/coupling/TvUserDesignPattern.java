package polymorphism.coupling;

public class TvUserDesignPattern {

	public static void main(String[] args) { //팩토리  메서드

		BeanFactory factory = new BeanFactory();  // 싱글톤 방식.
		TV tv = (TV)factory.getBean(args[0]); 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
			
		//factory를 이용해 소스코드를 변경하지 않고 객체를 생성하는게 핵심  
	}
}

package polymorphism.coupling;

public class LgTV implements TV{ //tv 개발 표준을 정함

	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	public void volumeUp() {
		System.out.println("LgTV soundUp");
	}
	public void volumeDown() {
		System.out.println("LgTV soundDown");
	}	
}

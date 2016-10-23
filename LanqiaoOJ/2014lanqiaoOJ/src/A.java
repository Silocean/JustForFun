interface B {
	public void f();
}

class C implements B {

	@Override
	public void f() {
		System.out.println("dfadfa");
	}

}

public class A {
	public static void main(String[] args) {
		B b = new C();
		b.f();
	}
}
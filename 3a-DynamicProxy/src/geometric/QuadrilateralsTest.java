package geometric;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuadrilateralsTest {

	static Quadrilaterals originalQuadrilateralsFactory() {
		return new Quadrilaterals();
	}
	QuadrilateralsInterface QuadrilateralsFactory1() {
		Quadrilaterals q = new Quadrilaterals();
		InvocationHandler handler1 = new QuadrilateralsProxy(q);
		QuadrilateralsInterface quadrilateralsProxy = (QuadrilateralsInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						QuadrilateralsInterface.class.getClassLoader(),
						new Class[] { QuadrilateralsInterface.class },
						handler1 );
		return quadrilateralsProxy;
	}
	QuadrilateralsInterface2 QuadrilateralsFactory2() {
		Quadrilaterals q2 = new Quadrilaterals();
		InvocationHandler handler2 = new QuadrilateralsProxy(q2);
		QuadrilateralsInterface2 quadrilateralsProxy2 = (QuadrilateralsInterface2)
				java.lang.reflect.Proxy.newProxyInstance(
						QuadrilateralsInterface2.class.getClassLoader(),
						new Class[] { QuadrilateralsInterface2.class },
						handler2 );
		return quadrilateralsProxy2;
	}
	public QuadrilateralsInterface q;
	public QuadrilateralsInterface2 q2;

	@BeforeMethod 
	public void setup(){
		q = QuadrilateralsFactory1();
		q2 = QuadrilateralsFactory2();
	}
	@Test
	public void testQuad1() {
		q.setArea(3,3);
		assertEquals( q.getArea(), 9 );
	}
	@Test
	public void testQuad2() {
		q2.setArea(2,2);
		assertEquals( q2.getPerimeter(), 8 );
	}
	@Test
	public void testQuad3() {
		q.setArea(3,3);
		assertEquals( q.getName(), "Square" );
	}
	@Test
	public void testQuad4() {
		q.setArea(2,3);
		assertEquals( q.getName(), "Rectangle" );
	}
}
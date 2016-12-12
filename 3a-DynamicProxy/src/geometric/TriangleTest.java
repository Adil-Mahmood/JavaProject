package geometric;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleTest {

	static Triangle originalTriangleFactory() {
		return new Triangle();
	}

	TriangleInterface TriangleFactory() {
		Triangle t = new Triangle();
		InvocationHandler handler = new TriangleProxy(t);
		TriangleInterface TriangleProxy = (TriangleInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						TriangleInterface.class.getClassLoader(),
						new Class[] { TriangleInterface.class },
						handler );
		return TriangleProxy;
	}

	public TriangleInterface t;

	@BeforeMethod 
	public void setup(){
		t = TriangleFactory();
	}

	@Test
	public void testTriangle1() {
		t.setTriangle(5,5,5);
		assertEquals( t.getTriangleName(), "Equilateral" );
	}
	@Test
	public void testTriangle2() {
		t.setTriangle(5,0,5);
		assertEquals( t.getTriangleName(), "Invalid" );
	}
	@Test
	public void testTriangle3() {
		t.setTriangle(6,6,3);
		assertEquals( t.getTriangleName(), "Isosceles" );
	}
	@Test
	public void testTriangle4() {
		t.setTriangle(7,6,3);
		assertEquals( t.getTriangleName(), "Scalene" );
	}
	@Test
	public void testTriangle5() {
		t.setTriangle(0,0,0);
		assertEquals( t.getTriangleName(), "Invalid" );
	}
}
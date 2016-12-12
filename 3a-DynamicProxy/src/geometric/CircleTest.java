package geometric;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CircleTest {


	static Circle originalCircleFactory() {
		return new Circle();
	}

	CircleInterface CircleFactory() {
		Circle c = new Circle();
		InvocationHandler handler = new CircleProxy(c);
		CircleInterface CircleProxy = (CircleInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						CircleInterface.class.getClassLoader(),
						new Class[] { CircleInterface.class },
						handler );
		return CircleProxy;
	}

	public CircleInterface c;

	@BeforeMethod 
	public void setup(){
		c = CircleFactory();
	}
	
	@Test
	public void testCircle1() {
		c.setRadius(10);
		assertEquals( c.getCircleArea(), 314.1592653589793 );
	}
	@Test
	public void testCircle2() {
		c.setRadius(10);
		assertEquals( c.getCirclePerimeter(), 62.83185307179586);
	}
	@Test
	public void testCircle3() {
		c.setRadius(10);
		assertEquals( c.getCircleName(), "Circle");
	}
}
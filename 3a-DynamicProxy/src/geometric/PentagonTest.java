package geometric;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PentagonTest {


	static Pentagon originalPentagonFactory() {
		return new Pentagon();
	}

	PentagonInterface PentagonFactory() {
		Pentagon p = new Pentagon();
		InvocationHandler handler = new PentagonProxy(p);
		PentagonInterface PentagonProxy = (PentagonInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						PentagonInterface.class.getClassLoader(),
						new Class[] { PentagonInterface.class },
						handler );
		return PentagonProxy;
	}

	public PentagonInterface p;

	@BeforeMethod 
	public void setup(){
		p = PentagonFactory();
	}
	@Test
	public void testPentagon1() {
		p.setSides(10);
		assertEquals( p.getPentagonArea(), 172.0477400588967);
	}
	@Test
	public void testPentagon2() {
		p.setSides(10);
		assertEquals( p.getPentagonPerimeter(), 50.0);
	}
	@Test
	public void testPentagon3() {
		p.setSides(10);
		assertEquals( p.getPentagonName(), "Pentagon");
	}

}
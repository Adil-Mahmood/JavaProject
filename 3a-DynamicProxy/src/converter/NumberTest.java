package converter;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NumberTest {


	static NumberToWord originalNumberToWordFactory() {
		return new NumberToWord();
	}

	NumberToWordInterface NumberFactory() {
		NumberToWord n = new NumberToWord();
		InvocationHandler handler = new NumberProxy(n);
		NumberToWordInterface NumberProxy = (NumberToWordInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						NumberToWordInterface.class.getClassLoader(),
						new Class[] { NumberToWordInterface.class },
						handler );
		return NumberProxy;
	}

	public NumberToWordInterface n;

	@BeforeMethod 
	public void setup(){
		n = NumberFactory();
	}
	
	@Test
	public void testNumber1() {
		n.setNumber(123);
		assertEquals( n.getNumberString(), "one hundred twenty three");
	}
	@Test
	public void testNumber2() {
		n.setNumber(123456);
		assertEquals( n.getNumberString(), "one hundred twenty three thousand four hundred fifty six");
	}
	@Test
	public void testNumber3() {
		n.setNumber(12345678);
		assertEquals( n.getNumberString(), "twelve million three hundred forty five thousand six hundred seventy eight");
	}
}
package geometric;
import converter.NumberProxy;
import converter.NumberToWord;
import converter.NumberToWordInterface;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShapesTest {

	/**
	 * Quadrilaterals Factory
	 * */
	static Quadrilaterals originalQuadrilateralsFactory() {
		return new Quadrilaterals();
	}

	QuadrilateralsInterface QuadrilateralsFactory() {
		Quadrilaterals q = new Quadrilaterals();
		InvocationHandler handler = new QuadrilateralsProxy(q);
		QuadrilateralsInterface quadrilateralsProxy = (QuadrilateralsInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						QuadrilateralsInterface.class.getClassLoader(),
						new Class[] { QuadrilateralsInterface.class },
						handler );
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
/**
 * Circle Factory
 * */
	static Circle originalCircleFactory() {
		return new Circle();
	}

	CircleInterface CircleFactory() {
		Circle q = new Circle();
		InvocationHandler handler = new CircleProxy(q);
		CircleInterface CircleProxy = (CircleInterface)
				java.lang.reflect.Proxy.newProxyInstance(
						CircleInterface.class.getClassLoader(),
						new Class[] { CircleInterface.class },
						handler );
		return CircleProxy;
	}
	/**
	 * Pentagon Factory
	 * */
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
	/**
	 * Triangle Factory
	 * */
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
	/****/
	/**
	 * Number Factory
	 * */
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
	/****/
	public QuadrilateralsInterface q;
	public QuadrilateralsInterface2 q2;
	public CircleInterface c;
	public PentagonInterface p;
	public TriangleInterface t;
	public NumberToWordInterface n;

	@BeforeMethod 
	public void setup(){
		q = QuadrilateralsFactory();
		q2 = QuadrilateralsFactory2();
		c = CircleFactory();
		p = PentagonFactory();
		t = TriangleFactory();
		n = NumberFactory();
	}
	/**
	 * QuadrilateralsFactory Test
	 * ***/
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
	/**
	 * CircleFactory Test
	 * ***/
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
	/**
	 * PentagonFactory Test
	 * ***/
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
	/**
	 * Triangle Test
	 * ***/
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
	/**
	 * NumberFactory Test
	 * ***/
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
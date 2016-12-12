package sb;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

public class SquareTestInstrumented {

	private Square s;
	
	@BeforeClass public void createSquare() throws Exception {
		instrumentSquare();
		s=new Square();		
	}
	
	@Test public void test1() {
		s.setl(4);
		assertEquals( s.getl(), 4 );
	}

	// Instrument & load, so no instrumented class file required
	// Alternative: use a java agent and the Java Instrumentation api
	static void instrumentSquare() throws Exception {

		ClassPool pool = ClassPool.getDefault();
		CtClass compiledClass = pool.get("sb.Square");

		//CtField f=new CtField( CtClass.longType, "temp_timer", compiledClass );
		CtField f=new CtField( CtClass.intType, "temp_numberOfCall", compiledClass );
		compiledClass.addField( f );
		
		CtMethod method = compiledClass.getDeclaredMethod("setl");
		method.insertBefore("System.out.println(\"setl(\"+$1+\") start\");");
		method.insertAfter("System.out.println(\"setl() end\");");

		method = compiledClass.getDeclaredMethod("getl");
		method.insertBefore(
				//"temp_timer = System.nanoTime();"
				"temp_numberOfCall = 0;"
		);
		
		method.insertAfter(
				/*"temp_timer = System.nanoTime() - temp_timer;" +
				"System.out.println(\"getl() took \"+temp_timer+\" ns\");"*/
				"temp_numberOfCall ++;"+
				"System.out.println(\"getl() was called \"+temp_numberOfCall+\" time\");"
		);

		// Load the instrumented class into the jvm
		compiledClass.toClass();
	    
	}

}
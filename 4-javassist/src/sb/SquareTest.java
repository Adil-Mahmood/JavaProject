package sb;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

public class SquareTest {

	private Square s;
	
	@BeforeClass public void createSquare() throws Exception {
		s=new Square();		
	}
	
	@Test public void test1() {
		s.setl(4);
		assertEquals( s.getl(), 4 );
	}

}
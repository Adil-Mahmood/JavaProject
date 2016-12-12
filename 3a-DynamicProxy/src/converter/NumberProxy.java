package converter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NumberProxy implements InvocationHandler{
	private Object obj;

	public NumberProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rv=null;//rv=ReturnValue
		try {
			System.out.print("NumberToWord Calling: "+obj.getClass().getName()+"."+method.getName()+"( ");
			if (args!=null)
				for (Object o: args)
					System.out.print(args[0]+" ");
			System.out.println(")");
			// Could use getDeclaredMethod(m.getName()) and Method.invoke() to make this generic
			NumberToWord n = (NumberToWord)obj;
			if (method.getName().equals("setNumber"))
				n.setNumber((int)args[0]);
			else if (method.getName().equals("getNumberString"))
				rv = n.getNumberString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if (rv!=null)
			System.out.println("NumberToWord Report: return value="+rv);
		return rv;
	}
}

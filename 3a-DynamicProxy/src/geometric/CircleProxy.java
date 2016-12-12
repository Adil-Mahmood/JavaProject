package geometric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CircleProxy implements InvocationHandler{
	private Object obj;

	public CircleProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rv=null;//rv=ReturnValue
		try {
			System.out.print("CircleProxy Calling: "+obj.getClass().getName()+"."+method.getName()+"( ");
			if (args!=null)
				for (Object o: args)
					System.out.print(args[0]+" ");
			System.out.println(")");
			// Could use getDeclaredMethod(m.getName()) and Method.invoke() to make this generic
			Circle c = (Circle)obj;
			if (method.getName().equals("setRadius"))
				c.setRadius((int)args[0]);
			else if (method.getName().equals("getCircleArea"))
				rv = c.getCircleArea();
			else if (method.getName().equals("getCirclePerimeter"))
				rv = c.getCirclePerimeter();
			else if (method.getName().equals("getCircleName"))
				rv = c.getCircleName();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if (rv!=null)
			System.out.println("CircleProxy Report: return value="+rv);
		return rv;
	}
}

package geometric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class QuadrilateralsProxy implements InvocationHandler{
	private Object obj;

	public QuadrilateralsProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rv=null;
		try {
			System.out.print("QuadrilateralsProxy Calling: "+obj.getClass().getName()+"."+method.getName()+"( ");
			if (args!=null)
				for (Object o: args)
					System.out.print(args[0]+" ");
			System.out.println(")");
			// Could use getDeclaredMethod(m.getName()) and Method.invoke() to make this generic
			Quadrilaterals q = (Quadrilaterals)obj;
			if (method.getName().equals("setArea"))
				q.setArea((int)args[0], (int)args[1]);
			else if (method.getName().equals("getArea"))
				rv = q.getArea();
			else if (method.getName().equals("getPerimeter"))
				rv = q.getPerimeter();
			else if (method.getName().equals("getName"))
				rv = q.getName();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if (rv!=null)
			System.out.println("QuadrilateralsProxy Report: return value="+rv);
		return rv;
	}
}

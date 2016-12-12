package geometric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TriangleProxy implements InvocationHandler{
	private Object obj;

	public TriangleProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rv=null;//rv=ReturnValue
		try {
			System.out.print("TriangleProxy Calling: "+obj.getClass().getName()+"."+method.getName()+"( ");
			if (args!=null)
				for (Object o: args)
					System.out.print(args[0]+" ");
			System.out.println(")");
			// Could use getDeclaredMethod(m.getName()) and Method.invoke() to make this generic
			Triangle t = (Triangle)obj;
			if (method.getName().equals("setTriangle"))
				t.setTriangle((int)args[0],(int)args[1],(int)args[2]);
			else if (method.getName().equals("getTriangleName"))
				rv = t.getTriangleName();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if (rv!=null)
			System.out.println("TriangleProxy Report: return value="+rv);
		return rv;
	}
}

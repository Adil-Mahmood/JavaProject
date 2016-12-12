package geometric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PentagonProxy implements InvocationHandler{
	private Object obj;

	public PentagonProxy(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rv=null;//rv=ReturnValue
		try {
			System.out.print("PentagonProxy Calling: "+obj.getClass().getName()+"."+method.getName()+"( ");
			if (args!=null)
				for (Object o: args)
					System.out.print(args[0]+" ");
			System.out.println(")");
			// Could use getDeclaredMethod(m.getName()) and Method.invoke() to make this generic
			Pentagon p = (Pentagon)obj;
			if (method.getName().equals("setSides"))
				p.setSides((int)args[0]);
			else if (method.getName().equals("getPentagonArea"))
				rv = p.getPentagonArea();
			else if (method.getName().equals("getPentagonPerimeter"))
				rv = p.getPentagonPerimeter();
			else if (method.getName().equals("getPentagonName"))
				rv = p.getPentagonName();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if (rv!=null)
			System.out.println("PentagonProxy Report: return value="+rv);
		return rv;
	}
}

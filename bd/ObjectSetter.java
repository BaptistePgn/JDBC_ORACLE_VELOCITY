package bd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectSetter {

	public static void set(Object o, String propName, Object val) {
		if (val == null) return;
		Class c = o.getClass() ;
		String methodName = "set" + propName.substring(0, 1) +  propName.substring(1).toLowerCase();
		Method m = null ;
		try {
			Class[] args = new Class[1];
			if(val.getClass() == Double.class){
				args[0] = double.class;
			} else if(val.getClass() == Float.class){
				args[0] = float.class;
			} else if(val.getClass() == Integer.class){
				args[0] = int.class;
			} else {
				args[0] = val.getClass() ;
			}
			m = c.getMethod(methodName, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		Object[] params = new Object[1];
		params[0] = val ;
		if ( m != null ) {
			try {
				m.invoke(o, params);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
}

package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调度处理器
 * 
 * @author wwn
 *
 */
public class ProxyHandler implements InvocationHandler {

	/**
	 * InvocationHandler是Proxy 类的代理，也就是真实对象的代理 的代理 <br>
	 * proxy是代理的实例，method是被调用的方法，args是参数
	 */

	private RealObject realObject;

	public ProxyHandler(RealObject realObject) {
		this.realObject = realObject;
	}

	/**
	 * 需解决问题 :<br>
	 * 1、proxy为啥要传进来，下面没有使用的地方 <br>
	 * 2、invoke是被谁调用的-----通过proxy0的method被调用的，而proxyHandler是proxy0的属性 <br>
	 * 3、 method的invoke是怎么实现的 --------两个参数分别是对象和参数 <br>
	 * 4、代理模式的目的和动态代理的目的
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 这边可以是逻辑处理
		System.out.println("调用" + method.getName() + "之前");
		Object object = null;
		try {
			object = method.invoke(realObject, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("调用" + method.getName() + "之后");
		return object;
	}

}

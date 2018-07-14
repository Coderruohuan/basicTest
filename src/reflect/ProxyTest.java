package reflect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * 用代理实现
 * 
 * @author Administrator
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		// 这样生成的是一个代理对象
		RealObject obj = new RealObject();
		RealObjectInterface realObject = (RealObjectInterface) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(), new Class[] { RealObjectInterface.class }, new ProxyHandler(obj));
		// 因为上面RealObjectInterface realObject
		// 实现的是proxy的实例，所以会调用proxy的invoke，看proxy0的源码可以知道，调用print就是调用ProxyHandler的invoke
		realObject.print();

		// 输出Proxy0代理类源码
		byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass("$Proxy0", RealObject.class.getInterfaces());
		FileOutputStream out = null;

		try {
			out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\cms\\basicTest\\bin\\reflect\\Proxy0.class");
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

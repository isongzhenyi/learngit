package com.pp.client;
 // https://blog.csdn.net/mn960mn/article/details/52104634
import java.net.MalformedURLException;
import java.net.URL;
 
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
 
import com.pp.client.ws.LoginService;
import com.pp.client.ws.PPLoginService;
 
public class AppClient {
 
	//��ʽһ
	public static void fun1() throws Exception {
		URL url = new URL("http://127.0.0.1:6644/user/login?wsdl");
		//QName����������������LoginService�����ע��
		QName qname = new QName("http://wsapi.pp1618.com", "PPLoginService");
		Service service = Service.create(url, qname);  
		LoginService ls = service.getPort(LoginService.class);
		System.out.println(ls.login("admin", "123"));
		System.out.println(ls.login("admin", "admin"));
	}
	
	//��ʽ��(PPLoginService�ڲ���ʵʹ�õ��Ƿ�ʽһ)
	public static void fun2() throws Exception {
		URL url = new URL("http://127.0.0.1:6644/user/login?wsdl");
		PPLoginService ppls = new PPLoginService(url);
		LoginService ls = ppls.getLoginServicePort();
		System.out.println(ls.login("admin", "123"));
		System.out.println(ls.login("admin", "admin"));
	}
	
	//��ʽ����ʹ��spring��װ�ķ�ʽ
	public static void fun3() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WSConfig.class);
		LoginService ls = context.getBean(LoginService.class);
		System.out.println(ls.login("admin", "123"));
		System.out.println(ls.login("admin", "admin"));
		context.close();
	}
	
	public static void main(String[] args) throws Exception {
		fun1();
		fun2();
		fun3();
	}
}
 
@Configuration
class WSConfig {
	
	@Bean
	public JaxWsPortProxyFactoryBean createMainCouponService() throws MalformedURLException {
		//JaxWsPortProxyFactoryBean ����spring-web.jar����
		JaxWsPortProxyFactoryBean bean = new JaxWsPortProxyFactoryBean();
		bean.setServiceInterface(LoginService.class);
		bean.setServiceName("PPLoginService");
		bean.setWsdlDocumentUrl(new URL("http://127.0.0.1:6644/user/login?wsdl"));
		//���ó�ʱ
		bean.addCustomProperty("com.sun.xml.internal.ws.request.timeout", 20000);
		bean.addCustomProperty("com.sun.xml.internal.ws.connect.timeout", 20000);
		return bean;
	}
}
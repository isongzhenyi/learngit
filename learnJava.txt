2018年8月28日
-- aliyun中央仓库
 <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>*</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
  </mirror> 
-- applicationContext-annotation.xml对应在sever层的的注解
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor =	{ RuntimeException.class, Exception.class })
public void openStock(String sname, int amount)
{
	sdao.insertStock(sname, amount);
}
-- 集中配置spring的版本号
<properties>
        <!-- spring.version不是固定的，也可以是其他，比如：springframework-version -->
	    <spring.version>4.3.14.RELEASE</spring.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<!-- 解决提示jdk不一致的问题 -->
		<maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.source>1.8</maven.compiler.source>
	</properties>

	<dependencies>  	
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
   </dependencies>  
-- 一个系统连接多个数据库的情况
两个数据源（dataSource，dataSourceTwo），两个事务管理器（transactionManager，transactionManagerTwo）
1）第一个数据源，使用第一个事务管理器
@Override
@Transactional(value = "transactionManager",readOnly = false)
public void insert 
{
}

2）第二个数据源，使用第二个事务管理器
@Transactional(value = "transactionManagerTwo",readOnly = false)
public void insert 
{
}

2018年8月26日
-- 事务管理 @Transactiona
https://segmentfault.com/a/1190000014617571 
https://segmentfault.com/a/1190000014897709
https://www.cnblogs.com/milton/p/6046699.html
http://www.cnblogs.com/caoyc/p/5632963.html 
http://www.cnblogs.com/yepei/p/4716112.html 
https://blog.csdn.net/MR_chaihanghang/article/details/73466683 
-- Java异常
https://blog.csdn.net/nlznlz/article/details/53271045

-- Java Warning:Build path specifies execution environment J2SE-1.5.
打开项目下拉菜单 --> pom.xml --> Overview --> Properties --> Create... --> Add property (Name: "maven.compiler.target" Value: "1.8") --> Create... --> Add property (Name: "maven.compiler.source" Value: "1.8") --> 'Ctrl+S'键保存 
右键项目 --> Maven --> Update Project...
备注:"1.8"为Java JDK 版本 ,可通过 Window --> Preferences --> Java --> Compiler --> Compiler Compliance Settings 查看.

-- 2018年8月3日
在对spring实例化操作时，ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")，
会报警告 Resource leak: 'context' is never closed；对这种警告的处理方法总结如下：


1.改变context 的作用域，提前初始化
public class Test 
{
    private static ApplicationContext context;
    public static void main(String[] args)
	{
        context = new ClassPathXmlApplicationContext("Beans.xml"); 
    }
}
2.强制转换类型，使用close方法
((ConfigurableApplicationContext)ctx).close();

3.初始化时，使用带有close方法的子类
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  

-- 主题设置为 solarised dark
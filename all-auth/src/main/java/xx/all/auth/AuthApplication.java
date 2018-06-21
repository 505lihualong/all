package xx.all.auth;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/** 
 * @ClassName: Application 
 * @Description: 启动入口类 
 * @author Dragon Li 
 * @date 2018年5月22日 上午9:38:44 
 *  
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {
	private static final Logger logger = LoggerFactory.getLogger(AuthApplication.class);
	/**
	 * @Title: main
	 * @Description: 启动入口类main方法
	 * @author Dragon Li 
	 * @date 2018年5月20日 下午3:12:57 
	 * @param args    参数
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		logger.debug("Start running all-auth.");
    	SpringApplication.run(AuthApplication.class, args);
    }
}

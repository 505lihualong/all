package xx.all.upms;

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
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	/**
	 * @Title: main
	 * @Description: 启动入口类main方法
	 * @author Dragon Li 
	 * @date 2018年5月20日 下午3:12:57 
	 * @param @param args    参数
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		logger.debug("Start running all-gateway.");
    	SpringApplication.run(Application.class, args);
    }
}

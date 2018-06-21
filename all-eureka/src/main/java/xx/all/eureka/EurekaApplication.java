package xx.all.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	private static final Logger logger = LoggerFactory.getLogger(EurekaApplication.class);
	public static void main(String[] args) {
		logger.debug("Start running all-eureka.");
    	SpringApplication.run(EurekaApplication.class, args);
    }
}

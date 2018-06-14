package xx.common.web.utils;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	private static MessageSource messageSource = null;

	// 非@import显式注入，@Component是必须的，且该类必须与main同包或子包
	// 若非同包或子包，则需手动import 注入，有没有@Component都一样
	// 可复制到Test同包测试
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
	}

	// 获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 获取Environment
	public static Environment getEnvironment() {
		return applicationContext.getEnvironment();
	}

	// 获取配置信息
	public static <T> T getProperty(String key, Class<T> targetType) {
		return applicationContext.getEnvironment().getProperty(key, targetType);
	}

	// 获取配置信息
	public static String getProperty(String key) {
		return applicationContext.getEnvironment().getProperty(key);
	}

	// 通过name获取 Bean.
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);

	}

	// 通过class获取Bean.
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	// 通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	public static String getI18nMessage(String code, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		return getMessageSource().getMessage(code, args, locale);
	}

	public static MessageSource getMessageSource() {
		if (SpringUtil.messageSource == null) {
			SpringUtil.messageSource = SpringUtil.getBean(MessageSource.class);
		}
		return messageSource;
	}
	
	/*public static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication;
        }
        throw  new AuthenticationServiceException("authentication not found");
    }*/

}


package xx.all.common.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xx.all.common.security.core.social.qq.api.QQImpl;

/**
 * 默认的短信验证码发送器
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
	private static final Logger logger = LoggerFactory.getLogger(DefaultSmsCodeSender.class);
	/**
	 * Send.
	 *
	 * @param mobile the mobile
	 * @param code   the code
	 * @param ip     the ip
	 */
	@Override
	public void send(String mobile, String code, String ip) {
		logger.warn("请配置真实的短信验证码发送器(SmsCodeSender)");
		logger.info("向手机" + mobile + "发送短信验证码" + code + "ip:" + ip);
	}

}

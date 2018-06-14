package xx.all.common.security.core.properties;


/**
 * 浏览器环境配置项
 *
 */
public class BrowserProperties {

	/**
	 * session管理配置项
	 */
	private SessionProperties session = new SessionProperties();
	/**
	 * '记住我'功能的有效时间，默认1小时
	 */
	private int rememberMeSeconds = 3600;
	/**
	 * 社交登录，如果需要用户注册，跳转的页面
	 */
	private String signUpUrl = "/pc-signUp.html";
	/**
	 * 登录响应的方式，默认是json
	 */
	private LoginResponseType signInResponseType = LoginResponseType.JSON;
	/**
	 * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
	 * 只在signInResponseType为REDIRECT时生效
	 */
	private String singInSuccessUrl;
	public SessionProperties getSession() {
		return session;
	}
	public void setSession(SessionProperties session) {
		this.session = session;
	}
	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}
	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	public String getSignUpUrl() {
		return signUpUrl;
	}
	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}
	public LoginResponseType getSignInResponseType() {
		return signInResponseType;
	}
	public void setSignInResponseType(LoginResponseType signInResponseType) {
		this.signInResponseType = signInResponseType;
	}
	public String getSingInSuccessUrl() {
		return singInSuccessUrl;
	}
	public void setSingInSuccessUrl(String singInSuccessUrl) {
		this.singInSuccessUrl = singInSuccessUrl;
	}
	
}

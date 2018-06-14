package xx.common.web.config;

public enum ResultEnum {
	
	/**成功 */
	SUCCESS("1000", "sys.success"),
	/**已经存在**/
	EXIST("1001", "sys.exist"),
	/**失败*/
	FAILED("1002", "sys.failed"),
	/**未知错误 */
	UNKNOW_ERROR("1003", "sys.unknow.error"),
	/**错误 */
	ERROR("1004", "sys.error"),
	/** 不支持当前请求方法 */
	REQUEST_METHOD_NOT_SUPPORT("1005", "sys.request.method.not.support"),
	/**缺少请求参数 */
	MISS_REQUEST_PARAM("1006", "sys.miss.request.param"),
	/**文件不存在 **/
	FILE_NOT_EXIT("1007", "sys.file.not.exit"),
	/**帐号错误**/
	ACCOUT_ERROR("1008", "sys.accout.error"),
	/**密码错误 **/
	PASSWORD_ERROR("1009","sys.password.error");

	private String code;
	private String message;

	private ResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

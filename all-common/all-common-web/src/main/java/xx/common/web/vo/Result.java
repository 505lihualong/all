package xx.common.web.vo;

import java.io.Serializable;

/**
 * 
 * @ClassName: Result 
 * @Description: 统一返回数据结构
 * @author Dragon Li 
 * @date 2018年5月25日 上午10:22:47 
 *
 */
public class Result implements Serializable {
	private static final long serialVersionUID = -3407675930100707209L;
	/**
	 * 返回码
	 */
	private String code;
	/**
	 * 返回信息描述
	 */
	private String message;

	/**
	 * 返回数据
	 */
	private Object data;

	public Result() {
	}

	public Result(Object data) {
		this.data = data;
	}

	public Result(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Result(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}

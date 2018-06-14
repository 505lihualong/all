package xx.common.web.exception;

import xx.common.web.config.ResultEnum;

/**
 *基础异常类
 * @author dragon
 *
 */
public class BaseException extends RuntimeException{
	private static final long serialVersionUID = 7404303774145471055L;
	ResultEnum resultEnum;

	public BaseException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.resultEnum=resultEnum;
	}

	public ResultEnum getResultEnum() {
		return resultEnum;
	}

	public void setResultEnum(ResultEnum resultEnum) {
		this.resultEnum = resultEnum;
	}
	

}

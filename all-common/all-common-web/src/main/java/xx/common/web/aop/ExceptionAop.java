package xx.common.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import xx.common.web.config.ResultEnum;
import xx.common.web.exception.BaseException;
import xx.common.web.utils.ResultUtil;
import xx.common.web.vo.Result;


/**
 * 统一异常处理
 * @author Dragon
 *
 */
@ControllerAdvice
public class ExceptionAop {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAop.class);

	@ExceptionHandler(value = BaseException.class)
	@ResponseBody
	public Result baseExceptionHandle(BaseException e) {
		logger.error("自定义异常：{}", e.getMessage());
		return ResultUtil.getInstance(e.getResultEnum());
	}

	/**
	 * 400 - Bad Request
	 */
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	public Result handleValidationException(ValidationException e) {
		logger.error("参数验证失败", e);
		return ResultUtil.getInstance(ResultEnum.UNKNOW_ERROR);
	}

	/**
	 * 400 - Bad Request
	 */
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		logger.error("缺少请求参数", e);
		return ResultUtil.getInstance(ResultEnum.MISS_REQUEST_PARAM);
	}

	/**
	 * 400 - Bad Request
	 */
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Result handleBindException(BindException e) {
		logger.error("参数绑定失败");
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		String defaultMessage = error.getDefaultMessage();
		return ResultUtil.getInstance(defaultMessage, null);
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法:{}",e);
		return ResultUtil.getInstance(ResultEnum.REQUEST_METHOD_NOT_SUPPORT);
	}

	
	
	@ExceptionHandler(value=ConstraintViolationException.class)  
	@ResponseBody
	public Result  handleMethodArgumentNotValid( ConstraintViolationException exception){
		// 按需重新封装需要返回的错误信息
		List<String> list = new ArrayList<>();
		Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : violations) {
			list.add(constraintViolation.getMessage());
			logger.info("请求参数错误 :{}", constraintViolation.getMessage());
		}
		logger.info("请求参数错误：{}", list);
		return ResultUtil.failed(list);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result HandleException(Exception e) {
		logger.error("系统异常:{}", e);
		return ResultUtil.getInstance(ResultEnum.UNKNOW_ERROR);
	}
}

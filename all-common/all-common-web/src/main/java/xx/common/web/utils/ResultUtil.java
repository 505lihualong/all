package xx.common.web.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import xx.common.web.config.ResultEnum;
import xx.common.web.vo.Result;


/**
 * 返回结果工具类
 * @author Administrator
 *
 */
public class ResultUtil {

	/**
	 * 获取成功结果
	 */
	public static Result success() {
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		Locale locale = LocaleContextHolder.getLocale();
		result.setMessage(SpringUtil.getBean(MessageSource.class).getMessage( ResultEnum.SUCCESS.getMessage(),null,locale) );
		return result;
	}
	
	public static   Result success(Object data) {
		Result result = ResultUtil.success();
		result.setData(data);
		return result;
	}
	
	public static Result failed() {
		Result result = new Result();
		result.setCode(ResultEnum.FAILED.getCode());
		result.setMessage(SpringUtil.getI18nMessage(ResultEnum.FAILED.getMessage(), null) );
		return result;
	}
	
	public static Result failed(Object data) {
		Result result = new Result();
		result.setCode(ResultEnum.FAILED.getCode());
		result.setData(data);
		return result;
	}
	
	public static Result error() {
		Result result = new Result();
		result.setCode(ResultEnum.ERROR.getCode());
		result.setMessage(SpringUtil.getI18nMessage(ResultEnum.ERROR.getMessage(), null) );
		return result;
	} 

	
	public static Result getInstance(ResultEnum resultEnum) {
		Result result = new Result();
		result.setCode(resultEnum.getCode());
		result.setMessage(SpringUtil.getI18nMessage(resultEnum.getMessage(), null));
		return result;
	}
	
	public static Result getInstance(ResultEnum resultEnum, Object[] args) {
		Result result = new Result();
		result.setCode(resultEnum.getCode());
		result.setMessage(SpringUtil.getI18nMessage(resultEnum.getMessage(), args));
		return result;
	}
	
	public static Result getInstance(String code, Object[] args) {
		Result result = new Result();
		result.setCode(ResultEnum.ERROR.getCode());
		result.setMessage(SpringUtil.getI18nMessage(code.replaceAll("\\{|\\}", ""), args));
		return result;
	}
	

}

package xx.all.common.feign;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import feign.Response;
import feign.codec.ErrorDecoder;


/**
 * The class Feign error interceptor.
 *
 * @author paascloud.net @gmail.com
 */
public class Oauth2FeignErrorInterceptor implements ErrorDecoder {
	private static final Logger logger = LoggerFactory.getLogger(Oauth2FeignErrorInterceptor.class);
	private final ErrorDecoder defaultErrorDecoder = new Default();

	/**
	 * Decode exception.
	 *
	 * @param methodKey the method key
	 * @param response  the response
	 *
	 * @return the exception
	 */
	@Override
	public Exception decode(final String methodKey, final Response response) {
	/*	if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return new HystrixBadRequestException("request exception wrapper");
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap map = mapper.readValue(response.body().asInputStream(), HashMap.class);
			Integer code = (Integer) map.get("code");
			String message = (String) map.get("message");
			if (code != null) {
				ErrorCodeEnum anEnum = ErrorCodeEnum.getEnum(code);
				if (anEnum != null) {
					if (anEnum == ErrorCodeEnum.GL99990100) {
						throw new IllegalArgumentException(message);
					} else {
						throw new BusinessException(anEnum);
					}
				} else {
					throw new BusinessException(ErrorCodeEnum.GL99990500, message);
				}
			}
		} catch (IOException e) {
			logger.info("Failed to process response body");
		}
		return defaultErrorDecoder.decode(methodKey, response);*/
		return null;
	}
}

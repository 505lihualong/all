package xx.all.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import xx.all.auth.model.SysUserDetails;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @ClassName: TokenConfig 
 * @Description: token配置 
 * @author Dragon Li 
 * @date 2018年6月7日 上午9:48:47 
 *
 */
@Configuration
public class TokenConfig {
	/**
     * jdbc数据源
     */
	@Resource
	private DataSource dataSource;
	

	/**
	 * 使用jdbc存储token的配置
	 * 只有在security.oauth2.token.store.type配置为jdbc时生效
	 */
	@Bean
	@ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "jdbc", matchIfMissing = false)
	public JdbcTokenStore jdbcTokenStore() {
		return new JdbcTokenStore(dataSource);

	}
	
	/**
	 * @ClassName: RedisTokenConfig 
	 * @Description: redis配置 
	 * @author Dragon Li 
	 * @date 2018年6月8日 上午9:42:18 
	 *
	 */
	@Configuration
	@ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
	public static class RedisTokenConfig {
		/**
	     * redis连接工厂
	     */
		@Autowired
		private RedisConnectionFactory redisConnectionFactory;
		
		/**
		 * 使用redis存储token的配置
		 * 默认生效
		 */
		@Bean
		public RedisTokenStore redisTokenStore() {
			return new RedisTokenStore(redisConnectionFactory);
		}
		
	}
	
	

    /**
     * jwt的配置,
     * 只有在security.oauth2.token.store.type配置为jwt时生效
     */
	@Configuration
	@ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "jwt", matchIfMissing = false)
	public static class JWTTokenConfig {
		@Bean
		public JwtTokenStore jwtTokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter());
		}
		

		/**
		 * 
		 * @Title: jwtAccessTokenConverter
		 * @Description: 对称加密方式
		 * @author Dragon Li 
		 * @date 2018年5月25日 下午3:50:10 
		 * @return JwtAccessTokenConverter    返回类型
		 * @throws
		 */
		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
			accessTokenConverter.setSigningKey("test");
			return accessTokenConverter;
		}

	
		
		/**
		 * @Title: jwtTokenEnhancer
		 * @Description: 实例化JwtToken增强器
		 * @author Dragon Li 
		 * @date 2018年6月8日 上午9:30:55
		 * @return TokenEnhancer    返回类型
		 * @throws
		 */
		@Bean
		@ConditionalOnBean(TokenEnhancer.class)
		public TokenEnhancer jwtTokenEnhancer() {
			return new JwtTokenEnhancer();
		}
		/**
		 * 
		 * @ClassName: JwtTokenEnhancer 
		 * @Description: JwtToken增强器，jwt 生成token定制化处理
		 * @author Dragon Li 
		 * @date 2018年6月8日 上午9:30:08 
		 *
		 */
		public class JwtTokenEnhancer implements TokenEnhancer {
			@Override
			public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
				if (accessToken instanceof DefaultOAuth2AccessToken) {
					DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
					Map<String, Object> addInfor = new LinkedHashMap<>();
					SysUserDetails user = (SysUserDetails) authentication.getPrincipal();
					addInfor.put("id", user.getId());
					addInfor.put("status", user.getStatus());
					token.setAdditionalInformation(addInfor);
				}
				return accessToken;
			}

		}
	}
	
	
	
	
}
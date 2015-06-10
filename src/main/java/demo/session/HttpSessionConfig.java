package demo.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 会话信息保存到redis定义，头信息保存
 * 
 * @author jiekechoo
 *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class HttpSessionConfig {

	/**
	 * 定义Jedis连接工厂
	 * 
	 * @return factory
	 */
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		return factory;
	}

	// 暂时取消 x-auth-token，以默认cookie代替
	// /**
	// * HttpSessionStrategy
	// *
	// * @return
	// */
	// @Bean
	// public HttpSessionStrategy httpSessionStrategy() {
	// return new HeaderHttpSessionStrategy();
	// }

}

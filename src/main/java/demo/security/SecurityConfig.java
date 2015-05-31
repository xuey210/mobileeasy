package demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置文件，主要是重写默认的认证方式和访问目录权限
 * 
 * @author jiekechoo
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	/**
	 * 使用jdbc认证方式，密码采用BCrypt加密，salt 10
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(new BCryptPasswordEncoder(10));
	}

	/**
	 * 除了/create目录API，其他都需要认证才能访问
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.httpBasic()
		.and().authorizeRequests()
		.antMatchers("/api/create").permitAll() // 用户注册不需要登录
		.antMatchers("/api/i/**").hasRole("USER") // url中含有/i/的需要登录
		.and().csrf().disable();
	}

}

package demo.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import demo.security.SecurityConfig;

public class Initializer extends AbstractHttpSessionApplicationInitializer {

	public Initializer() {
		super(HttpSessionConfig.class, SecurityConfig.class);
	}
}
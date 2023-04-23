package com.devsuperior.movieflix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.List;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private final JwtTokenStore tokenStore;
    private final Environment environment;

    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    public ResourceServerConfig(JwtTokenStore tokenStore, Environment environment) {
        this.tokenStore = tokenStore;
        this.environment = environment;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(List.of(environment.getActiveProfiles()).contains("test"))
            http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .anyRequest().authenticated();
    }
}

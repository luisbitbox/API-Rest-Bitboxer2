/*
package luis.ejercicio.bitboxer2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults())
                .authorizeRequests()
                .antMatchers("/erp/api/**").permitAll()
                .antMatchers("/erp/api/private/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Luis").password("{noop}"+"user").roles("USER")
                .and()
                .withUser("Pedro").password("{noop}"+"admin").roles("ADMIN");
    }
}
*/

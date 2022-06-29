package ru.gb.thymeleafapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((request) -> {
            request.antMatchers("/").permitAll();
//            request.antMatchers("/auth/addNewUser").permitAll();
//            request.antMatchers("/").permitAll();//позволяет ходить всем на страницу без авторизации
//            request.antMatchers(HttpMethod.POST, "/product").hasAuthority("product.create");
//            request.antMatchers(HttpMethod.GET, "/product").hasAuthority("product.create");
////            request.antMatchers(HttpMethod.GET, "/product/authorizePage").permitAll();
//            request.mvcMatchers(HttpMethod.GET,"/product/{productId}").permitAll();
        });
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("$2a$10$tNa23wovRhfkjQ.crdUnoe5uNHL7obaZmi2zp9D.5yXPVLbOspEje")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("$2a$10$QUQkxSU5mjJHJVCPz4pvselpcAm/42KGLGgz/v2kB2nTXWiqaOibK")
//                .roles("ADMIN");
//        http.formLogin().loginPage("/login").defaultSuccessUrl("/product/all", true);
//        http.exceptionHandling().accessDeniedPage("/errors/access-denied");
//        http.authorizeRequests((request) -> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)request.anyRequest()).authenticated();
//        });
//        http.exceptionHandling().accessDeniedPage("/access-denied");
        http.httpBasic().disable();
        http.csrf().disable();
//        http.formLogin();
//        http.httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService(){
//        UserDetails user =  User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//        UserDetails admin =  User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//           return new InMemoryUserDetailsManager(user, admin);
//    }

}

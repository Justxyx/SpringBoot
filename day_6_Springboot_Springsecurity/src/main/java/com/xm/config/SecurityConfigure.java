package com.xm.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 首页所有人都可以进行访问
        // 功能页面只有相应有权限的人才能够访问
        // 授权    *****************************************
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");


        // 如果点击到没有权限的页面，那么就自动跳转到登录页面。这个页面为
        // 自动跳转，不需要手动设置
        	/** 					.usernameParameter(&quot;username&quot;)
         * 					.passwordParameter(&quot;password&quot;)
         * 					.loginPage(&quot;/authentication/login&quot;)
         * 					.failureUrl(&quot;/authentication/login?failed&quot;)
         * 					.loginProcessingUrl(&quot;/authentication/login/process&quot;*/
//        源码分析如上  可定制登录页面与跳转页面
        http.formLogin().loginPage("/toLogin");


        /**
         *        logout() 源码分析，
         * 	 * 			.logout((logout) ->
         * 				logout.deleteCookies(&quot;remove&quot;)
         * 					.invalidateHttpSession(false)
         * 					.logoutUrl(&quot;/custom-logout&quot;)
         * 					.logoutSuccessUrl(&quot;/logout-success&quot;)
         */


//        这个为浏览器勾选是否记住我， 如果勾选，网页前端存储一个cookie，半个月免登录
//        http.rememberMe()

        //        logout 注销功能
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        There is no PasswordEncoder mapped for the id "null" 报错



        // 这些数据原本是要通过数据库查询，这里仅作为演示。
        // 认证 ***************************************
        // 根据数据库权限查询 auth.jdbcAuthentication()
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wanghanmi").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("xiaoyingxiong").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3");
    }
}

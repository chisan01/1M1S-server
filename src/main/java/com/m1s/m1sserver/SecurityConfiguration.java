//package com.m1s.m1sserver;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private static final String[] PUBLIC_URI = {
//            "/some-public-apis"
//    };
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // 개발 편의성을 위해 CSRF 프로텍션을 비활성화
//                .csrf()
//                .disable()
//                // HTTP 기본 인증 비활성화
//                .httpBasic()
//                .disable()
//                // 폼 기반 인증 비활성화
//                .formLogin()
//                .disable()
//                // stateless한 세션 정책 설정
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                // 리소스 별 허용 범위 설정
//                .authorizeRequests()
//                .antMatchers(PUBLIC_URI)
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                // 인증 오류 발생 시 처리를 위한 핸들러 추가
//        ;
//    }
//}
//

//package com.m1s.m1sserver.JWT;
//
//import com.m1s.m1sserver.Interface.AuthenticationTokenProvider;
//import com.m1s.m1sserver.api.user.Member;
//import com.m1s.m1sserver.Service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class TokenAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private AuthenticationTokenProvider authenticationTokenProvider;
//
//    @Autowired
//    private MemberService memberService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)
//        throws ServletException, IOException{
//        String token = authenticationTokenProvider.parseTokenString(request);
//        if(authenticationTokenProvider.validateToken(token)){
//            Integer user_id = authenticationTokenProvider.getTokenOwnerNo(token);
//            try{
//                Member member = (Member) memberService.findById(user_id);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member, member.getPassword(), member.getAuthorities());
//
//            }
//        }
//    }
//}

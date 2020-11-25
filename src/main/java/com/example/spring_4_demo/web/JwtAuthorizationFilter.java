package com.example.spring_4_demo.web;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author akimov
 * created at 25.11.2020 21:28
 */
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain) throws IOException, ServletException {

		UsernamePasswordAuthenticationToken authentication = parseToken(request);
		// BasicAuthenticationConverter

		if (authentication != null) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} else {
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken parseToken(HttpServletRequest request) {
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			String token = authorizationHeader.replace("Bearer ", "");
			try {
				JWT parsedJwt = JWTParser.parse(token);

				String username = parsedJwt.getJWTClaimsSet().getSubject();

				if ("".equals(username) || username == null) {
					return null;
				}

				// TODO roles here!

				return new UsernamePasswordAuthenticationToken(username, null, null);
			} catch (ParseException exception) {
				log.warn("Some exception : {} failed : {}", authorizationHeader, exception.getMessage());
			}
		}

		return null;
	}
}
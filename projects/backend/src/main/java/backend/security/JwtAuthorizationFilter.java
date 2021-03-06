package backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
  public JwtAuthorizationFilter(AuthenticationManager authManager) {
    super(authManager);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req,
                                  HttpServletResponse res,
                                  FilterChain chain) throws IOException, ServletException {
    String header = req.getHeader(SecurityConstants.HEADER_STRING);

    if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
      chain.doFilter(req, res);
      return;
    }

    UsernamePasswordAuthenticationToken authentication = getAuthentication(req).get();

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(req, res);
  }

  private Optional<UsernamePasswordAuthenticationToken>
        getAuthentication(HttpServletRequest request) {
    Optional<UsernamePasswordAuthenticationToken>
        usernamePasswordAuthenticationToken = Optional.empty();
    String token = request.getHeader(SecurityConstants.HEADER_STRING);
    if (token != null) {
      // parse the token.
      String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
          .build()
          .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
          .getSubject();

      if (user != null) {
        usernamePasswordAuthenticationToken = Optional
            .of(new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()));
      }
    }
    return usernamePasswordAuthenticationToken;
  }
}

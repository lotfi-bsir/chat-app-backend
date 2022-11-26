package tn.vapex.core.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static tn.vapex.core.constants.SecurityConstants.AUTHORITIES_KEY;
import static tn.vapex.core.constants.SecurityConstants.BEARER_PREFIX;

public class JWTFilter extends OncePerRequestFilter {

    /**
     * - <B>PROBLEM: </B> Since JWTFilter is living outside the spring context , the exceptions it throws will not be handled by Exception Handlers <br/>
     * - <B>FIX: </B> We pass an HandlerExceptionResolver from spring context to be used inside JWTFilter to throw exceptions back to the spring context
     */
    private final HandlerExceptionResolver exceptionResolver;
    private final TokenManager tokenManager;

    public JWTFilter(HandlerExceptionResolver exceptionResolver, TokenManager tokenManager) {
        this.exceptionResolver = exceptionResolver;
        this.tokenManager = tokenManager;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if (!this.tokenExists(authorizationHeader)) {
            try {
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                this.exceptionResolver.resolveException(request, response, null, new AccessDeniedException(Strings.EMPTY));
            }
            return;
        }

        String token = this.tokenManager.extractToken(authorizationHeader);
        try {
            this.tokenManager.validateToken(token, TokenType.ACCESS_TOKEN);
            SecurityContextHolder.getContext().setAuthentication(this.getAuthentication(token));
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            this.exceptionResolver.resolveException(request, response, null, e);
        }
    }

    private boolean tokenExists(String authorizationHeader) {
        return Objects.nonNull(authorizationHeader) && authorizationHeader.startsWith(BEARER_PREFIX);
    }

    private Authentication getAuthentication(String token) {
        Key key = this.tokenManager.getKeyByTokenType(TokenType.ACCESS_TOKEN);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        List<String> authoritiesStrings = (List<String>) claims.get(AUTHORITIES_KEY);
        Collection<? extends GrantedAuthority> authorities = authoritiesStrings.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        User principal = new User(claims.getSubject(), Strings.EMPTY, authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
}

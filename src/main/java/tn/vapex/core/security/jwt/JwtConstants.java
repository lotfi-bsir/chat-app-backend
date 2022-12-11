package tn.vapex.core.security.jwt;

public abstract class JwtConstants {
    private JwtConstants() {
    }

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORITIES_KEY = "authorities";
    public static final String ID_KEY = "id";
    public static final String AUTHORITIES_SEPARATOR = ",";
}

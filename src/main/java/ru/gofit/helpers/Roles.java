package ru.gofit.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * Класс, хранящий имена ролей пользователей
 */
public final class Roles {

    private Roles() {
    }

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_COUCH = "ROLE_COUCH";

    /**
     * Проверить, что пользователь имеет роль Админа
     */
    public static boolean hasAuthenticationRoleAdmin(Authentication authentication) {
        return hasAuthenticationRole(authentication, ROLE_ADMIN);
    }

    /**
     * Проверить, что пользователь имеет роль Пользователь
     */
    public static boolean hasAuthenticationRoleUser(Authentication authentication) {
        return hasAuthenticationRole(authentication, ROLE_USER);
    }

    /**
     * Проверить, что пользователь имеет роль Пользователь
     */
    public static boolean hasAuthenticationRoleCouch(Authentication authentication) {
        return hasAuthenticationRole(authentication, ROLE_COUCH);
    }

    private static boolean hasAuthenticationRole(Authentication authentication, String role) {
        return (authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).anyMatch(a -> a.equals(role)));
    }
}

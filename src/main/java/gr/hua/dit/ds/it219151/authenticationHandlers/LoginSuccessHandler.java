package gr.hua.dit.ds.it219151.authenticationHandlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static gr.hua.dit.ds.it219151.utils.GlobalAttributes.TIMESTAMP_COOKIE_NAME;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final String CITIZEN_HOME_PAGE_URL = "citizen/home";
    private static final String OFFICE_WORKER_HOME_PAGE_URL = "office_worker/home";
    private static final String ARMY_OFFICER_HOME_PAGE_URL = "army_officer/home";


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.addCookie(generateTimestampCookie());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = CITIZEN_HOME_PAGE_URL;
        for (GrantedAuthority grantedAuthority: authorities) {
            if (grantedAuthority.getAuthority().equals("OFFICE_WORKER")) {
                redirectUrl = OFFICE_WORKER_HOME_PAGE_URL;
            }
            else if (grantedAuthority.getAuthority().equals("ARMY_OFFICER")) {
                redirectUrl = ARMY_OFFICER_HOME_PAGE_URL;
            }
        }
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }

    private Cookie generateTimestampCookie() {
        return new Cookie(TIMESTAMP_COOKIE_NAME, String.valueOf(System.currentTimeMillis()));
    }
}

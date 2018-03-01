package com.sefryek.brokerpro.security;

import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.exception.UserNotFoundException;
import com.sefryek.brokerpro.service.session.SessionManager;
import com.sefryek.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private SessionManager sessionManager;

    @Override
//    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        return null;
//        log.debug("Authenticating {}", login);
//        String lowercaseLogin = login.toLowerCase();
//        Optional<User> userFromDatabase =  userRepository.findOneByLogin(lowercaseLogin);
//        return userFromDatabase.map(user -> {
//            if (!user.getActivated()) {
//                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
//            }
//            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
//                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                    .collect(Collectors.toList());
//            return new org.springframework.security.core.userdetails.User(lowercaseLogin,
//                    user.getPassword(),
//                    grantedAuthorities);
//        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }

    //    @Override
//    @Transactional
    public UserDetails loadUserByToken(final String token) {
        log.debug("Authenticating {}", token);
        Session session = sessionManager.getSession(token);
        if (ObjectUtils.isNull(session)) {
            throw new UserNotFoundException("token was not found in the  datagrid");
        }
//        else if (!userFromDatabase.getActivated()) {
//            throw new UserNotActivatedException("User was not activated");
//        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(AuthoritiesConstants.USER);
        grantedAuthorities.add(grantedAuthority);
        return new org.springframework.security.core.userdetails.User(session.getUsername(), "RANDOM_PASSWORD", grantedAuthorities);
    }
}

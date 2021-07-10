package application.service;

import application.DAO.UserDAO;
import application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;


@Service ("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO dao;

    @Autowired
    public UserDetailsServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = dao.getUserByName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь с именем %s не найден", s));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), (Set<GrantedAuthority>) user.getAuthorities());
    }
}

package site.binghai.service;

import org.springframework.stereotype.Service;
import site.binghai.entity.User;

/**
 * Created by IceSea on 2018/5/5.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class UserService extends BaseService<User> {
    public User findByEmailAndPass(String email, String pass) {
        User user = User.builder().build();
        user.setEmail(email);
        user.setPass(pass);
        return queryOne(user);
    }

    public User findByEmail(String email) {
        User user = User.builder().build();
        user.setEmail(email);
        return queryOne(user);
    }
}

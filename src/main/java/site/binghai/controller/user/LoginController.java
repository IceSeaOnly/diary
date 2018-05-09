package site.binghai.controller.user;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.controller.BaseController;
import site.binghai.entity.User;
import site.binghai.service.BaseService;
import site.binghai.service.UserService;
import site.binghai.utils.ExceptionGenerator;

import java.util.Map;

/**
 * Created by IceSea on 2018/5/5.
 * GitHub: https://github.com/IceSeaOnly
 */
@RestController
@RequestMapping("/login/")
public class LoginController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Object userLogin(@RequestParam String email,
                            @RequestParam String pass,
                            @RequestParam String verCode) {

        User user = userService.findByEmailAndPass(email, pass);
        if (user == null) {
            return fail("用户名/密码错误!");
        }

        return success(user, null);
    }

    @PostMapping("userRegister")
    public Object userReg(@RequestParam String email,
                          @RequestParam String pass,
                          @RequestParam String repass,
                          @RequestParam String userName,
                          @RequestParam String verCode
    ) {
        if (!noEmptyString(email, pass, repass, userName, verCode)) {
            return fail("输入不完整");
        }

        if(!pass.equals(repass)){return fail("两次密码校验不一致!");}

        User user = userService.findByEmail(email);
        if(user != null){
            return fail(email+" 已经注册!");
        }

        user = User.builder()
                .email(email)
                .pass(pass)
                .userName(userName)
                .build();

        userService.save(user);
        return success();
    }

    @Override
    protected void beforeAdd(Map map) throws Exception {
        ExceptionGenerator.notImplement();
    }

    @Override
    protected void beforeUpdate(Map map) throws Exception {
        ExceptionGenerator.notImplement();
    }

    @Override
    protected void beforeDelete(Long id) throws Exception {
        ExceptionGenerator.notImplement();
    }

    @Override
    protected void beforList() throws Exception {
//        ExceptionGenerator.notImplement();
    }

    @Override
    protected BaseService getService() {
        return userService;
    }
}

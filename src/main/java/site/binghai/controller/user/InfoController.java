package site.binghai.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.binghai.controller.BaseController;
import site.binghai.entity.User;
import site.binghai.service.BaseService;
import site.binghai.service.UserService;
import site.binghai.utils.ExceptionGenerator;

import java.util.Map;

/**
 * Created by IceSea on 2018/5/17.
 * GitHub: https://github.com/IceSeaOnly
 */
@RequestMapping("/admin/info/")
@RestController
public class InfoController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User> getService() {
        return userService;
    }

    @Override
    protected void beforeUpdate(Map map) throws Exception {
        Long id = getLong(map,"id");
        if(!getUser().getId().equals(id)){
            throw ExceptionGenerator.identifyFailed();
        }
    }

    @GetMapping("info")
    public Object getInfo(){
        User user = getUser();
        user.setPass(null);
        return success(user,null);
    }
}

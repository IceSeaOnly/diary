package site.binghai.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.controller.BaseController;
import site.binghai.service.BaseService;
import site.binghai.service.DiaryService;

/**
 * Created by IceSea on 2018/5/13.
 * GitHub: https://github.com/IceSeaOnly
 */
@RestController
@RequestMapping("/")
public class WorldController extends BaseController {
    @Autowired
    private DiaryService diaryService;

    @GetMapping("worldWild")
    public Object worldWild(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return success(diaryService.findAllByOrderByCreatedDesc(page, pageSize), null);
    }

    @Override
    protected BaseService getService() {
        return null;
    }
}

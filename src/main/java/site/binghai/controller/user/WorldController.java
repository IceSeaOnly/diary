package site.binghai.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.controller.BaseController;
import site.binghai.entity.Diary;
import site.binghai.service.BaseService;
import site.binghai.service.DiaryService;

import java.util.List;

/**
 * Created by IceSea on 2018/5/13.
 * GitHub: https://github.com/IceSeaOnly
 */
@RestController
@RequestMapping("/")
public class WorldController extends BaseController {
    @Autowired
    private DiaryController diaryController;
    @Autowired
    private DiaryService diaryService;

    @GetMapping("worldWild")
    public Object worldWild(@RequestParam Integer page, @RequestParam Integer pageSize) {
        List<Diary> diaryList = diaryService.findAllByOrderByCreatedDesc(page, pageSize);
        if (getUser() != null) {
            diaryList.forEach(diaryController::moreInfo);
        }
        return success(diaryList, null);
    }

    @Override
    protected BaseService getService() {
        return null;
    }
}

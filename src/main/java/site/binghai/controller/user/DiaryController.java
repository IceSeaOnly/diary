package site.binghai.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.controller.BaseController;
import site.binghai.entity.Diary;
import site.binghai.service.BaseService;
import site.binghai.service.DiaryService;

import java.util.Map;

/**
 * Created by IceSea on 2018/5/5.
 * GitHub: https://github.com/IceSeaOnly
 */
@RestController
@RequestMapping("/user/diary/")
public class DiaryController extends BaseController<Diary> {
    @Autowired
    private DiaryService diaryService;

    @Override
    protected BaseService<Diary> getService() {
        return diaryService;
    }

    @Override
    public Object list(Integer page, Integer pageSize) {
        return success(diaryService.findByUser(getUser(), page, pageSize), null);
    }

    @Override
    protected void beforeAdd(Map map) throws Exception {
        map.put("userId", getUser().getId());
    }
}

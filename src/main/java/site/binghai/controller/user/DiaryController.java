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

    @GetMapping("list")
    public Object list(Long cid, Long userId, Integer page, Integer pageSize) {
        if (cid != null) {
            return success(diaryService.findById(cid), null);
        }
        page = page == null ? 0 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        userId = userId == null ? getUser().getId() : userId;
        return success(diaryService.findByUser(userId, page, pageSize), null);
    }

    @Override
    protected void beforeAdd(Map map) throws Exception {
        map.put("userId", getUser().getId());
    }
}

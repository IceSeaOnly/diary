package site.binghai.service;

import org.springframework.stereotype.Service;
import site.binghai.entity.Diary;
import site.binghai.entity.User;

import java.util.List;

/**
 * Created by IceSea on 2018/5/5.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class DiaryService extends BaseService<Diary> {

    public List<Diary> findByUser(User user, Integer page, Integer pageSize) {
        page = page < 1 ? 1 : page;
        pageSize = pageSize > 100 ? 100 : pageSize;
        Diary diary = new Diary();
        diary.setUserId(user.getId());
        List<Diary> ls = pageQuery(diary, page, pageSize);
        return ls;
    }
}

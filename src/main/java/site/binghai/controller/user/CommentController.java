package site.binghai.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.binghai.controller.BaseController;
import site.binghai.entity.Comment;
import site.binghai.service.BaseService;
import site.binghai.service.CommentService;
import site.binghai.utils.ExceptionGenerator;

import java.util.Map;

/**
 * Created by IceSea on 2018/5/17.
 * GitHub: https://github.com/IceSeaOnly
 */
@RestController
@RequestMapping("/user/comment/")
public class CommentController extends BaseController<Comment> {
    @Autowired
    private CommentService commentService;

    @Override
    protected BaseService<Comment> getService() {
        return commentService;
    }

    @GetMapping("list")
    public Object list(@RequestParam Long cid) {
        return success(commentService.findByCid(cid),null);
    }

    @Override
    protected void beforeUpdate(Map map) throws Exception {
        throw ExceptionGenerator.notImplement();
    }

    @Override
    protected void beforeDelete(Long id) throws Exception {
        Comment comment = commentService.findById(id);
        if (!getUser().getId().equals(comment.getUid())) {
            throw ExceptionGenerator.identifyFailed();
        }
    }
}

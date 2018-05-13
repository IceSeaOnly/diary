package site.binghai.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IceSea on 2018/5/13.
 * GitHub: https://github.com/IceSeaOnly
 * 点赞记录
 */
@Data
@Entity
public class PraiseRecord extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long diaryId;
}

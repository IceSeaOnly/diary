package site.binghai.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IceSea on 2018/5/17.
 * GitHub: https://github.com/IceSeaOnly
 */
@Entity
@Data
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long uid;
    private Long cid;
    private Long toId;
    private String uName;
    private String toName;

    @Column(columnDefinition = "TEXT")
    private String content;
}

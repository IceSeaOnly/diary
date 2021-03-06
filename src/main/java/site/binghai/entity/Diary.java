package site.binghai.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by IceSea on 2018/5/5.
 * GitHub: https://github.com/IceSeaOnly
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(name = "class")
    @JSONField(name = "class")
    private Long clazz;
    private Integer praiseMark;

    @Transient
    private boolean praise; // 点赞标记
}

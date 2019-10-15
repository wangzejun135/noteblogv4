package me.wuwenbin.noteblogv4.model.entity;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.wuwenbin.noteblogv4.model.entity.permission.NBSysUser;

/**
 * created by Wuwenbin on 2018/7/15 at 11:52
 *
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "nb_comment")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBComment implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;

    @Column(length = 11, nullable = false)
    private Long userId;

    @Column(length = 11, nullable = false)
    private Long articleId;

    @Column(columnDefinition = "text")
    private String clearComment;

    @Column(columnDefinition = "text")
    private String comment;

    @Builder.Default
    private LocalDateTime post = now();

    @Column(length = 50)
    private String ipAddr;

    @Column(length = 100)
    private String ipCnAddr;

    private String userAgent;

    @Column(nullable = false, length = 1, columnDefinition = "tinyint(1)")
    @Builder.Default
    private Boolean enable = TRUE;

    @ManyToOne
    @JoinColumn(name = "user_refer_id")
    private NBSysUser user;
}

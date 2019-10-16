package me.wuwenbin.noteblogv4.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Wuwenbin on 2018/7/15 at 12:03
 *
 * @author wuwenbin
 */
@Data
@Entity
@Table(name = "nb_param")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBParam implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 600)
    private String value;

    private String remark;

    /**
     * 默认显示级别，数字越小，显示级别越高，公开性越低
     */
    @Column(columnDefinition = "int default 0")
    private Integer level;

    @Column(columnDefinition = "int default 0")
    @Builder.Default
    private Integer orderIndex = 0;

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        //noinspection unchecked
        return (T) this.value;
    }


}

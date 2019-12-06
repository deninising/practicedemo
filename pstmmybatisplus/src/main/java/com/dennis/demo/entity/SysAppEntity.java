package com.dennis.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 平台表
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_app")
public class SysAppEntity implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 是否启用
     */
    @TableField("isEnable")
    private Integer isEnable;

    /**
     * 编码
     */
    private String code;


}

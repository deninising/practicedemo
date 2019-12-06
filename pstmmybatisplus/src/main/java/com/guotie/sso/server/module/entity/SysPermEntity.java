package com.guotie.sso.server.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_perm")
public class SysPermEntity implements Serializable {


    /**
     * 主键id

     */
    @TableId(value = "perm_id", type = IdType.AUTO)
    private Long permId;

    /**
     * 权限类型：1：私有权限 2：共有权限
     */
    private Integer type;

    /**
     * 平台名称
     */
    private String platform;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段值
     */
    private String fieldValue;

    /**
     * 条件判断符（1：等于 2：大于等于 3：小于）
     */
    private String operator;

    /**
     * 权限名称
     */
    private String permName;


}

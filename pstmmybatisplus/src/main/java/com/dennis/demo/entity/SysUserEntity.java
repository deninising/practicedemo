package com.dennis.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserEntity implements Serializable {


    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 别名
     */
    private String alias;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 钉钉
     */
    private String dingding;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否admin（用来做数据权限）
     */
    private Boolean isAdmin;

    private String token;


}

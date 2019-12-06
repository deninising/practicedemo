package com.dennis.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_perm")
public class SysRolePermEntity implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private String dataPermId;


}

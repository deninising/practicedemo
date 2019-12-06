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
@TableName("sys_data_perm")
public class SysDataPermEntity implements Serializable {


    /**
     * 主键id

     */
    private String dataPermId;

    /**
     * 权限类型: 1=私有权限 2=共有权限
     */
    private String dataPermTypeDict;

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
    private String columnName;

    /**
     * 字段值类型:1=基本数据类型  2=字符串类型  3=日期类型
     */
    private String columnTypeDict;

    /**
     * 字段值
     */
    private String columnValue;

    /**
     * 条件判断符 (1:‘=’，2:‘>=’， 3:'<')
     */
    private String operatorDict;

    /**
     * 权限名称
     */
    private String dataPermName;


}

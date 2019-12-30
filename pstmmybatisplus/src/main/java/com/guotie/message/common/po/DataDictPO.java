package com.guotie.message.common.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_center_data_dict")
public class DataDictPO implements Serializable {


    /**
     * 数据库id
     */
    private String id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 字典类型
     */
    private String type;

    /**
     * 字典码
     */
    private String code;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标记  -1：已删除  0：正常
     */
    private Integer delFlag;


}

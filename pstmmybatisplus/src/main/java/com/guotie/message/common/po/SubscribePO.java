package com.guotie.message.common.po;

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
 * @since 2019-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_center_subscribe")
public class SubscribePO implements Serializable {


    /**
     * 数据库id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 产品code
     */
    private String categoryCode;

    /**
     * 产品实例id
     */
    private Integer systemId;

    /**
     * 域
     */
    private Integer domain;

    /**
     * 消息类型，字典code
     */
    private Integer msgTypeDict;

    /**
     * 删除标记 -1：已删除 0： 可用
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remark;


}

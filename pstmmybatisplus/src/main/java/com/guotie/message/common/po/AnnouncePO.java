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
@TableName("msg_center_announce")
public class AnnouncePO implements Serializable {


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
     * 产品实例id 1 深圳地铁 2 南京地铁
     */
    private Integer systemId;

    /**
     * 0：平台内部推送 1： 钉钉推送 2： 邮件推送
     */
    private Integer announceType;

    /**
     * 消息通知时间点，corn表达式，为空时则实时推送消息
     */
    private String announceTime;

    /**
     * 删除标记 -1：已删除 0：可用
     */
    private Integer delFlag;


}

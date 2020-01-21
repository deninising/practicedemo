package com.guotie.message.common.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_center_subscribe")
public class SubscribePO implements Serializable {


    /**
     * 主键（uuid）
     */
    private String id;

    /**
     * 消息类型id
     */
    private String messageTypeId;

    /**
     * 通知类型id
     */
    private String announceTypeId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标记 1 已删除  ,  0 可用
     */
    private Boolean delFlag;

    /**
     * 扩展预留字段
     */
    private String extend;


}

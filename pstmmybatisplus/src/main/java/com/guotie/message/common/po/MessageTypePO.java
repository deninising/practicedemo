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
 * @since 2020-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_center_message_type")
public class MessageTypePO implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 产品code
     */
    private String categoryCode;

    /**
     * 产品实例id
     */
    private Integer systemId;

    /**
     * 域（例如专业）
     */
    private Integer domain;

    /**
     * 消息类型字典code
     */
    private String msgTypeDict;

    /**
     * 固定推送方式（不为空时：该消息类型不支持用户自定义推送方式）
     */
    private String fixedAnnounceTypeDict;

    /**
     * 删除标记：-1 已删除  0 正常
     */
    private Integer delFlag;

    /**
     * 可选标记：0 用户可选，-1 用户不可选（用户必须订阅）
     */
    private Integer optionalFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}

package com.gt.eggchat.pojo;

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
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("chat_msg")
public class ChatMsgPO implements Serializable {


    /**
     * 主键id
     */
    private String id;

    private String sendUserId;

    private String acceptUserId;

    private String msg;

    /**
     * 接收状态标记
     */
    private Integer signFlag;

    private LocalDateTime createTime;


}

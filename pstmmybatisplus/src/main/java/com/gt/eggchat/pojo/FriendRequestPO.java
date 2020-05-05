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
@TableName("friend_request")
public class FriendRequestPO implements Serializable {


    /**
     * id主键
     */
    private String id;

    /**
     * 发送方的id
     */
    private String sendUserId;

    /**
     * 接收方的id
     */
    private String acceptUserId;

    /**
     * 请求时间
     */
    private LocalDateTime requestDateTime;


}

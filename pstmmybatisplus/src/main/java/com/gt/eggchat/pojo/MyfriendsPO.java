package com.gt.eggchat.pojo;

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
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("myfriends")
public class MyfriendsPO implements Serializable {


    /**
     * 主键id
     */
    private String id;

    /**
     * 我的主键
     */
    private String myUserId;

    /**
     * 朋友的主键
     */
    private String myFriendUserId;


}

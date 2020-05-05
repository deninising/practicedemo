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
@TableName("users")
public class UsersPO implements Serializable {


    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 小头像
     */
    private String faceImage;

    /**
     * 大头像
     */
    private String faceImageBig;

    /**
     * 用户可自定义更改的昵称
     */
    private String nikename;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * client_id每一台设备唯一
     */
    private String cid;


}

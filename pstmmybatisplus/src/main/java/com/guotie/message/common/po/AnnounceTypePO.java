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
 * @since 2020-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("msg_center_announce_type")
public class AnnounceTypePO implements Serializable {


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
     * 通知类型字典code
     */
    private String announceTypeDict;

    /**
     * 删除标记：-1 已删除  0 正常
     */
    private Integer delFlag;


}

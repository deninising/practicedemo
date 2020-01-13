package com.dennis.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dennis.demo.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-06
 */
public interface SysUserService extends IService<SysUserEntity> {

    IPage<SysUserEntity> pageList(SysUserEntity userEntity);
}

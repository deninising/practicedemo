package com.dennis.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dennis.demo.entity.SysUserEntity;
import com.dennis.demo.dao.SysUserDao;
import com.dennis.demo.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author Liaopeng
 * @since 2019-12-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public IPage<SysUserEntity> pageList(SysUserEntity userEntity) {
        Page<SysUserEntity> entityPage = new Page<>(1, 10);
        QueryWrapper<SysUserEntity> sysUserEntityQueryWrapper = new QueryWrapper<>();
        sysUserEntityQueryWrapper.eq("dept_id", userEntity.getDeptId());
        IPage<SysUserEntity> sysUserEntityIPage = this.baseMapper.selectPage(entityPage, sysUserEntityQueryWrapper);
        return sysUserEntityIPage;
    }
}

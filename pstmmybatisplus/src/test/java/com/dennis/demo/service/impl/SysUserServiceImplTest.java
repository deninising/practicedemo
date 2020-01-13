package com.dennis.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dennis.demo.entity.SysUserEntity;
import com.dennis.demo.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;


    @Test
    public void testListPage() {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setDeptId(65L);
        IPage<SysUserEntity> sysUserEntityIPage = sysUserService.pageList(sysUserEntity);
        long pages = sysUserEntityIPage.getPages();
        System.out.println(pages);
        sysUserEntityIPage.getRecords().forEach(userEntity -> {
            System.out.println(userEntity);
        });
    }
}
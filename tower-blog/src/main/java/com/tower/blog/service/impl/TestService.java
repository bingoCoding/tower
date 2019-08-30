package com.tower.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tower.blog.entity.Test;
import com.tower.blog.mapper.TestMapper;
import com.tower.blog.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> findList(Page page, String name) {
        return testMapper.findList(page,name);
    }
}

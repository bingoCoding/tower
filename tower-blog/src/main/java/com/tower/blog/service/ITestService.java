package com.tower.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tower.blog.entity.Test;

import java.util.List;

public interface ITestService extends IService<Test> {

    List<Test> findList(Page page, String name);
}

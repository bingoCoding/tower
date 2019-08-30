package com.tower.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tower.blog.base.BaseResponse;
import com.tower.blog.entity.Test;
import com.tower.blog.enums.ReturnCode;
import com.tower.blog.exception.BaseException;
import com.tower.blog.service.ITestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private ITestService testService;

    @RequestMapping("list")
    public List<Test> findList(){
        return testService.list();
    }

    @RequestMapping("save")
    public BaseResponse save(){
        Test test = new Test();
        test.setName("aaa");
        test.setAge(27);
        testService.saveOrUpdate(test);
        return new BaseResponse().success("ok");
    }

    @RequestMapping("update")
    public BaseResponse update(){
        Test test = new Test();
        test.setId(2L);
        test.setAge(29);
        testService.saveOrUpdate(test);
        return new BaseResponse().success("ok");
    }

    @RequestMapping("del")
    public String del(){
        testService.removeById(1L);
        return "ok";
    }

    @RequestMapping("page")
    public BaseResponse page(){
        Page<Test> page = new Page<>(1,5,false);
        IPage<Test> page1 = testService.page(page);
        return new BaseResponse().success().data(page1);
    }

    @RequestMapping("pageMap")
    public BaseResponse pageMap(){
        Page page = new Page(1,5);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","name");
        queryWrapper.like("name","a");

        IPage<Map<String,Object>> page1 = testService.pageMaps(page,queryWrapper);
        return new BaseResponse().success().data(page1);
    }

    /**
     * 自定义方法中的分页用法
     * @return
     */
    @RequestMapping("pageMapList")
    public BaseResponse pageMapByList(){
        Page page = new Page(1,5);
        int a = 4/0;
        try {
            if (page!=null){
                throw new Exception();
            }
            List<Test> list = testService.findList(page,"a");
            page.setRecords(list);
        }catch (Exception e){
            throw new BaseException(ReturnCode.FAIL);
        }
        return new BaseResponse().success().data(page);
    }
}

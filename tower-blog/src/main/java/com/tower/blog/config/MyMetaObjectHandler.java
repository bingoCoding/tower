package com.tower.blog.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println(metaObject.toString());
        this.setInsertFieldValByName("createUser","admin",metaObject);
        this.setInsertFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println(metaObject.toString());
        this.setUpdateFieldValByName("updateUser","admin",metaObject);
        this.setUpdateFieldValByName("updateTime",new Date(),metaObject);
    }
}

package com.mar.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.UUID;

/**
 * @author CC
 * 自动填充创建更新时间
 */
public class AutoCommonFieldsHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);
        Object fileDependId = getFieldValByName("fileDependId", metaObject);

        if (createTime == null) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
        if (fileDependId == null) {
            setFieldValByName("fileDependId", UUID.randomUUID().toString(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}
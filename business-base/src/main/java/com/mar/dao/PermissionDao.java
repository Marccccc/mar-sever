package com.mar.dao;

import com.mar.entity.Permission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PermissionDao {
    List<Permission> listPermissionByUser(@Param("userId")Integer userId);
}

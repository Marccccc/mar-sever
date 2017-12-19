package com.mar.service.impl;

import com.mar.dao.PermissionDao;
import com.mar.entity.Permission;
import com.mar.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permisssionDao;

    @Override
    public void linkRolePermissions(Integer roleId, List<Permission> permissions) {

    }

    @Override
    public List<Permission> getPermissionsByRole(String roleId) {
        return null;
    }

    @Override
    @Cacheable(value = "Permission", key = "'permissionsBelong'+#userId")
    public List<Permission> getPermissionsByUser(Integer userId) {
        return permisssionDao.listPermissionByUser(userId);
    }

}

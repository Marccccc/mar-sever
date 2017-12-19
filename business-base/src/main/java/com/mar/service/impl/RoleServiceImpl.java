package com.mar.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.dao.RoleDao;
import com.mar.dto.Page;
import com.mar.entity.Role;
import com.mar.entity.User;
import com.mar.service.PermissionService;
import com.mar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Cyc
 * @since 2017-09-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionService permissionService;

    @Override
    public void loadPageResult(Page page) {
        PageHelper.startPage(page.getCurrent(), page.getSize());
        List<User> users = roleDao.pageResult((String) page.getConditions().get("name"), (Integer) page.getConditions().get("companyId"));
        page.setRecords(users);
        page.setTotal((new PageInfo(users)).getTotal());
    }

    @Override
    public void save(Role role) {
        roleDao.insert(role);
        permissionService.linkRolePermissions(role.getId(), role.getPermissions());
    }

    @Override
    public void update(Role role) {
        roleDao.updateById(role);
        permissionService.linkRolePermissions(role.getId(), role.getPermissions());
    }

    @Override
    public void delete(Integer roleId) {
        roleDao.deleteById(roleId);
        permissionService.linkRolePermissions(roleId, new LinkedList<>());
    }

    @Override
    @Transactional
    public void linkUserRole(int userId, List<Role> roles) {
        //清理该用户的所有角色
        roleDao.removeLinkUserRole(userId);
        //新增用户角色
        roleDao.saveLinkUserRole(userId, roles);
    }

}

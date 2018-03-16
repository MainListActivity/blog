package cn.yangyuanxin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cn.yangyuanxin.dao.RoleDao;
import cn.yangyuanxin.dao.UserDao;
import cn.yangyuanxin.dao.UserRoleDao;
import cn.yangyuanxin.domain.RoleDO;
import cn.yangyuanxin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleServiceImpl implements RoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    RoleDao roleMapper;
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;

    @Cacheable(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Override
    public List<RoleDO> list() {
        List<RoleDO> roles = roleMapper.list(new HashMap<>(16));
        return roles;
    }


    @Override
    public List<RoleDO> list(Long userId) {
        List<Long> rolesIds = userRoleMapper.listRoleId(userId);
        List<RoleDO> roles = roleMapper.list(new HashMap<>(16));
        for (RoleDO roleDO : roles) {
            roleDO.setRoleSign("false");
            for (Long roleId : rolesIds) {
                if (Objects.equals(roleDO.getRoleId(), roleId)) {
                    roleDO.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int save(RoleDO role) {

        return 0;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int remove(Long id) {
        return roleMapper.remove(id);
    }

    @Override
    public RoleDO get(Long id) {
        return roleMapper.get(id);
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Override
    public int update(RoleDO role) {

        return 0;
    }

    @Override
    public int batchremove(Long[] ids) {
        return roleMapper.batchRemove(ids);
    }

}

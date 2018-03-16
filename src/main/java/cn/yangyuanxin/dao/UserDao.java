package cn.yangyuanxin.dao;

import cn.yangyuanxin.domain.UserDO;
import cn.yangyuanxin.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by y
 * on 2018/3/10
 */
@Mapper
public interface UserDao {

    UserDO get(Long userId);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO user);

    int update(UserDO user);

    int remove(Long userId);

    int batchRemove(Long[] userIds);

    Long[] listAllDept();

    UserVo getUserRole(String userName);
}
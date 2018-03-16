package cn.yangyuanxin.service.impl;

import cn.yangyuanxin.dao.RoleDao;
import cn.yangyuanxin.dao.UserDao;
import cn.yangyuanxin.dao.UserRoleDao;
import cn.yangyuanxin.domain.UserDO;
import cn.yangyuanxin.domain.UserRoleDO;
import cn.yangyuanxin.service.UserService;
import cn.yangyuanxin.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userMapper;
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserRoleDao userRoleMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDO get(Long id) {
        List<Long> roleIds = userRoleMapper.listRoleId(id);
        UserDO user = userMapper.get(id);
        user.setroleIds(roleIds);
        return user;
    }

    @Override
    public UserVo getUserRole(String userName) {
        return userMapper.getUserRole(userName);
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMapper.count(map);
    }

    @Transactional
    @Override
    public int save(UserDO user) {
        int count = userMapper.save(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getroleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return count;
    }

    @Override
    public int update(UserDO user) {
        int r = userMapper.update(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getroleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return r;
    }

    @Override
    public int remove(Long userId) {
        userRoleMapper.removeByUserId(userId);
        return userMapper.remove(userId);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = userMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public Set<String> listRoles(Long userId) {
        userRoleMapper.listRoleId(userId);
        return null;
    }

    @Override
    public int updatePersonal(UserDO userDO) {
        return 0;
    }

    @Transactional
    @Override
    public int batchremove(Long[] userIds) {
        int count = userMapper.batchRemove(userIds);
        userRoleMapper.batchRemoveByUserId(userIds);
        return count;
    }


    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
//		String fileName = file.getOriginalFilename();
//		fileName = FileUtil.renameToUUID(fileName);
//		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
//		//获取图片后缀
//		String prefix = fileName.substring((fileName.lastIndexOf(".")+1));
//		String[] str=avatar_data.split(",");
//		//获取截取的x坐标
//		int x = (int)Math.floor(Double.parseDouble(str[0].split(":")[1]));
//		//获取截取的y坐标
//		int y = (int)Math.floor(Double.parseDouble(str[1].split(":")[1]));
//		//获取截取的高度
//		int h = (int)Math.floor(Double.parseDouble(str[2].split(":")[1]));
//		//获取截取的宽度
//		int w = (int)Math.floor(Double.parseDouble(str[3].split(":")[1]));
//		//获取旋转的角度
//		int r = Integer.parseInt(str[4].split(":")[1].replaceAll("}", ""));
//		try {
//			BufferedImage cutImage = ImageUtils.cutImage(file,x,y,w,h,prefix);
//			BufferedImage rotateImage = ImageUtils.rotateImage(cutImage, r);
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			boolean flag = ImageIO.write(rotateImage, prefix, out);
//			//转换后存入数据库
//			byte[] b = out.toByteArray();
//			FileUtil.uploadFile(b, bootdoConfig.getUploadPath(), fileName);
//		} catch (Exception e) {
//			throw  new Exception("图片裁剪错误！！");
//		}
        Map<String, Object> result = new HashMap<>();
//		if(sysFileService.save(sysFile)>0){
//			UserDO userDO = new UserDO();
//			userDO.setUserId(userId);
//			userDO.setPicId(sysFile.getId());
//			if(userMapper.update(userDO)>0){
//				result.put("url",sysFile.getUrl());
//			}
//		}
        return result;
    }

}

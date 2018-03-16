package cn.yangyuanxin.vo;

import java.util.List;

/**
 * 版权所有：   y.
 * 创建日期：   18-3-16.
 * 重要说明：
 * 修订历史：
 */
public class UserVo {
    private String username;
    private String password;
    private List<String> roles;
    private List<String> menus;

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

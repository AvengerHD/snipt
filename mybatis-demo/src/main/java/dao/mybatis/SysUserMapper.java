package dao.mybatis;

import org.apache.ibatis.annotations.Param;
import pojo.mybatis.SysRole;
import pojo.mybatis.SysUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {
    SysUser selectById(Long id);

    void insertOne(SysUser sysUser);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
}
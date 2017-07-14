package test;

import dao.mybatis.SysUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import pojo.mybatis.SysRole;
import pojo.mybatis.SysUser;

import java.util.Date;
import java.util.List;

/**
 * Created by kekai on 17/7/12.
 */
public class SysUserTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = sysUserMapper.selectById(1L);
            Assert.assertEquals("admin", sysUser.getUserName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertOne() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("测试用户");
            sysUser.setHeadImg(null);
            sysUser.setCreateTime(new Date());


            sysUserMapper.insertOne(sysUser);
            System.out.println(sysUser.getId());

        }finally {
            //don't call commit
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysRole> roleList = sysUserMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            Assert.assertTrue(roleList.size() > 0);
        }finally {
            //don't call commit
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}

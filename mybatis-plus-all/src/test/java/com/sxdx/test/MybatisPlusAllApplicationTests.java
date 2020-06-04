package com.sxdx.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxdx.mybatis.plus.all.MybatisPlusAllApplication;
import com.sxdx.mybatis.plus.all.entity.User;
import com.sxdx.mybatis.plus.all.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MybatisPlusAllApplication.class})
public class MybatisPlusAllApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelect1() {
        QueryWrapper<User>  queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Sandy").eq("age",21);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
}

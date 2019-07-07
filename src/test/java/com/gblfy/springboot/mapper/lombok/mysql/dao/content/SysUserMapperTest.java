package com.gblfy.springboot.mapper.lombok.mysql.dao.content;

import com.gblfy.springboot.mapper.lombok.mysql.SpringbootMapperLombokMysqlApplicationTests;
import com.gblfy.springboot.mapper.lombok.mysql.domain.entity.content.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class SysUserMapperTest extends SpringbootMapperLombokMysqlApplicationTests {

    @Resource
    private UserMapper userMapper;

    /**
     * 插入数据并查询用户列表
     */
    @Test
    public void insertAndSelect() {

        //插入用户数据
        User user = User.builder()
                .account("gblfy")
                .password("123")
                .createTime(new Date())
                .updateTime(new Date())
                .build();

        int i = this.userMapper.insertSelective(user);

        //查询用户列表
        List<User> userList = this.userMapper.selectAll();
        //断言数据库数据条数为1条,如不是1条则，控制台异常提示
        Assert.assertEquals(1, userList.size());
        //循环遍历用户列表
        for (User u : userList) {
            log.info("用户列表信息={}", u.toString());
        }
    }
}
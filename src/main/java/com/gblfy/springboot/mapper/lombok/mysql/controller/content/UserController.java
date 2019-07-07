package com.gblfy.springboot.mapper.lombok.mysql.controller.content;

import com.gblfy.springboot.mapper.lombok.mysql.dao.content.UserMapper;
import com.gblfy.springboot.mapper.lombok.mysql.domain.entity.content.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author gblfy
 * @ClassNme UserController
 * @Description TODO
 * @Date 2019/7/7 19:09
 * @version1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> insertAndSelect() {
        //插入用户数据
        User user = User.builder()
                .account("gblfy")
                .password("123")
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        int i = this.userMapper.insertSelective(user);
        log.info("插入用户信息成功={}", i);
        //查询用户列表
        List<User> userList = this.userMapper.selectAll();
        log.info("查询用户列表信息成功");
        return userList;
    }
}

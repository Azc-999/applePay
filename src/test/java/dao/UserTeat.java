package dao;

import com.CMe388.dao.UserMapper;
import com.CMe388.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-dao.xml"})
public class UserTeat {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAllUser() {
        List<User> users = userMapper.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void register() {
        User user = new User();
        user.setUsername("lishi");
        user.setPassword("123456");
        int result = userMapper.register(user);
        if (result > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void findOrderWithUser() {
        User user = userMapper.findOrderWithUser(2);
        System.out.println(user);
    }
}

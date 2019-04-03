package dr.jsj.server.user;

import dr.jsj.a.User;
import dr.jsj.dao.UserMapper;
import dr.jsj.server.Iserveruser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2019/4/1.
 */
@Service
public class Serveruserimpl implements Iserveruser {
    @Resource
    UserMapper userMapper;
    public int add(User user) {
        return userMapper.insertSelective(user);
    }
}

package dr.jsj.a;

import dr.jsj.server.Iserveruser;
import dr.jsj.util.DESUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lenovo on 2019/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml" )
public class Mytest {
    @Resource
    Iserveruser iserveruser;
    @Test
    public void method(){
        User user=new User();
        user.setLoginId("001");
        user.setName("张三");
        user.setPassword(DESUtil.jm("1234"));
        user.setPhone("121234");
        user.setEmail("q233@qq.com");
        user.setSex(1);
        user.setCreateDate(new Date());
        System.out.println(iserveruser.add(user));
    }
}

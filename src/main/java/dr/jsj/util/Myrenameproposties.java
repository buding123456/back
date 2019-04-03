package dr.jsj.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by lenovo on 2019/4/1.
 */
public class Myrenameproposties extends PropertyPlaceholderConfigurer {
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(propertyName.equals("username")||propertyName.equals("password")){
            return DESUtil.jjm(propertyValue);
        }
        return propertyValue;
    }
}

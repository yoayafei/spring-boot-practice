package top.yyf.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yyf.springboot.redis.entity.User;
import top.yyf.springboot.redis.vo.UserInfoVO;
import top.yyf.springboot.redis.vo.UserLoginVO;

public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone, String code);

    boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}

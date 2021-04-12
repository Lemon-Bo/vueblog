package cn.lemon.service.impl;

import cn.lemon.entity.User;
import cn.lemon.mapper.UserMapper;
import cn.lemon.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemon:柠檬
 * @since 2021-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

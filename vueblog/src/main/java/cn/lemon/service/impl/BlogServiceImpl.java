package cn.lemon.service.impl;

import cn.lemon.entity.Blog;
import cn.lemon.mapper.BlogMapper;
import cn.lemon.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}

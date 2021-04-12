package cn.lemon.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.lemon.common.lang.Result;
import cn.lemon.entity.Blog;
import cn.lemon.service.BlogService;
import cn.lemon.util.ShiroUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemon:柠檬
 * @since 2021-04-09
 */
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;


    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,5);
        IPage iPage = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.succ(iPage);
    }
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(value ="id") Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"该博客不存在");
        return Result.succ(blog);
    }
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp =null;
        if (blog.getId() !=null){
            temp = blogService.getById(blog.getId());
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(),"没有权限编辑");
        }else {
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog,temp,"id","userId","created","status");
        blogService.saveOrUpdate(temp);
        return Result.succ(null);
    }

    @RequiresAuthentication
    @GetMapping("/blog/{id}/delete")
    public Result delete(@PathVariable(value ="id") Long id){
        Assert.isTrue(blogService.getById(id).getUserId().longValue()
                        == ShiroUtil.getProfile().getId().longValue(),
                "没有权限删除");
        blogService.removeById(id);
        return Result.succ(null);
    }
}

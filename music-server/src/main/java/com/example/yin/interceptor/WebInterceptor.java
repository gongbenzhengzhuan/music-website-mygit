package com.example.yin.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.yin.mapper.AdminMapper;
import com.example.yin.model.domain.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@Component
public class WebInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminMapper adminMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        System.out.println("权限的值name:" + name);

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        if (adminMapper.selectCount(queryWrapper) > 0) {
            System.out.println("权限认证成功！！！！！！！！！！！！！！！！！！！！！");
            return true;
        }
        System.out.println("权限认证失败，获取不到session的值！！！！！！！！！！！！！！！！！！！！！");
        return true;
    }
}


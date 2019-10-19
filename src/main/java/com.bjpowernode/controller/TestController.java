package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author:whr 2019/10/18
 */
@Controller
public class TestController {

    /**
     * 获取session
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSession", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String key = (String) session.getAttribute("key");
        return key;
    }

    /**
     * 放置session
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/setSession", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String setSession(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        session.setAttribute("key", "test_session");

        return "session放好了";
    }

}

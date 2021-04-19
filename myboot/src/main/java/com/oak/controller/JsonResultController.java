package com.oak.controller;

import com.oak.entity.JsonResult;
import com.oak.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {

    @RequestMapping("/user")
    public JsonResult<User> getUser(){
        User user = new User((long) 1, "刘亦菲", "20");
        return new JsonResult<>(user);
    }
    @RequestMapping("/list")
    public JsonResult<List> getList(){
        ArrayList<User> list = new ArrayList<>();
        User user = new User((long) 1, "张韶涵", "20");
        User user1 = new User((long) 2,"赵敏","23");
        list.add(user);
        list.add(user1);
        return new JsonResult<>(list,"获取用户列表成功");
    }
    @RequestMapping("/map")
    public JsonResult<Object> getMap(){
        HashMap<String, Object> map = new HashMap<>();
        User user1 = new User((long) 2,"赵敏",null);
        map.put("笔者",user1);
        map.put("年龄",null);
        return new JsonResult<>( "错误信息", "2");
    }
}

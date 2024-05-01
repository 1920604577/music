package com.hln.music.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.hln.music.pojo.Singer;
import com.hln.music.service.SingerService;
import com.hln.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    /**
     * 添加歌手
     */
    @PostMapping("/add")
    public Object addSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 保存到歌手的对象中
        Singer singer = new Singer();
        singer.setName(name);
        singer.setSex(Integer.valueOf(sex));
        singer.setPic(pic);
        singer.setBirth(birthDate);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.insert(singer);
        if (flag) {//保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    /**
     * 修改歌手
     */
    @PostMapping("/update")
    public Object updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 保存到歌手的对象中
        Singer singer = new Singer();
        singer.setId(Long.valueOf(id));
        singer.setName(name);
        singer.setSex(Integer.valueOf(sex));
        singer.setBirth(birthDate);
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.update(singer);
        if (flag) {//保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    /**
     * 删除歌手
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = singerService.delete(Long.valueOf(id));
        return flag;
    }

    /**
     * 根据id查询对象
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        return singerService.selectByPrimaryKey(Long.valueOf(id));
    }

    /**
     * 查询所有
     */
    @RequestMapping(value = "/allSinger",method = RequestMethod.GET)
    public Object allSinger(HttpServletRequest request) {
        return singerService.allSinger();
    }

    /**
     * 根据歌手名模糊查询list
     */
    @RequestMapping(value = "/singerOfName",method = RequestMethod.GET)
    public Object singerOfName(HttpServletRequest request) {
        String name = request.getParameter("name").trim();
        return singerService.singerOfName("%"+name+"%");
    }

    /**
     * 根据性别查询
     */
    @RequestMapping(value = "/singerOfSex",method = RequestMethod.GET)
    public Object singerOfSex(HttpServletRequest request) {
        String sex = request.getParameter("sex").trim();
        return singerService.singerOfSex(Integer.parseInt(sex));
    }

}

package com.hln.music.controller;

import cn.hutool.json.JSONObject;
import com.hln.music.pojo.Singer;
import com.hln.music.pojo.Song;
import com.hln.music.service.SongService;
import com.hln.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    //    添加歌曲
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSong(HttpServletRequest req, @RequestParam("file") MultipartFile mpfile) {
        JSONObject jsonObject = new JSONObject();
        String singer_id = req.getParameter("singerId").trim();
        String name = req.getParameter("name").trim();
        String introduction = req.getParameter("introduction").trim();
        String pic = "/img/songPic/11.jpeg";
        String lyric = req.getParameter("lyric").trim();

        if (mpfile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "音乐上传失败！");
            return jsonObject;
        }
        String fileName = mpfile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            mpfile.transferTo(dest);
            Song song = new Song();
            song.setSingerId(Long.valueOf(singer_id));
            song.setName(name);
            song.setIntroduction(introduction);
            song.setPic(pic);
            song.setLyric(lyric);
            song.setUrl(storeUrlPath);
            boolean res = songService.insert(song);
            System.out.println(res);
            if (res) {
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeUrlPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        } finally {
            return jsonObject;
        }
    }

    /**
     * 根据歌手id查询
     */
    @ResponseBody
    @RequestMapping(value = "/singer/detail", method = RequestMethod.GET)
    public Object songOfSingerId(HttpServletRequest request) {

        String singerId = request.getParameter("singerId");
        return songService.songOfSingerId(Long.valueOf(singerId));
    }

    /**
     * 修改歌曲
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String introduction = request.getParameter("introduction").trim();
        String lyric = request.getParameter("lyric").trim();

        // 保存到歌曲的对象中
        Song song = new Song();
        song.setId(Long.valueOf(id));
        song.setName(name);
        song.setIntroduction(introduction);
        song.setLyric(lyric);
        boolean flag = songService.update(song);
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
     * 删除歌曲
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request) {
        // TODO 先查询到数据库中对应的文件地址，删除吊塔再进行下面的代码
        String id = request.getParameter("id").trim();
        boolean flag = songService.delete(Long.valueOf(id));
        return flag;
    }

    /**
     * 上传歌曲图片
     */
    @ResponseBody
    @RequestMapping(value = "/updateSongPic", method = RequestMethod.POST)
    public Object updateSongPic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        if (multipartFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        // 文件名=当前时间到ms + 原来的文件名
        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "songPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        // 实际的文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        // 存储到数据库里的相对稳健地址
        String storeMultipartPath = "/img/songPic/" + fileName;
        try {
            multipartFile.transferTo(dest);
            Song song = new Song();
            song.setId((long) id);
            song.setPic(storeMultipartPath);
            boolean flag = songService.update(song);
            if (flag) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("pic",storeMultipartPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }

    /**
     * 上传歌曲图片
     */
    @ResponseBody
    @RequestMapping(value = "/updateSongUrl", method = RequestMethod.POST)
    public Object updateSongUrl(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") int id) {
        // TODO 删除源文件
        JSONObject jsonObject = new JSONObject();
        if (multipartFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        // 文件名=当前时间到ms + 原来的文件名
        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        // 实际的文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        // 存储到数据库里的相对稳健地址
        String storeMultipartPath = "/song/" + fileName;
        try {
            multipartFile.transferTo(dest);
            Song song = new Song();
            song.setId((long) id);
            song.setUrl(storeMultipartPath);
            boolean flag = songService.update(song);
            if (flag) {
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("avator",storeMultipartPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败" + e.getMessage());
        } finally {
            return jsonObject;
        }
    }
}

package davion.study.face.controllers;

import davion.study.face.utils.BaiduUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author: Davion
 * @date: 2020/1/2
 * @description:
 */
@Controller
public class IndexController {

    @Autowired
    private BaiduUtil baiduUtil;

    @RequestMapping("/")
    public String test(){
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @ResponseBody
    @PostMapping("/register")
    public Object image(@RequestParam(name = "img") String img,
                        @RequestParam(name = "userId") String userId) throws IOException {
        return baiduUtil.registerFace(img, userId);
    }

    @GetMapping("/search")
    public String getSearch(){
        return "search";
    }

    @ResponseBody
    @PostMapping("/search")
    public Object search(@RequestParam(name = "img") String img) throws IOException {
        return baiduUtil.search(img);
    }
}

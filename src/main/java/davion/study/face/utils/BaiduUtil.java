package davion.study.face.utils;

import com.alibaba.fastjson.JSON;
import davion.study.face.dto.RegisterDto;
import davion.study.face.dto.SearchDto;
import okhttp3.Headers;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Davion
 * @date: 2020/1/2
 * @description:
 */
@Component
public class BaiduUtil {

    @Autowired
    private OkHttpClientUtil okHttpClientUtil;

    @Value("${baidu.access_token}")
    private String accessToken;

    public RegisterDto registerFace(String img, String userId) throws IOException {
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add?access_token=" + accessToken;
        Headers headers = new Headers.Builder()
                .add("Content-Type", "application/json").build();
        Map<String, String> body = new HashMap<>();
        body.put("image", img.replace("data:image/png;base64,", ""));
        body.put("image_type", "BASE64");
        body.put("group_id", "davion");
        body.put("user_id", userId);
        Response response = okHttpClientUtil.postData(url, body, headers);
        String string = response.body().string();
        RegisterDto registerDto = JSON.parseObject(string, RegisterDto.class);
        return registerDto;
    }

    public SearchDto search(String img) throws IOException {
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search?access_token=" + accessToken;
        Headers headers = new Headers.Builder()
                .add("Content-Type", "application/json").build();
        Map<String, String> body = new HashMap<>();
        body.put("image", img.replace("data:image/png;base64,", ""));
        body.put("image_type", "BASE64");
        body.put("group_id_list", "davion");
        Response response = okHttpClientUtil.postData(url, body, headers);
        String string = response.body().string();
        SearchDto searchDto = JSON.parseObject(string, SearchDto.class);
        return searchDto;
    }
}

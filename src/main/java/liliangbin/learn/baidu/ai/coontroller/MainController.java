package liliangbin.learn.baidu.ai.coontroller;


import liliangbin.learn.baidu.ai.service.AuthService;
import liliangbin.learn.baidu.ai.service.OCRTest;
import liliangbin.learn.baidu.ai.util.BASE64;
import liliangbin.learn.baidu.ai.util.Base64Util;
import liliangbin.learn.baidu.ai.util.FileUtil;
import liliangbin.learn.baidu.ai.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.net.URLEncoder;


/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/3/24  12:59
 */
@RestController
public class MainController {


    @GetMapping("/auth")
    public Object name() {

        return AuthService.getAuth();
    }

    /*
     * 官方给的方法
     *
     * */
    @GetMapping("/images")
    public Object images(String userURL) {


        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
        // 本地图片路径
        String filePath = "C:\\Users\\liliangbin\\Pictures\\1.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);

            // String imgStr = Base64Util.encode(imgData);

            String imgStr = userURL;

            // String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");

            String params = URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            String accessToken = "24.a14d1b4f1c7796ba18c123669f794796.2592000.1524460154.282335-10988746";
            String result = HttpUtil.post(otherHost, accessToken, params);
            System.out.println(result);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
     *
     * 这个是在网上找的一个方法。*/
    @PostMapping("/img")
    public Object img() {

        String access_token = "24.a14d1b4f1c7796ba18c123669f794796.2592000.1524460154.282335-10988746";
        File file = new File("C:\\Users\\liliangbin\\Pictures\\1.jpg");
        String imageBase = BASE64.encodeImgageToBase64(file);
        imageBase = imageBase.replaceAll("\r\n", "");
        imageBase = imageBase.replaceAll("\\+", "%2B");
        String httpUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";

        // String httpUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";
        String httpArg = "access_token=" + access_token + " &image=" + imageBase;
        String jsonResult = OCRTest.request(httpUrl, httpArg);
        System.out.println("返回的结果--------->" + jsonResult);
        return jsonResult;
    }
}

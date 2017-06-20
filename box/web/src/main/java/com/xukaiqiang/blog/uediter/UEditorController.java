package com.xukaiqiang.blog.uediter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UEditorController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年7月21日 上午3:10:08
 * @modifier
 * @modify-date 2016年7月21日 上午3:10:08
 * @version 1.0
*/
@Controller
@RequestMapping("/ued")
public class UEditorController {
	@RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        response.setContentType("application/json");
        String rootPath = request.getSession()
                .getServletContext().getRealPath("/");
 
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.idcard_pwsc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LENOVO
 */
@Controller
public class controller {
    
    //@ResponseBody
    @RequestMapping("/getData")
    public String getData(@RequestParam("namamhs") String name,
                          @RequestParam("ttl") @DateTimeFormat(pattern="yyyy-MM-dd")Date date,
                          @RequestParam("fotomhs")MultipartFile image,
                          Model model)
                          throws IOException {
        
        SimpleDateFormat ttl = new SimpleDateFormat ("yyyy-MM-dd");
        String newTtl = ttl.format(date);
        
        String blob = Base64.encodeBase64String(image.getBytes());
        String img = "data:image/jpeg;base64,".concat(blob);
        
        model.addAttribute("nm", name);
        model.addAttribute("dt", newTtl);
        model.addAttribute("fotomhs", img);
        
        return "hasil";
        
        
}
    
}
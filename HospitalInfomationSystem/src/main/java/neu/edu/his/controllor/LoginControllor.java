package neu.edu.his.controllor;

import neu.edu.his.bean.DoctorBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginControllor {
    @Autowired
    HisService hisService;

    @RequestMapping({"", "/login"}) //这里为空或者是login都能进入该方法
    public String show(HttpSession session) {
//        if(session.getAttribute("doctorBean")!=null){
//            session.removeAttribute("doc");
//        }
        return "login";
    }

    @RequestMapping(value="/loginCheck",method= RequestMethod.POST)
    public String login(String loginID, String password, ModelMap modelMap, HttpServletRequest request){
        DoctorBean doctorBean= hisService.loginCheck(loginID,password);
        modelMap.addAttribute("doc",doctorBean);
        HttpSession sessoin=request.getSession();//session的创建
        sessoin.setAttribute("doctorBean",doctorBean);
        if(doctorBean!=null){
            return "myIndex";
        }else{
            return "error";
        }
    }

}

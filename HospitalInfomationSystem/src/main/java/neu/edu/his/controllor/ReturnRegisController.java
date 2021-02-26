package neu.edu.his.controllor;

import neu.edu.his.bean.RegistrationBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReturnRegisController {
    @Autowired
    HisService hisService;

    @RequestMapping("/returnRegistration")
    public String showRegistrationn(ModelMap modelMap) {
        List<RegistrationBean> regisList=hisService.getDaiZhen();
        modelMap.addAttribute("regisList",regisList);
        return "returnRegis";
    }

    @RequestMapping("/returnRegistration+{recordId}")
    public String returnRegistrationn(@PathVariable("recordId") int regisId,ModelMap modelMap) {
        hisService.returnRegis(regisId);
        List<RegistrationBean> regisList=hisService.getDaiZhen();
        modelMap.addAttribute("regisList",regisList);
        return "returnRegis";
    }
}

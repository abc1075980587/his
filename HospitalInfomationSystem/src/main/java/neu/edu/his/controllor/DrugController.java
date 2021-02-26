package neu.edu.his.controllor;

import neu.edu.his.bean.ChargeListBean;
import neu.edu.his.bean.PrescriptionBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DrugController {
    @Autowired
    HisService hisService;

    @RequestMapping("/showDrugStatement")
    public String show(ModelMap modelMap){
        List<PrescriptionBean> presList=hisService.getPresList();
        modelMap.addAttribute("presList",presList);
        return "drugs";
    }

    @RequestMapping("/showDrugDetail+{regisId}")
    public String showDrugDetail(ModelMap modelMap1, ModelMap modelMap2, @PathVariable("regisId")int regisId, HttpSession session){
        List<ChargeListBean> charList=hisService.getChargeListByRegisId(regisId);
        modelMap2.addAttribute("charList",charList);
        List<PrescriptionBean> presList=hisService.getPresList();
        modelMap1.addAttribute("presList",presList);
        session.setAttribute("regisId_4",regisId);
        return "drugsDetail";
    }

    @RequestMapping("/giveDrugs")
    public String giveDrugs(ModelMap modelMap1,HttpSession session){

        int regisId=(int)session.getAttribute("regisId_4");
        hisService.updateIsTaken(regisId);
        List<PrescriptionBean> presList=hisService.getPresList();
        modelMap1.addAttribute("presList",presList);
        return "drugs";
    }
}

package neu.edu.his.controllor;

import neu.edu.his.bean.DepartmentBean;
import neu.edu.his.bean.MedicalRecordBean;
import neu.edu.his.bean.RegistrationBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DiagnoseController {
    @Autowired
    HisService hisService;

    @RequestMapping("/showDiagnoseList")
    public String show(ModelMap modelMap1, ModelMap modelMap2, HttpSession session) {
        List<RegistrationBean> daiZhenList=hisService.getDaiZhenList();
        List<RegistrationBean> yiZhenList=hisService.getYiZhenList();
//        session.setAttribute("daiZhenList",daiZhenList);
//        session.setAttribute("yiZhenList",yiZhenList);
        modelMap1.addAttribute("daiZhenList",daiZhenList);
        modelMap2.addAttribute("yiZhenList",yiZhenList);
        return "diagnoseList";
    }

    @RequestMapping("/diagnoseStart+{recordId}+{regisId}")
    public String startDiagnose(HttpSession session,@PathVariable("recordId")int recordId,@PathVariable("regisId")int regisId) {
        session.setAttribute("recordId",recordId);
        session.setAttribute(("regisId"),regisId);
        return "diagnose";
    }

    @RequestMapping("/diagnoseSubmit")
    public String diagnoseSubmit(HttpSession session, MedicalRecordBean medicalRecordBean){
        int recordId=(int)session.getAttribute("recordId");
        int regisId=(int)session.getAttribute("regisId");
        medicalRecordBean.setRecordId(recordId);
        medicalRecordBean.setRegisId(regisId);
        medicalRecordBean.setStatement("诊毕");
        medicalRecordBean.setDrugStatement("未开药");
        medicalRecordBean.setIsDeleted("1");
        hisService.diagnose(medicalRecordBean);
        hisService.updateRegisList(recordId);
        return "diagnoseList";
    }
}

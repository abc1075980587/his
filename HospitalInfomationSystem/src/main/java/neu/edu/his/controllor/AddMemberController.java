package neu.edu.his.controllor;

import neu.edu.his.bean.DepartmentBean;
import neu.edu.his.bean.DoctorBean;
import neu.edu.his.bean.MedicalRecordBean;
import neu.edu.his.bean.RegistrationBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AddMemberController {
    @Autowired
    HisService hisService;

    @RequestMapping("/addMember")
    public String show(ModelMap modelMap1,ModelMap modelMap2) {
        List<DepartmentBean> depList=hisService.getAllDepartments();
        modelMap1.addAttribute("depList",depList);
        int recordId= hisService.getIncrementRecordId();
        modelMap2.addAttribute("recordId",recordId);
        return "member-add";
    }

//    @RequestMapping("/addMember/dep")
//    @ResponseBody
//    public List<DepartmentBean> showDept() {
//        return hisService.getAllDepartments();
//    }

    @RequestMapping(value = "/addMember/doc")
    @ResponseBody
    public List<DoctorBean> showDoc(@RequestHeader("application/json") @RequestBody Map<String,Integer> map,ModelMap modelMap) {
        return  hisService.getDoctorByDept(map.get("deptId"));
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(RegistrationBean registrationBean){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regisDate=sdf.format(date);
        registrationBean.setRegisDate(regisDate);
        registrationBean.setDiagnosedStatement("待诊");
        registrationBean.setIsDeleted("1");
        hisService.register(registrationBean);
        return "100";
    }
//    @RequestMapping("/getRecordId")
//    public int getIncrementRecordId(){
//        return hisService.getIncrementRecordId();
//    }
}

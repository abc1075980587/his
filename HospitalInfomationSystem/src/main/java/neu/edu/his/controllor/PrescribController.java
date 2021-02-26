package neu.edu.his.controllor;

import neu.edu.his.bean.*;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PrescribController {

    @Autowired
    HisService hisService;

    @RequestMapping("/showMedicalRecordList")
    public String show(ModelMap modelMap, HttpSession session) {
        List<MedicalRecordBean> mrList=hisService.getMedicalRecord();
        modelMap.addAttribute("mrList",mrList);
        List<TempDrugBean> tdbList=new ArrayList<>();
        session.setAttribute("tdbList",tdbList);
        return "medicalRecordList";
    }


    @RequestMapping("/prescribStart+{recordId}+{regisId}")
    public String prescrib(ModelMap modelMap1, ModelMap modelMap2, ModelMap modelMap3, ModelMap modelMap4, HttpSession session,
                           @PathVariable("recordId") int recordId,@PathVariable("regisId") int regisId) {
        session.setAttribute("recordId_2",recordId);
        session.setAttribute("regisId_2",regisId);

        List<DoctorBean> docList= hisService.getAllDoc();
        List<DrugsBean> drugsList=hisService.getAllDrugs();
        modelMap3.addAttribute("docList",docList);
        modelMap4.addAttribute("drugsList",drugsList);
        return "prescript";
    }

    @RequestMapping("/addDrug")
    @ResponseBody
    public String addDrug(HttpSession session, @RequestBody Map<String,String> map){
        TempDrugBean tempDrugBean=new TempDrugBean();
        tempDrugBean.setDrugid(map.get("drugid"));
        tempDrugBean.setDrugname(hisService.getDrugNameById(map.get("drugid")));
        tempDrugBean.setNum(map.get("num"));
        List<TempDrugBean> tdbList=(List<TempDrugBean>) session.getAttribute("tdbList");
        tdbList.add(tempDrugBean);
        return "prescript";
    }

    @RequestMapping("/prescriptionSubmit")
    public String diagnoseSubmit(HttpSession session,PrescriptionBean prescriptionBean) {
        int recordId=(int)session.getAttribute("recordId_2");
        int regisId=(int)session.getAttribute("regisId_2");
        Date pdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(pdate);
        prescriptionBean.setRecordId(recordId);
        prescriptionBean.setRegisId(regisId);
        prescriptionBean.setDate(date);
        prescriptionBean.setIsTaken("未发药");
        prescriptionBean.setIsReturned("未缴费");
        prescriptionBean.setIsAddedToCharge("未生成");
        prescriptionBean.setIsDeleted("1");

        //将药品列表的药品id和药品数量取出，构建一个字符串
        StringBuffer sb=new StringBuffer();
        List<TempDrugBean> tdbList=(List<TempDrugBean>) session.getAttribute("tdbList");
        for(TempDrugBean tdb:tdbList){
            sb.append(tdb.getDrugid());
            sb.append(",");
            sb.append(tdb.getNum());
            sb.append(",");
        }
        prescriptionBean.setDrugsId(sb.toString());

        hisService.prescrib(prescriptionBean);
        hisService.updateDrugStatement(recordId);
//        return "medicalRecordList";
        return "prescript";

    }
}

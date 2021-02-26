package neu.edu.his.controllor;

import neu.edu.his.bean.ChargeListBean;
import neu.edu.his.bean.DoctorBean;
import neu.edu.his.bean.PrescriptionBean;
import neu.edu.his.bean.ReceiptBean;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ChargeController {
    @Autowired
    HisService hisService;

    @RequestMapping("/showPayList")
    public String show(ModelMap modelMap1, ModelMap modelMap2){
        List<PrescriptionBean> pWeiList=hisService.getPrescriptionWei();
        List<PrescriptionBean> pYiList=hisService.getPrescriptionYi();
        modelMap1.addAttribute("pWeiList",pWeiList);
        modelMap2.addAttribute("pYiList",pYiList);
        return "payList";
    }

    @RequestMapping("/createCharge+{prescriptionId}")
    public String createChargeList(ModelMap modelMap1,ModelMap modelMap2,HttpSession session,@PathVariable("prescriptionId")int prescriptionId){
        int regisId=hisService.getRegisIdByPrescriptionId(prescriptionId);
        int receiptId=hisService.getIncrementReceiptId();
        int proType=2;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String paydate=sdf.format(date);
        DoctorBean doctorBean=(DoctorBean) session.getAttribute("doctorBean");
        int regisClerkId=doctorBean.getDocid();
        String isDeleted="1";

        String drugsId=hisService.getDrugsIdByPrescriptionId(prescriptionId);
        String[] drugsString=drugsId.split(",");
        for(int i=0;i<drugsString.length;i=i+2){
            String drugId=drugsString[i];
            String itemName= hisService.getDrugNameById(drugId);
            double singleCost=hisService.getDrugPriceByDrugId(drugId);
            int num=Integer.parseInt(drugsString[i+1]);
            ChargeListBean chargeListBean=new ChargeListBean();
            chargeListBean.setRegisId(regisId);
            chargeListBean.setReceiptId(receiptId);
            chargeListBean.setProType(proType);
            chargeListBean.setDrugsId(drugId);
            chargeListBean.setItemName(itemName);
            chargeListBean.setSingleCost(singleCost);
            chargeListBean.setNum(num);
            chargeListBean.setPaydate(paydate);
            chargeListBean.setRegisClerkId(regisClerkId);
            chargeListBean.setIsDeleted(isDeleted);
            hisService.createChargeList(chargeListBean);
        }
        hisService.updateIsAddedToChargeList(prescriptionId);
        List<PrescriptionBean> pWeiList=hisService.getPrescriptionWei();
        modelMap1.addAttribute("pWeiList",pWeiList);
        List<PrescriptionBean> pYiList=hisService.getPrescriptionYi();
        modelMap2.addAttribute("pYiList",pYiList);
        return "payList";
    }

    @RequestMapping("/showChargeList")
    public String showList(ModelMap modelMap1,int regisId,ModelMap modelMap2,HttpSession session){
        List<ChargeListBean> chargeList=hisService.getChargeListByRegisId(regisId);
        session.setAttribute("regisId_3",regisId);
        modelMap1.addAttribute("chargeList",chargeList);
        double totalPrice=0;
        for(ChargeListBean clb:chargeList){
            totalPrice += clb.getSingleCost() * clb.getNum();
        }
        BigDecimal bg = new BigDecimal(totalPrice);
        double cost = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        session.setAttribute("totalPrice",cost);
        return "charge";
    }

    @RequestMapping("/pay")
    public String pay(HttpSession session,ModelMap modelMap1, ModelMap modelMap2){
        int regisId=(int)session.getAttribute("regisId_3");

        int receiptId=hisService.getReceiptIdByRegisId(regisId);
        double totalPrice=(double)session.getAttribute("totalPrice");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String rdate=sdf.format(date);
        int receiptSeqNum=hisService.getIncrementReceiptSeqNum();
        ReceiptBean receiptBean=new ReceiptBean();
        receiptBean.setReceiptId(receiptId);
        receiptBean.setReceiptSeqNum(receiptSeqNum);
        receiptBean.setCost(totalPrice);
        receiptBean.setStatement("缴费");
        receiptBean.setDate(rdate);
        receiptBean.setRegisId(regisId);
        receiptBean.setIsDeleted("1");
        hisService.createReceipt(receiptBean);
        hisService.updateIsReturned(regisId);
        List<PrescriptionBean> pYiList=hisService.getPrescriptionYi();
        List<PrescriptionBean> pWeiList=hisService.getPrescriptionWei();
        modelMap1.addAttribute("pWeiList",pWeiList);
        modelMap2.addAttribute("pYiList",pYiList);
        return "payList";
    }

}

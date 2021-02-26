package neu.edu.his.service;

import neu.edu.his.bean.*;

import java.util.List;


public interface HisService {
    //登录验证
    DoctorBean loginCheck(String loginID, String password);
    //挂号
    void register(RegistrationBean registrationBean);
    //查询所有科室
    List<DepartmentBean> getAllDepartments();
    //按科室查询医生
    List<DoctorBean> getDoctorByDept(int deptID);
    //获取病历号
    int getIncrementRecordId();
    //获取所有待诊患者
    List<RegistrationBean> getDaiZhen();
    //退号
    void returnRegis(int regisID);
    //获取待诊患者（挂号时间在规定时间之内）
    List<RegistrationBean> getDaiZhenList();
    //获取已诊患者（挂号时间在规定时间之内）
    List<RegistrationBean> getYiZhenList();
    //医生诊断，写病历
    void diagnose(MedicalRecordBean medicalRecordBean);
    //更新挂号信息
    void updateRegisList(int recordId);
    //获取病历
    List<MedicalRecordBean> getMedicalRecord();
    //医生开药
    void prescrib(PrescriptionBean prescriptionBean);
    //获取医生
    List<DoctorBean> getAllDoc();
    //获取药品
    List<DrugsBean> getAllDrugs();
    //根据药品id查询药品名
    String getDrugNameById(String drugid);
    //更新开药状态
    void updateDrugStatement(int recordId);
    //获取未生成缴费单的处方表
    List<PrescriptionBean> getPrescriptionWei();
    //获取未生成缴费单的处方表
    List<PrescriptionBean> getPrescriptionYi();
    //获取最大发票号+1
    int getIncrementReceiptId();
    //获取最大发票序列号+1
    int getIncrementReceiptSeqNum();
    //创建缴费单
    void createChargeList(ChargeListBean chargeListBean);
    //通过处方id获取挂号id
    int getRegisIdByPrescriptionId(int prescriptionId);
    //通过处方id获取药品id
    String getDrugsIdByPrescriptionId(int prescriptionId);
    //通过药品id获得单价
    double getDrugPriceByDrugId(String drugsId);
    //更新处方表缴费单生成情况
    void updateIsAddedToChargeList(int prescriptionId);
    //根据挂号id查询缴费单
    List<ChargeListBean> getChargeListByRegisId(int regisId);
    //更新处方表缴费情况
    void updateIsReturned(int regisId);
    //通过挂号id获得费用单的发票id
    int getReceiptIdByRegisId(int regisId);
    //缴费同时生成发票
    void createReceipt(ReceiptBean receiptBean);
    //获取未发药处方表
    List<PrescriptionBean> getPresList();
    //更新发药状态
    void updateIsTaken(int regisId);





}

package neu.edu.his.serviceImpl;

import neu.edu.his.bean.*;
import neu.edu.his.mapper.*;
import neu.edu.his.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HisServiceImpl implements HisService {
    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    DepartmentDoctorMapper departmentDoctorMapper;

    @Autowired
    ReturnRegisMapper returnRegisMapper;

    @Autowired
    DiagnoseMapper diagnoseMapper;

    @Autowired
    PrescribMapper prescribMapper;

    @Autowired
    ChargeMapper chargeMapper;

    @Autowired
    DrugsMapper drugsMapper;

    @Override
    public DoctorBean loginCheck(String loginID, String password) {
        return doctorMapper.loginCheck(loginID,password);
    }

    @Transactional
    @Override
    public void register(RegistrationBean registrationBean){
        registerMapper.register(registrationBean);
    }

    @Override
    public List<DepartmentBean> getAllDepartments(){
        return departmentDoctorMapper.getAllDepartments();
    }

    @Override
    public List<DoctorBean> getDoctorByDept(int deptID) {
        return departmentDoctorMapper.getDoctorByDept(deptID);
    }

    @Override
    public int getIncrementRecordId() {
        return registerMapper.getIncrementRecordId();
    }

    @Override
    public List<RegistrationBean> getDaiZhen() {
        return returnRegisMapper.getDaiZhen();
    }

    @Override
    public void returnRegis(int regisID) {
        returnRegisMapper.returnRegis(regisID);
    }

    @Override
    public List<RegistrationBean> getDaiZhenList() {
        return diagnoseMapper.getDaiZhenList();
    }

    @Override
    public List<RegistrationBean> getYiZhenList() {
        return diagnoseMapper.getYiZhenList();
    }

    @Override
    public void diagnose(MedicalRecordBean medicalRecordBean) {
        diagnoseMapper.diagnose(medicalRecordBean);
    }

    @Override
    public void updateRegisList(int recordId) {
        diagnoseMapper.updateRegisList(recordId);
    }

    @Override
    public List<MedicalRecordBean> getMedicalRecord() {
        return prescribMapper.getMedicalRecord();
    }

    @Override
    public void prescrib(PrescriptionBean prescriptionBean) {
        prescribMapper.prescrib(prescriptionBean);
    }

    @Override
    public List<DoctorBean> getAllDoc() {
        return prescribMapper.getAllDoc();
    }

    @Override
    public List<DrugsBean> getAllDrugs() {
        return prescribMapper.getAllDrugs();
    }

    @Override
    public String getDrugNameById(String drugid) {
        return prescribMapper.getDrugNameById(drugid);
    }

    @Override
    public void updateDrugStatement(int recordId) {
        prescribMapper.updateDrugStatement(recordId);
    }

    @Override
    public List<PrescriptionBean> getPrescriptionWei() {
        return chargeMapper.getPrescriptionWei();
    }

    @Override
    public List<PrescriptionBean> getPrescriptionYi() {
        return chargeMapper.getPrescriptionYi();
    }

    @Override
    public int getIncrementReceiptId() {
        return chargeMapper.getIncrementReceiptId();
    }

    @Override
    public int getIncrementReceiptSeqNum() {
        return chargeMapper.getIncrementReceiptSeqNum();
    }

    @Override
    public void createChargeList(ChargeListBean chargeListBean) {
        chargeMapper.createChargeList(chargeListBean);
    }

    @Override
    public int getRegisIdByPrescriptionId(int prescriptionId) {
        return chargeMapper.getRegisIdByPrescriptionId(prescriptionId);
    }

    @Override
    public String getDrugsIdByPrescriptionId(int prescriptionId) {
        return chargeMapper.getDrugsIdByPrescriptionId(prescriptionId);
    }

    @Override
    public double getDrugPriceByDrugId(String drugsId) {
        return chargeMapper.getDrugPriceByDrugId(drugsId);
    }

    @Override
    public void updateIsAddedToChargeList(int prescriptionId) {
        chargeMapper.updateIsAddedToChargeList(prescriptionId);
    }

    @Override
    public List<ChargeListBean> getChargeListByRegisId(int regisId) {
        return chargeMapper.getChargeListByRegisId(regisId);
    }

    @Override
    public void updateIsReturned(int regisId) {
        chargeMapper.updateIsReturned(regisId);
    }

    @Override
    public int getReceiptIdByRegisId(int regisId) {
        return chargeMapper.getReceiptIdByRegisId(regisId);
    }

    @Override
    public void createReceipt(ReceiptBean receiptBean) {
        chargeMapper.createReceipt(receiptBean);
    }

    @Override
    public List<PrescriptionBean> getPresList() {
        return drugsMapper.getPresList();
    }

    @Override
    public void updateIsTaken(int regisId) {
        drugsMapper.updateIsTaken(regisId);
    }
}

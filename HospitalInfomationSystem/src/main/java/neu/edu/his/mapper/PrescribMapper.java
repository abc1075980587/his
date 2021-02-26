package neu.edu.his.mapper;

import neu.edu.his.bean.DoctorBean;
import neu.edu.his.bean.DrugsBean;
import neu.edu.his.bean.MedicalRecordBean;
import neu.edu.his.bean.PrescriptionBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PrescribMapper {

    List<MedicalRecordBean> getMedicalRecord();

    void prescrib(PrescriptionBean prescriptionBean);

    List<DoctorBean> getAllDoc();

    List<DrugsBean> getAllDrugs();

    String getDrugNameById(String drugid);

    void updateDrugStatement(int recordId);
}

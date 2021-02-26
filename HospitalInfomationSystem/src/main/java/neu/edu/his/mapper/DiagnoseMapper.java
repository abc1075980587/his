package neu.edu.his.mapper;

import neu.edu.his.bean.MedicalRecordBean;
import neu.edu.his.bean.RegistrationBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiagnoseMapper {
    List<RegistrationBean> getDaiZhenList();

    List<RegistrationBean> getYiZhenList();

    void diagnose(MedicalRecordBean medicalRecordBean);

    void updateRegisList(int recordId);

}

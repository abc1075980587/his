package neu.edu.his.mapper;

import neu.edu.his.bean.MedicalRecordBean;
import neu.edu.his.bean.RegistrationBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegisterMapper {
    void register(RegistrationBean registrationBean);

    int getIncrementRecordId();
}

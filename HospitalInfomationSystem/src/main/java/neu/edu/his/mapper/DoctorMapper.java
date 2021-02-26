package neu.edu.his.mapper;

import neu.edu.his.bean.DoctorBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DoctorMapper {
    DoctorBean loginCheck(String loginID,String password);
}

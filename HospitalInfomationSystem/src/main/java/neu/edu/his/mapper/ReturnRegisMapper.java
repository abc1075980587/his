package neu.edu.his.mapper;

import neu.edu.his.bean.RegistrationBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReturnRegisMapper {

    List<RegistrationBean> getDaiZhen();

    void returnRegis(int regisID);
}

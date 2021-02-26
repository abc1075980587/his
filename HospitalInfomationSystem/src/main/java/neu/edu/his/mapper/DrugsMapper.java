package neu.edu.his.mapper;

import neu.edu.his.bean.PrescriptionBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DrugsMapper {
    List<PrescriptionBean> getPresList();

    void updateIsTaken(int regisId);
}

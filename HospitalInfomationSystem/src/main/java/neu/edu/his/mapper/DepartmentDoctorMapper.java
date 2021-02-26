package neu.edu.his.mapper;

import neu.edu.his.bean.DepartmentBean;
import neu.edu.his.bean.DoctorBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentDoctorMapper {
    List<DepartmentBean> getAllDepartments();
    List<DoctorBean> getDoctorByDept(int deptID);
}

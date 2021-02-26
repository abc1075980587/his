package neu.edu.his;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("neu.edu.his.mapper")
@SpringBootApplication
public class HisApplication {


    public static void main(String[] args) {
        SpringApplication.run(HisApplication.class, args);
    }

}

package tyut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("tyut.dao")
public class TmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

}

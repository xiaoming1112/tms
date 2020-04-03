package tyut;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tyut.dao.BaseDao;


@SpringBootTest
class TmsApplicationTests {
	@Autowired BaseDao baseDao;
	@Test
	void test_saveCourse() {

	}

}

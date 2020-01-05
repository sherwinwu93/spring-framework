package jdbc;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MySqlUtilTest {

	@Test
	public void update() {
		MySqlUtil.update("insert into `customer`(`name`, username) VALUES ('杨颖', ?)", "黄晓明");
	}

	@Test
	public void query() {
		List<Map<String, Object>> query = MySqlUtil.query("select * from customer");
		System.out.println(query);
	}
}
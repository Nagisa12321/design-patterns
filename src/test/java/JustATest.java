import org.junit.Test;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/15 18:42
 */
public class JustATest {
	@Test
	public void test1() {
		Connection conn;
	}

	@Test
	public void test2() {
		// 单例模式的一种体现
		ExecutorService executorService = Executors.newCachedThreadPool();
	}
}

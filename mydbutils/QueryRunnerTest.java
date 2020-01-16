package mydbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import utils.JDBCUtils;

public class QueryRunnerTest {

   // @Test
    public void testInsert() throws SQLException {
	QueryRunner runner = new QueryRunner();
	Connection conn = JDBCUtils.getConnection();
	String sql = "insert into `member`(`reg_name`, `pwd`, `mobile_phone`)values(?,?,?)";
	int insertCount = runner.update(conn, sql, "怪", "25D55AD283AA400AF464C76D713C07AD", "45444444");
	System.out.println("添加了" + insertCount + "条记录");
	JDBCUtils.close(conn);
    }
    @Test
    public void testQuery() throws SQLException {
	QueryRunner runner = new QueryRunner();
	Connection conn = JDBCUtils.getConnection();
	
	String sql = "select id,reg_name regName,pwd, mobile_phone mobilePhone, type, "
		+ "leave_amount leaveAmount, reg_time regTime"
		+ " from member where id = ?";
	String sql2 = "select id,reg_name regName,pwd, mobile_phone mobilePhone, type, "
		+ "leave_amount leaveAmount, reg_time regTime"
		+ " from member where id < ?";
	
	
	/*
	 * BeanHandler：是ResultSetHandler接口的实现类，用于封装表中的一条记录
	 */
	BeanHandler<Member> handler = new BeanHandler<Member>(Member.class);
	Member member = runner.query(conn, sql, handler, 70380);
	System.out.println(member);
	System.out.println("-------------------------1------------------------------");
	
	/*
	 * BeanListHandler：是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合
	 */
	BeanListHandler<Member> listHandler = new BeanListHandler<Member>(Member.class);
	List<Member> list = runner.query(conn, sql2, listHandler, 70391);
	list.forEach(System.out::print);
	System.out.println("-------------------------2------------------------------");
	/*
	 * MapHandler：是ResultSetHandler接口的实现类，对应表中的一条记录
	 * 将字段及相应的值作为map中的key和value
	 */
	MapHandler mapHandler = new MapHandler();
	Map<String, Object> map = runner.query(conn, sql, mapHandler, 70391);
	System.out.println(map);
	System.out.println("--------------------------3-----------------------------");
	/*
	 * MapListHandler：是ResultSetHandler接口的实现类，对应表中的多条记录
	 * 将字段及相应的值作为map中的key和value，将这些map添加到List中
	 */
	MapListHandler mapListHandler = new MapListHandler();
	List<Map<String, Object>> mapList = runner.query(conn, sql2, mapListHandler, 70391);
	mapList.forEach(System.out::println);
	System.out.println("--------------------------4-----------------------------");
	
	/*
	 * ScalarHandler：用于查询特殊值
	 */
	String sql3 = "select count(*) from member";
	String sql4 = "select max(reg_time) from member"; 
	ScalarHandler<Object> scalarHandler = new ScalarHandler<Object>();
	Long count = (Long) runner.query(conn, sql3, scalarHandler);
	System.out.println("member表共有" + count + "条记录");
	Timestamp query = (Timestamp) runner.query(conn, sql4, scalarHandler);
	System.out.println(query);
	
	JDBCUtils.close(conn);	
    }

}

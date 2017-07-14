package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.Reader;

/**
 * Created by kekai on 17/7/12.
 */
public class BaseMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("MapperConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (Exception e) {
        }
    }

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }


}

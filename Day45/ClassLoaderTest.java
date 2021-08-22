package Day45;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: ClassLoaderTest
 * @Description: 了解类的加载器
 * @Author: TianXing.Xue
 * @Date: 2021/8/10 9:50
 **/

public class ClassLoaderTest {
    @Test
    public void test1() {

        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);

        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader1 = classLoaderParent.getParent();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);

    }

    /*
    Properties：用来读取配置文件

     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //此时的配置文件默认在当前的module下
        //读取配置文件的方式一
        FileInputStream fis = new FileInputStream("src\\jjdbc.properties");
        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jjdbc.properties");
//        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("name = " + user + ",password = " + password);
    }
}

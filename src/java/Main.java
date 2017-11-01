/*
package java;
import java.sql.*;     //导入JDBC包
public class Main {
    public static void main(String[] args)
    {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名login
        String url = "jdbc:mysql://localhost:3306/johnnyCollege?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try
        {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //1.getConnection()方法，连接MySQL数据库！！创建连接对象
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from student";    //从建立的johnnyCollege数据库的student表单读取数据
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("学生编号" + "\t" + "学生姓名" +"\t"+ "学生性别" + "\t" + "学生年龄" + "\t" +"手机品牌");
            System.out.println("-----------------");
            String studentID = null;
            String studentName = null;
            String studentSex = null;
            String studentAge = null;
            String cellphoneBrand = null;
            while(rs.next())
            {
                //获取studentID这列数据
                studentID = rs.getString("studentID");
                //获取studentName这列数据
                studentName = rs.getString("studentName");
                studentSex = rs.getString("studentSex");
                studentAge = rs.getString("studentAge");
                cellphoneBrand = rs.getString("cellphoneBrand");

                //输出结果
                System.out.println(studentID + "\t" + studentName + "\t" + studentSex + "\t" + studentAge + "\t" +cellphoneBrand);

            }
            rs.close();
            con.close();
        }
        catch(ClassNotFoundException e)
        {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            //数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            System.out.println("数据库数据成功获取！！");
        }
    }

}
*/

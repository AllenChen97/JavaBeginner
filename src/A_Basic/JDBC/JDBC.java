package A_Basic.JDBC;

import java.sql.*;

/**
* Author: Jinzhao Chen
 * Last version: 3/3/2022
 * description: back-end developer can use directly
 * ps: be careful about the security of password and sql insertion
* */

public class JDBC {
    Connection con;
    PreparedStatement psSQL;

    public JDBC(String database, String user, String password) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://cs-db.ncl.ac.uk:3306/" + database, user, password);
        }catch(Exception e){ System.out.println(e);}
    }

    private void manipulate(String sql) throws SQLException  {
        psSQL = con.prepareStatement(sql);
        psSQL.executeUpdate();
    }

    private void selectAll() throws SQLException {
        selectAll("");
    }
    private void selectAll(String conditions) throws SQLException {
        psSQL = con.prepareStatement("select * from dim_staff" + conditions);
        ResultSet rs = psSQL.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("staffid");
            String name = rs.getString("name");
            String tel = rs.getString("tel");
            String job_title = rs.getString("job_title");
            int venue_id = rs.getInt("venue_id");

            System.out.println(id + " " + name + " " + tel + " " + job_title + " " + venue_id);
        }
    }

    private void getMeta(String sql) throws SQLException {
        /*
         * rs.getString/ Float/ Date/ Boolean/ Object 任意类型
         * rs.next()下一行
         * */
        psSQL = con.prepareStatement(sql);
        ResultSet rs = psSQL.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i));
            System.out.println();
        }
    }


    public static void main(String[] args) throws SQLException {
        JDBC jdbc = new JDBC("c0094835","c0094835","541236987s");
        try{
            System.out.println("\n<--------------- MetaData --------------->");
            jdbc.getMeta("select * from dim_staff");

            System.out.println("\n<--------------- Table Query --------------->");
            jdbc.selectAll();

            System.out.println("\n<--------------- 增 --------------->");
            jdbc.manipulate("INSERT INTO dim_staff (staffid,name,tel,job_title,venue_id) VALUES(10,'staff_z','12345678','manager',3)");
            jdbc.selectAll("where staffid = 10");

            System.out.println("\n<--------------- 改 --------------->");
            jdbc.manipulate("UPDATE dim_staff SET name = 'kenny' where staffid = '10'");
            jdbc.selectAll("where staffid = 10");

            System.out.println("\n<--------------- 删 --------------->");
            jdbc.manipulate("DELETE FROM dim_staff WHERE staffid = '10'");
            jdbc.selectAll("where staffid = 10");
        }
        catch(Exception e){ System.out.println(e);}
        finally {jdbc.con.close();}
    }
}

package application.MqttApplication;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectOpenServer {
	Connection con;
	Statement st;
	 String username = "root";
	 String password = "";
	 String URL = "jdbc:mysql://localhost:3306/mydb";	
	public SQLException connect() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			 con = DriverManager.getConnection(URL, username, password);
			 st = con.createStatement(); 
			System.out.println("database connection ok");
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("database connection ERROR");
			return e;
		}
	}
	
	public SQLException insertTable(String nameTable, String temp1, String temp2, String temp3, String temp4) {
		try {
			st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `bak_temp0` text, `bak_temp1` text, `bak_temp2` text, `bak_temp3` text);");
			st.execute("insert into "+nameTable+" ()values (null ,CURRENT_TIMESTAMP,'"+temp1+"','"+temp2+"','"+temp3+"','"+temp4+"' );");
			System.out.println("Дані успішно добавлені в таблицю");
			System.out.println();
			return null;
		}catch(SQLException e) {
			 System.out.println(e);
			 return e;
		}
	}
	
	public SQLException insertTable1(String nameTable, String temp1) {
		try {
			st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `bak_temp0` text);");
			st.execute("insert into "+nameTable+" ()values (null ,CURRENT_TIMESTAMP,'"+temp1+"' );");
			System.out.println("Дані успішно добавлені в таблицю");
			System.out.println();
			return null;
		}catch(SQLException e) {
			 System.out.println(e);
			 return e;
		}
	}
	
	public SQLException insertTable2(String nameTable, String temp1, String temp2) {
		try {
			
			//st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `kotel_gas` text, `kotel_drova` text, `vuluca` text, `2_powerx_bat_vx` text, `2_powerx_bat_vux` text);");
			st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `kotel_gas` text, `kotel_drova` text);");
			st.execute("insert into "+nameTable+" ()values (null ,CURRENT_TIMESTAMP,'"+temp1+"','"+temp2+"' );");			
			System.out.println("Дані успішно добавлені в таблицю");
			System.out.println();
			return null;
		}catch(SQLException e) {
			 System.out.println(e);
			 return e;
		}
	}
	
	
	public SQLException insertTable3(String nameTable, String temp1, String temp2, String temp3, String temp4) {
		try {
			
			//st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `kotel_gas` text, `kotel_drova` text, `vuluca` text, `2_powerx_bat_vx` text, `2_powerx_bat_vux` text);");
			st.execute("CREATE TABLE if not exists  "+nameTable+" (id int  AUTO_INCREMENT PRIMARY KEY, dat datetime DEFAULT CURRENT_TIMESTAMP, `podacha_do_boypasu` text, `kotel_vux` text, `podacha_pered_kotlom` text, `boypas` text );");
			st.execute("insert into "+nameTable+" ()values (null ,CURRENT_TIMESTAMP,'"+temp1+"','"+temp2+"','"+temp3+"','"+temp4+"' );");			
			System.out.println("Дані успішно добавлені в таблицю");
			System.out.println();
			return null;
		}catch(SQLException e) {
			 System.out.println(e);
			 return e;
		}
	}
	
	
	public SQLException disConnect(){
		try {
		con.close();
		st.close();
		return null;
		}catch(SQLException e) {
			return null;	
		}
	}
	
}

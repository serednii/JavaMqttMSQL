package application.MqttApplication;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class App  {
public static MqttAsyncClient myClient;
public static String username = "root";
public static String password = "";
public static String URL = "jdbc:mysql://localhost:3306/mydb";	


  public static void main(String[] args)  throws MqttException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException  {
	// ConnectOpenServer sq1 = new ConnectOpenServer();
	  
    System.out.println("Hello World!");
    myClient = new MqttAsyncClient("tcp://broker.hivemq.com:1883", UUID.randomUUID().toString());
    MyCallBack mk = new MyCallBack();
    mk.connect();
    
    //mk.disConnect();
    myClient.setCallback(mk);
    IMqttToken token = myClient.connect();
    token.waitForCompletion();
    myClient.subscribe("bak/temp0", 0);    
    myClient.subscribe("bak/temp1", 0);
    myClient.subscribe("bak/temp2", 0);
    myClient.subscribe("bak/temp3", 0);
    
   
    
    myClient.subscribe("kotelservo-0/temp1", 0); 
    myClient.subscribe("kotelservo-0/temp0", 0); 
    myClient.subscribe("2powerx/temp0", 0);    //подача до бойпасу
    myClient.subscribe("2powerx/temp1", 0);	 	// подача в котел
    myClient.subscribe("2powerx/temp2", 0);   //котел вихід
    myClient.subscribe("2powerx/temp3", 0);  // на бойпасі
    
   
  }

}

package application.MqttApplication;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MyCallBack   implements MqttCallback{
String tempx[] = new String[10];
String tempx1[] = new String[10];
ConnectOpenServer sq = new ConnectOpenServer();
static	int flagTemp=0;
static	int flagTemp1=0;
static	int flagTemp2=0;



	
	public MyCallBack() {
		
	}
	
	public void connect() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException  {		
		sq.connect();
		
	}
	public void disConnect() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {		
		sq.disConnect();
		
	}
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		//sq.insertTable1("temp_Outdoor", message.toString());
		
		
		
		//String top = topic.toString();
		String mes = message.toString();
		
		
		System.out.println(topic+"  " + mes);
		
		
		if(topic.compareTo("bak/temp0")==0) {
			tempx[0] = mes.replace('.', ',');
			flagTemp |= 1; 
			System.out.println("t1 "+flagTemp);
		}else if(topic.compareTo("bak/temp1")==0) {
			tempx[1] = mes.replace('.', ',');
			flagTemp |= 2; 
			System.out.println("t1 "+flagTemp);
		}else if(topic.compareTo("bak/temp2")==0) {			
			tempx[2] = mes.replace('.', ',');
			flagTemp |= 4; 
			System.out.println("t1 "+flagTemp);
		}else if(topic.compareTo("bak/temp3")==0) {
			tempx[3] = mes.replace('.', ',');
			flagTemp |= 8; 
			System.out.println("t1 "+flagTemp);
		}
			
		if(flagTemp == 15) {
			sq.insertTable("temp", tempx[0], tempx[1], tempx[2],tempx[3]);
			flagTemp=0;
			System.out.println("******************************");
		}
		
		//-----------------------------------------------------------------------------
		
		if(topic.compareTo("kotelservo-0/temp1")==0) {
			tempx1[0] = mes.replace('.', ',');
			flagTemp1 |= 1; 
			System.out.println("t1 "+flagTemp1);
		}else if(topic.compareTo("kotelservo-0/temp0")==0) {
			tempx1[1] = mes.replace('.', ',');
			flagTemp1 |= 2; 
			System.out.println("t1 "+flagTemp1);
		}
			 
		if(flagTemp1 == 0b11) {
			sq.insertTable2("Kotel_na_gaz_Mykola", tempx1[0], tempx1[1]);
			flagTemp1=0;
			System.out.println("******************************");
		}
		
		//-----------------------------------------------------------------------------
		
		 if(topic.compareTo("2powerx/temp0")==0) {
			tempx1[2] = mes.replace('.', ',');
			flagTemp2 |= 1; 
			System.out.println("t1 "+flagTemp2);
		}else if(topic.compareTo("2powerx/temp1")==0) {			
			tempx1[3] = mes.replace('.', ',');
			flagTemp2 |= 2; 
			System.out.println("t1 "+flagTemp2);
		}else if(topic.compareTo("2powerx/temp2")==0) {
			tempx1[4] = mes.replace('.', ',');
			flagTemp2 |= 4; 
			System.out.println("t1 "+flagTemp2);
		}else if(topic.compareTo("2powerx/temp3")==0) {
			tempx1[5] = mes.replace('.', ',');
			flagTemp2 |= 8; 
			System.out.println("t1 "+flagTemp2);
		}
			 
		if(flagTemp2 == 0b1111) {
			sq.insertTable3("kotel_Drova_Tato", tempx1[0], tempx1[1], tempx1[2],tempx1[3] );
			flagTemp2=0;
			System.out.println("******************************");
		}
		
		//-----------------------------------------------------------------------------
		
		
		
//		App.myClient.publish("bak/temp0", message.getPayload(), 0, false);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}
	
}

package com.test.ibmmq;

import java.io.File;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.commons.io.FileUtils;

import com.ibm.jms.JMSMessage;
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

/**
 * simple testcase for Point-to-point messaging .
 */
public class Connect_MQ {
	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MQQueueConnectionFactory cf = new MQQueueConnectionFactory();

			// Config
			cf.setHostName("BIEGE4CU08-cname.us.dell.com");
			cf.setPort(4208);
			cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
			cf.setQueueManager("BIEGE4CU08");
			cf.setChannel("BIE.BMI.01");

			File file = new File("mq1.xml");

			String str = FileUtils.readFileToString(file, "UTF-8");

			MQQueueConnection connection = (MQQueueConnection) cf.createQueueConnection();
			MQQueueSession session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			MQQueue queue = (MQQueue) session.createQueue("queue:///QA.BMI.POC.DELTA");
			MQQueueSender sender = (MQQueueSender) session.createSender(queue);
			// MQQueueReceiver receiver = (MQQueueReceiver) session.createReceiver(queue);

			JMSTextMessage message = (JMSTextMessage) session.createTextMessage(str);

			// Start the connection
			connection.start();

			sender.send(message);
			System.out.println("Sent message:\\n" + message);

			// JMSMessage receivedMessage = (JMSMessage) receiver.receive(10000);
			// System.out.println("\\nReceived message:\\n" + receivedMessage);

			sender.close();
			// receiver.close();
			session.close();
			connection.close();

			System.out.println("\\nSUCCESS\\n");
		} catch (JMSException jmsex) {
			System.out.println(jmsex);
			System.out.println("\\nFAILURE\\n");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("\\nFAILURE\\n");
		}
	}
}
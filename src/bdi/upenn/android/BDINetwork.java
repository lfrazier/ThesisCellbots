package bdi.upenn.android;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BDINetwork {
	public static void sendToServer(String messageStr) throws IOException {
		int messageSize = 184;
		int messageType = 501;
		int pid = 801;
		int seqNum = 1; // This will change later
		long timestamp = (long)System.currentTimeMillis() * 1000L; // Timestamp: 8 bytes
		
		byte[] buffer = new byte[messageSize];

		buffer[0] = (byte) ((messageSize >> 0*8) & 0xFF);
		buffer[1] = (byte) ((messageSize >> 1*8) & 0xFF);
		buffer[2] = (byte) ((messageSize >> 2*8) & 0xFF);
		buffer[3] = (byte) ((messageSize >> 3*8) & 0xFF);
		
		buffer[4] = (byte) ((messageType >> 0*8) & 0xFF);
		buffer[5] = (byte) ((messageType >> 1*8) & 0xFF);
		buffer[6] = (byte) ((messageType >> 2*8) & 0xFF);
		buffer[7] = (byte) ((messageType >> 3*8) & 0xFF);
		
		buffer[8] = (byte) ((pid >> 0*8) & 0xFF);
		buffer[9] = (byte) ((pid >> 1*8) & 0xFF);
		buffer[10] = (byte) ((pid >> 2*8) & 0xFF);
		buffer[11] = (byte) ((pid >> 3*8) & 0xFF);
		
		buffer[12] = (byte) ((seqNum >> 0*8) & 0xFF);
		buffer[13] = (byte) ((seqNum >> 1*8) & 0xFF);
		buffer[14] = (byte) ((seqNum >> 2*8) & 0xFF);
		buffer[15] = (byte) ((seqNum >> 3*8) & 0xFF);
		
		buffer[16] = (byte) ((timestamp >> 0*8) & 0xFFFF);
		buffer[17] = (byte) ((timestamp >> 1*8) & 0xFFFF);
		buffer[18] = (byte) ((timestamp >> 2*8) & 0xFFFF);
		buffer[19] = (byte) ((timestamp >> 3*8) & 0xFFFF);
		buffer[20] = (byte) ((timestamp >> 4*8) & 0xFFFF);
		buffer[21] = (byte) ((timestamp >> 5*8) & 0xFFFF);
		buffer[22] = (byte) ((timestamp >> 6*8) & 0xFFFF);
		buffer[23] = (byte) ((timestamp >> 7*8) & 0xFFFF);
		
		buffer[24] = (byte) ((timestamp >> 0*8) & 0xFF);
		buffer[25] = (byte) ((timestamp >> 1*8) & 0xFF);
		buffer[26] = (byte) ((timestamp >> 2*8) & 0xFF);
		buffer[27] = (byte) ((timestamp >> 3*8) & 0xFF);
		buffer[28] = (byte) ((timestamp >> 4*8) & 0xFF);
		buffer[29] = (byte) ((timestamp >> 5*8) & 0xFF);
		buffer[30] = (byte) ((timestamp >> 6*8) & 0xFF);
		buffer[31] = (byte) ((timestamp >> 7*8) & 0xFF);
		
		// Write 24 empty bytes
		for (int empty = 32; empty < 56; empty++) {
			buffer[empty] = 0;
		}

		// Write the message string
		byte[] stringBytes = messageStr.getBytes();
		for (int i = 0; i < stringBytes.length; i++) {
			buffer[56 + i] = stringBytes[i];
		}
		
		int server_port = 20000;
		InetAddress server_address = InetAddress.getByName("androidgestures.dyndns.org");
		
		DatagramSocket s = new DatagramSocket();
		DatagramPacket p = new DatagramPacket(buffer, buffer.length, server_address, server_port);
		s.send(p);	
		
		String sent = new String(p.getData(), 0, p.getLength());
		System.out.println("Sent Message: " + sent);
	}
}

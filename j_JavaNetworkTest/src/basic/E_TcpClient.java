package basic;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class E_TcpClient {
	public static void main(String[] args) throws Exception{
		String serverIp = "192.168.206.16"; 
		
		// 자기 자신 컴퓨터를 나타내는 방법
		// IP : 127.0.0.1
		// 호스트네임 : localhost
		
		System.out.println(serverIp + "서버에 접속 중 입니다");
		
		//소켓을 생성해서 서버에 연결을 요청한다
		//정상적으로 연결이 되어야 socket 객체가 생성이 된다
		Socket socket = new Socket(serverIp, 7777);
		
		//연결이 되면 이후의 명령이 실행된다
		System.out.println("연결 되었습니다");
		
		//서버에서 보내온 메시지 받기
		//메시지를 받기위해 InputStream 객체를 생성한다
		//Socket의 getInputStream()메서드 이용
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		//서버로부터 받은 메시지 출력하기
		System.out.println("받은 메시지 : " + dis.readUTF());
		
		System.out.println("연결 종료");
		
		dis.close();
		socket.close();
		
	}
}
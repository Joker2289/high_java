package basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_FileWriterTest {
	
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		//콘솔(표준 입출력장치)와 연결된 입력용 문자 Stream 생성
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null; //출력용 문자기반 Stream
		try {
			//파일 출력용 문자 Stream 객체 생성
			fw = new FileWriter("/Users/pjk/Documents/IO_test/testChar.txt");
			
			int c;
			
			System.out.println("아무거나 입력하세요");
			
			//콘솔에서 입력할 때 입력의 끝표시는 Ctrl + Z (키옵션창 EOF)키를 누르면 된다
			while((c = isr.read()) != -1) {
				fw.write(c); //콘솔에서 입력받은 값을 파일에 출력하기
			}
			System.out.println("작업 끝..");
			
			isr.close();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

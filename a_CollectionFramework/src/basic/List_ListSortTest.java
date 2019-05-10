package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable과 Comparator 이렇게 두가지가 있다
 * 
 * - 보통 객체 자체에 정렬 기능을 넣기 위해서는 Comparable	을 구현하고 밑의 예제처럼 정렬 기준을 별도로 구현하고 싶을 때는 Comparator를 구현하여 사용하면 된다
 * - Comparable 에서는 compareTo()메서드를 구현해야 하고
 * - Comparator 에서는 compare()매서드를 구현해야 한다
 */


public class List_ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매"); // add도 객체화 작업이다
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 > " + list);
		
		//정렬은 Collections.sort()메서드를 이용하여 정렬한다
		//정렬은 기본적으로 '오름차순 정렬'을 수행한다
		//정렬은 List에만 쓸 수 있다 > list만 순서개념이 있다
		//정렬방식을 변경하려면 정렬방식을 결졍하는 객체를 만들어서 Collections.sort()	메서드에 인수로 넘겨주면 된다
		
		Collections.sort(list); //오름차순으로 정렬 -- 파라미터 1개 정렬은 내부적으로 comparable 인터페이스 형식에 의해 정렬
		System.out.println("정렬 후 > " + list);
		
		Collections.shuffle(list); //데이터를 섞어준다
		System.out.println("자료 섞기 후 > " + list);
		
		//정렬방식을 결정하는 객체(Comparator)를 이용하여 정렬하기
		Collections.sort(list, new Desc()); // 정렬방식을 결정하여 정렬 -- 파라미터 2개 정렬은 Comparator 인터페이스 형식에 의해 정렬
		System.out.println("Comparator 정렬 후 > " + list);
	}

}

//정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야한다
//이 Comparator 인터페이스의 compare()라는 메서드를 오버라이딩 하여 구현하면 된다
class Desc implements Comparator<String>{
	/*
	 * compare() 메서드의 반환값을 결정하는 방법 > 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다
	 * 
	 * 오름차순 정렬 일경우 > 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환 하도록 한다.
	 * 
	 * String 객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데 이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다
	 * (Wrapper클래스와 Date, File클래스에도 구현되어 있다)
	 */
	
	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2) * -1; //내림차순 정렬 
	}
}

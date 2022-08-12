package users;

import java.util.ArrayList;
import java.util.List;

public class Home {
	public static void main(String[] args) {
		int x = 10; //테스트 중...
		// TODO Auto-generated method stub
		User 사용자1= new User();
		사용자1.사용자이름 = "유재석";
		사용자1.사용자연락처 = "010-3333";
		
		User 사용자2= new User();
		사용자2.사용자이름 = "박명수";
		사용자2.사용자연락처 = "010-4444";
		
		User 사용자3= new User();
		사용자3.사용자이름 = "정준하";
		사용자3.사용자연락처 = "010-5555";
		
		List<User> list = new ArrayList<User>();
		list.add(사용자1); //유재석 추가
		list.add(사용자2); //박명수 추가
		list.add(사용자3); //정준하 추가
		
		//문제 사용자 이름이 유재석이면 사용자 연락처를 010-7777로 수정
		
		User user = list.get(0); // 리턴타입이 User임
		System.out.println(user.사용자연락처);
		System.out.println(user.사용자이름);
		//박명수 이름, 연락처 호출
		User user2 = list.get(1); 
		System.out.println(user.사용자연락처);
		System.out.println(user.사용자이름);
		
		
		for(int i=0; i<list.size(); i++) {
			User u = list.get(i);
			String 찾는이름 = "유재석";
			if (u.사용자이름.equals(찾는이름)) {u.사용자연락처= "010-7777" ;}
			System.out.println("사용자 이름 : "+ u.사용자이름);
			System.out.println("사용자 연락처 : "+ u.사용자연락처);
		}
		
		
		
		
	}

}

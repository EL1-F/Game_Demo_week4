package Concrete;

import Abstract.MemberCheckService;
import Entities.Member;

public class MemberCheckManager implements MemberCheckService {

	@Override
	public boolean checkIfRealPerson(Member member) {
		
		return true;
	}

}

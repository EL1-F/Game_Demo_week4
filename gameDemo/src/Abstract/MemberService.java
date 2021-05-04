package Abstract;

import Entities.Game;
import Entities.Member;

public interface MemberService {

	void add(Member member);
	
	void update(Member member);
	
	void delete(String name, String lastname);
	
	void list();
	
	void addGame(Game game);
	
	void gameList(Member member);
}

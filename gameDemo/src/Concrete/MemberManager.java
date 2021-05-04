package Concrete;

import java.util.ArrayList;

import Abstract.MemberCheckService;
import Abstract.MemberService;
import Entities.Game;
import Entities.Member;

public class MemberManager implements MemberService{

	ArrayList<Member> members = new ArrayList<Member>();
	
	ArrayList<Game> playerGames = new ArrayList<Game>();
	
	MemberCheckService checkService;
	
	public MemberManager(MemberCheckService checkService) {
		this.checkService = checkService;
	}

	@Override
	public void add(Member member) {
		
		if(checkService.checkIfRealPerson(member)) {
			members.add(member);
			System.out.println("Hoþgeldiniz "+ member.getName());
		}else {
			System.out.println("Bilgilerin doðruluðu saðlanamadý.");
		}
		
		
	}

	@Override
	public void update(Member member) {
		
		for(Member player :members) {
			if(player.getId()==member.getId()) {
				player.setName(member.getName());
				player.setLastName(member.getLastName());
				player.setPassword(member.getPassword());
				System.out.println("Bilgileriniz baþarýyla güncellenmiþtir.");
			}
		}
		
	}

	@Override
	public void delete(String name, String lastname) {
		
		for(Member player:members) {
			if(player.getName()==name && player.getLastName()==lastname) {
				members.remove(player);
				System.out.println("Hesabýnýz silinmiþtir "+ player.getName());
			}
		}
		
		
	}
	
	
	@Override
	public void list() {
		
		for(Member player:members) {
			System.out.println(player.getId()+" id'li "+ player.getName()+" "+player.getLastName());
		}
	}
	
	@Override
	public void gameList(Member member) {
		
		
		System.out.println(member.getName()+" Mevcut Oyunlarý \n");
		for(Game play:playerGames) {
			System.out.println(play.getName());
		}
		
	}

	@Override
	public void addGame(Game game) {
		playerGames.add(game);
		System.out.println(game.getName()+" adlý oyun Eklendi."+"\n---------------------");
		
	}

}

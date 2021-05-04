package Concrete;

import java.util.ArrayList;

import Abstract.GameService;
import Abstract.MemberService;
import Entities.Game;
import Entities.Member;

public class GameManager implements GameService{
	
	private MemberService memberService;

	//public GameManager(MemberService memberService) {
	//	this.memberService = memberService;
	//}

	ArrayList<Game> games= new ArrayList<Game>();
	
	@Override
	public void add(Game game) {
		games.add(game);
		System.out.println("Oyun eklendi.."+game.getName());
		
	}

	@Override
	public void update(Game game) {
		for(Game play:games) {
			if(play.getGameId()==game.getGameId()) {
				play.setName(game.getName());
				play.setReleaseDate(game.getReleaseDate());
				play.setPrice(game.getPrice());
				System.out.println("Oyun baþarýyla güncellenmiþtir.\n " + 
				"Oyun Adý: " +play.getName()+"\nYayýn tarihi: "+play.getReleaseDate()+"\nFiyatý: "+play.getPrice());
			}
		}
		
	}

	@Override
	public void delete(int oyunId, String name) {
		for(Game game:games) {
			if(game.getName()==name && game.getGameId()==oyunId) {
				games.remove(game);
				System.out.println("Hesabýnýz silinmiþtir "+ game.getName());
			}
		}
		
	}

	@Override
	public void List() {
		for(Game game:games) {
			System.out.println(game.getName()+ "----------> Id: "+ game.getGameId());
		}
		
	}

	
	public void sell(MemberService memberService,Game game, Member member) {
		
		this.memberService=memberService;
		
		System.out.println("!!!! "+ member.getName()+" "+member.getLastName()+" adlý oyuncu "+ 
		game.getName()+ " adlý oyunu satýn aldý." );
		this.memberService.addGame(game);
		
		
	}

}

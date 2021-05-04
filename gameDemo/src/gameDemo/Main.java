package gameDemo;

import java.time.LocalDate;

import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.MemberCheckManager;
import Concrete.MemberManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Member;

public class Main {

	public static void main(String[] args) {
		
		MemberManager memberManager = new MemberManager(new MemberCheckManager());
		Member member1=new Member(1,"elif","ipek",LocalDate.of(1993, 1, 5),"20345413561","123123");
		memberManager.add(member1);
		Member member2 =new Member(2,"tarýk","tengri",LocalDate.of(1989, 4, 29),"20345413561","123123");
		memberManager.add(member2);
		memberManager.update(new Member(1,"eliffff","ipek",LocalDate.of(1993, 1, 5),"20345413561","123123"));
		
		memberManager.list();
		memberManager.delete("eliffff","ipek");
		memberManager.list();
		
		System.out.println("------------------------------");
		
		GameManager gameManager = new GameManager();
		Game game1= new Game(1,"RPG",LocalDate.of(2021,3,5),45.00);
		Game game2= new Game(2,"shooting",LocalDate.of(2021,3,6),45.00);
		gameManager.add(game1);
		gameManager.add(game2);
		
		System.out.println("------------------------------");
		
		gameManager.sell(memberManager,game1, member1);
		gameManager.sell(memberManager,game2, member1);
		memberManager.gameList(member1);
		
		System.out.println("\n------------------------------");
		
		CampaignManager campaignManager = new CampaignManager();
		Campaign campaign1= new Campaign(1,"Yaz Tatili!!",20);
		campaignManager.add(campaign1);
		campaignManager.selectCampaign(gameManager, campaign1, game2);
		
		System.out.println("\n------------------------------");
		gameManager.List();
		
		
		
		

	}

}

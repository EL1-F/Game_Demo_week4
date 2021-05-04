package Concrete;

import java.util.ArrayList;

import Abstract.CampaignService;
import Abstract.GameService;
import Entities.Campaign;
import Entities.Game;

public class CampaignManager implements CampaignService {

	ArrayList<Campaign> campaigns = new ArrayList<Campaign>();
	
	private GameService gameService;
	
	@Override
	public void add(Campaign campaign) {
		campaigns.add(campaign);
		System.out.println(campaign.getCampaignName()+" eklendi");
		
	}

	@Override
	public void update(Campaign campaign) {
		for(Campaign camp :campaigns) {
			if(camp.getCampaignId()==campaign.getCampaignId()) {
				camp.setCampaignName(campaign.getCampaignName());
				camp.setDiscount(campaign.getDiscount());
				System.out.println("Kampanya bilgileri baþarýyla güncellenmiþtir.");
			}
		}
		
	}

	@Override
	public void delete(int campaignId, String name) {
		for(Campaign camp :campaigns) {
			if(camp.getCampaignName()==name && camp.getCampaignId()==campaignId) {
				campaigns.remove(camp);
				System.out.println("Kampanya silinmiþtir "+ camp.getCampaignName());
			}
		}
		
	}

	@Override
	public void list() {
		
		for(Campaign camp :campaigns) {
			System.out.println("Kampanyalar\n-------------\n"+ camp.getCampaignId()+
					"-------> "+camp.getCampaignName());
		}
		
	}
	
	public void selectCampaign(GameService gameService,Campaign campaign, Game game) {
		
		this.gameService=gameService;
		
		game.setPrice(game.getPrice()-(game.getPrice()*(campaign.getDiscount()/100)));
		System.out.println(campaign.getCampaignName()+" adlý kampanya uygulanmýþtýr.");
		gameService.update(game);
	}

}

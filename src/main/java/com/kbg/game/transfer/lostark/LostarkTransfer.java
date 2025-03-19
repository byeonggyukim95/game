package com.kbg.game.transfer.lostark;

import com.kbg.game.model.lostark.news.News;
import com.kbg.game.model.lostark.auctions.AuctionItem;
import com.kbg.game.model.lostark.auctions.req.AuctionsItemsReq;
import com.kbg.game.model.lostark.news.req.NewsReq;

import java.util.List;

public interface LostarkTransfer {

    List<News> getNewsList(NewsReq newsReq) throws Exception;
    
    List<AuctionItem> getAuctionsItemList(AuctionsItemsReq auctionsItemsReq) throws Exception;

}

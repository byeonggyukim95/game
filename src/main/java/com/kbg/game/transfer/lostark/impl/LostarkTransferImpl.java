package com.kbg.game.transfer.lostark.impl;

import com.kbg.game.model.LostarkApi;
import com.kbg.game.model.lostark.news.News;
import com.kbg.game.model.lostark.auctions.AuctionItem;
import com.kbg.game.model.lostark.auctions.req.AuctionsItemsReq;
import com.kbg.game.model.lostark.news.req.NewsReq;
import com.kbg.game.transfer.lostark.LostarkTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class LostarkTransferImpl implements LostarkTransfer {

    private WebClient webClient;

    @Autowired
    public LostarkTransferImpl(WebClient.Builder builder
            , LostarkApi lostarkApi) {
        this.webClient = builder.baseUrl(lostarkApi.getUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, new StringBuffer("bearer ").append(lostarkApi.getApiKey()).toString())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public List<News> getNewsList(NewsReq newsReq) {
        StringBuffer url = new StringBuffer("/news/notices?");

        if (!newsReq.getSearchText().isEmpty()) {
            url.append("searchText=").append(newsReq.getSearchText());
        }

        if (!newsReq.getType().isEmpty()) {
            url.append("type=").append(Base64.getEncoder().encodeToString(newsReq.getType().getBytes()));
        }

        Mono<List<News>> response = webClient.get()
                .uri(url.toString())
                .retrieve()
                .bodyToFlux(News.class)
                .collectList();

        return response.block();
    }

    @Override
    public List<AuctionItem> getAuctionsItemList(AuctionsItemsReq auctionsItemsReq) throws Exception {
        Mono<List<AuctionItem>> response = webClient.post()
                .uri("/auctions/items")
                .body(auctionsItemsReq, AuctionsItemsReq.class)
                .retrieve()
                .bodyToFlux(AuctionItem.class)
                .collectList();

        return response.block();
    }


}

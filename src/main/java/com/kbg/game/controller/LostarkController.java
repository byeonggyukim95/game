package com.kbg.game.controller;

import com.kbg.game.model.lostark.req.CharacterClassCriticalReq;
import com.kbg.game.model.lostark.resp.CharacterClassCriticalResp;
import com.kbg.game.model.lostark.news.News;
import com.kbg.game.model.lostark.auctions.AuctionItem;
import com.kbg.game.model.lostark.auctions.req.AuctionsItemsReq;
import com.kbg.game.model.lostark.news.req.NewsReq;
import com.kbg.game.service.lostark.LostarkService;
import com.kbg.game.transfer.lostark.LostarkTransfer;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lostark")
@Slf4j
public class LostarkController {

    private LostarkTransfer lostarkTransfer;
    private LostarkService lostarkService;

    @Autowired
    public LostarkController(LostarkTransfer lostarkTransfer
            , LostarkService lostarkService) {
        this.lostarkTransfer = lostarkTransfer;
        this.lostarkService = lostarkService;
    }

    @GetMapping("/news/list")
    public List<News> getNewsList(@ModelAttribute @Valid NewsReq newsReq) throws Exception {
        return lostarkTransfer.getNewsList(newsReq)
                .stream()
                .limit(newsReq.getSize())
                .collect(Collectors.toList());
    }

    @PostMapping("/auctions/items")
    public List<AuctionItem> getAuctionsItems(@RequestBody AuctionsItemsReq auctionsItemsReq) throws Exception {
        return lostarkTransfer.getAuctionsItemList(auctionsItemsReq);
    }

    @PostMapping("/critical")
    public void setCharacterClassCritical(@RequestBody @Valid CharacterClassCriticalReq characterClassCriticalReq) throws Exception {
        lostarkService.insertCharacterClassCritical(characterClassCriticalReq);
    }

    @GetMapping("/critical/calculator")
    public List<CharacterClassCriticalResp> getCriticalCalculator(@RequestParam("characterClass") String characterClass) throws Exception {
        return lostarkService.getCriticalCalculator(characterClass);
    }

}
package org.example.shorturl.controller;

import lombok.RequiredArgsConstructor;
import org.example.shorturl.facade.RedissonLockFacade;
import org.example.shorturl.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
@RequiredArgsConstructor
public class RedirectController {

    private final RedissonLockFacade redissonLockFacade;

    /**
     * ShortURL 접속
     */
    @GetMapping("/{shortUrl}")
    public String redirectShortUrl(@PathVariable String shortUrl) {
        String redirectShortUrl = redissonLockFacade.redirectShortUrl(shortUrl);

        return "redirect:" + redirectShortUrl;
    }
}

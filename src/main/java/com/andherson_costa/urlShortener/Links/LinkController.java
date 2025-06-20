package com.andherson_costa.urlShortener.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping({"/", "/home"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Home Page", HttpStatus.OK);
    }

//    @GetMapping("/url-short-list")
//    public ResponseEntity<String> urlShortList() throws IOException{
//        return
//    }
    @GetMapping("/url-list-short")
    @ResponseBody
    public  List<Link> urlListShort() {
//        List<Link> links = linkService.getAllUrl();
//        return links.toString();
        return linkService.getAllUrl();
    }

    @PostMapping("/url-shortener")
    public ResponseEntity<LinkResponse> shortenerUrl(@RequestBody Map<String, String> request){

        String originalUrl = request.get("originalUrl");

        Link link = linkService.shortenUrl(originalUrl);

        String generateRedirectUser = "http://localhost:8080/r/" + link.getUrlShort();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLong(),
                generateRedirectUser,
                link.getUrlQrCode(),
                link.getCreatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{shortenUrl}")
    public void redirectLink(@PathVariable String shortenUrl, HttpServletResponse response) throws IOException {

        Link link = linkService.getOriginalUrl(shortenUrl);

        if(link != null){
            response.sendRedirect(link.getUrlLong());
            System.out.println("Redirecting to: " + link.getUrlLong());
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

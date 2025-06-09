package com.andherson_costa.urlShortener.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LinkService {

    // Salvar no banco de dados
    // Indexar a url aleatoria
    // Quando a url encurtada aleatoria seja acessada, redirecione para a url original

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // TODO: REFATORAR PARA INCLUIR PARTE DA URL ORIGINAL NO NOSSO ALGORITIMO DE GERAR URL
    // Gerar uma url aleatoria
    public String generateRandomUrl(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link shortenUrl(String urlLong){

        Link link = new Link();
        link.setUrlLong(urlLong);
        link.setUrlShort(generateRandomUrl());
        link.setCreatedAt(LocalDateTime.now());
        link.setUrlQrCode("QR CODE Indisponível no momento");

        return linkRepository.save(link);
    }

//    public Link getOriginalUrl(String shortenUrl) {
//        return linkRepository.findByUrlShort(shortenUrl);
//    }

    public Link getOriginalUrl(String shortenUrl){

        try {
            return linkRepository.findByUrlShort(shortenUrl);
        } catch (Exception erro) {
            throw  new RuntimeException("URL não existe nos nossos registros", erro);
        }
    }
    //        return linkRepository.findByUrlLong(shortenUrl)
//                .orElseThrow(() -> new RuntimeException("URL não existe nos nossos registros"));


    public List<Link> getAllUrl(){
        return linkRepository.findAll();
    }

//    public Link findAll(Link link) {
//        return linkRepository.findAll();
//    }
}

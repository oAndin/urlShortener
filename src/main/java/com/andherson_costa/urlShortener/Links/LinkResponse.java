package com.andherson_costa.urlShortener.Links;

import java.time.LocalDateTime;

public class LinkResponse {

    private Long id;
    private String urlLong;
    private String urlShort;
    private String urlQrCode;
    private LocalDateTime createdAt;

    public LinkResponse() {
    }

    public LinkResponse(Long id, String urlLong, String urlShort, String urlQrCode, LocalDateTime createdAt) {
        this.id = id;
        this.urlLong = urlLong;
        this.urlShort = urlShort;
        this.urlQrCode = urlQrCode;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

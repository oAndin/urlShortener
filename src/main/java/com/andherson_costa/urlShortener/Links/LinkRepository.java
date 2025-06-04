package com.andherson_costa.urlShortener.Links;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByUrlLong(String urlLong);

    Link findByUrlShort(String urlShort);
}

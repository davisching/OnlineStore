package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.Carousel;

import java.util.List;

public interface CarouselDao extends JpaRepository<Carousel, String> {
    List<Carousel> findByIsShowOrderBySort(long isShow);
}

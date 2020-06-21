package pers.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.Carousel;
import pers.dc.dao.CarouselDao;
import pers.dc.service.CarouselService;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    final CarouselDao carouselDao;

    public CarouselServiceImpl(CarouselDao carouselDao) {
        this.carouselDao = carouselDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> getAll() {
        return carouselDao.findByIsShowOrderBySort(1);
    }
}

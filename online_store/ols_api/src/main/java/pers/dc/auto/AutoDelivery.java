package pers.dc.auto;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.dc.service.OrderService;

@Component
public class AutoDelivery {

    final OrderService orderService;

    public AutoDelivery(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "0 */3 * * * ?")
    public void autoDeliver() {
        orderService.deliveryReceived();
    }
}

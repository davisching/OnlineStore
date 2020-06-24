package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import pers.dc.bean.*;
import pers.dc.bean.bo.OrderBO;
import pers.dc.dao.*;
import pers.dc.enums.OrderStatusEnum;
import pers.dc.service.OrderService;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    final OrderDao orderDao;
    final AddressDao addressDao;
    final ItemSpecDao itemSpecDao;
    final ItemImgDao itemImgDao;
    final ItemDao itemDao;
    final OrderItemsDao orderItemsDao;
    final OrderStatusDao orderStatusDao;

    public OrderServiceImpl(OrderDao orderDao, AddressDao addressDao, ItemSpecDao itemSpecDao, ItemImgDao itemImgDao, ItemDao itemDao, OrderItemsDao orderItemsDao, OrderStatusDao orderStatusDao) {
        this.orderDao = orderDao;
        this.addressDao = addressDao;
        this.itemSpecDao = itemSpecDao;
        this.itemImgDao = itemImgDao;
        this.itemDao = itemDao;
        this.orderItemsDao = orderItemsDao;
        this.orderStatusDao = orderStatusDao;
    }


    @Override
    public String createOrder(OrderBO orderBO) {
        Orders order = new Orders();
        String orderId = UUID.randomUUID().toString();
        order.setId(orderId);
        order.setUserId(orderBO.getUserId());
        UserAddress address = addressDao.getOne(orderBO.getAddressId());
        order.setReceiverName(address.getReceiver());
        order.setReceiverMobile(address.getMobile());
        StringBuilder addressStr = new StringBuilder();
        addressStr.append(address.getProvince())
                .append(address.getDistrict())
                .append(address.getCity())
                .append(address.getDetail());
        order.setReceiverAddress(addressStr.toString());
        String specIds = orderBO.getItemSpecIds();
        long totalAmount = 0, realPayAmount = 0, postAmount = 0;

        for (String spec : specIds.split(",")) {
            // TODO 之後用 redis 時會從緩存中獲取數量， 現在都寫1
            int amount = 1;
            ItemsSpec itemsSpec = itemSpecDao.getOne(spec);
            totalAmount += itemsSpec.getPriceNormal() * amount;
            realPayAmount += itemsSpec.getPriceDiscount() * amount;

            OrderItems orderItems = new OrderItems();
            orderItems.setId(UUID.randomUUID().toString());
            orderItems.setOrderId(orderId);
            orderItems.setItemId(itemsSpec.getItemId());
            orderItems.setItemImg(itemImgDao.findByItemIdAndIsMain(itemsSpec.getItemId(), 1).getUrl());
            orderItems.setItemName(itemDao.findOneById(itemsSpec.getItemId()).getItemName());
            orderItems.setItemSpecId(itemsSpec.getId());
            orderItems.setItemSpecName(itemsSpec.getName());
            orderItems.setPrice(itemsSpec.getPriceDiscount());
            orderItems.setBuyCounts(amount);

            orderItemsDao.save(orderItems);

            // TODO 以後用分布式鎖處理
            long offset = itemsSpec.getStock()-amount;
            if (offset < 0)
                throw new UnsupportedOperationException();
            itemsSpec.setStock(offset);
            itemsSpec.setUpdatedTime(new Date());
            itemSpecDao.save(itemsSpec);
        }
        order.setTotalAmount(totalAmount);
        order.setRealPayAmount(realPayAmount);
        order.setPostAmount(postAmount);
        order.setPayMethod(orderBO.getPayMethod());
        order.setLeftMsg(orderBO.getLeftMsg());
        order.setIsComment(0);
        order.setIsDelete(0);
        order.setCreatedTime(new Date());
        order.setUpdatedTime(new Date());

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orderId);
        orderStatus.setOrderStatus(OrderStatusEnum.PAID.getValue());
        orderStatus.setCreatedTime(new Date());
        orderStatusDao.save(orderStatus);

        orderDao.save(order);

        return orderId;
    }
}

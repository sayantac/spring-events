package com.linkedin.events.promotion;

import com.linkedin.events.customer.CustomerRegisteredEvent;
import com.linkedin.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionListeners {

    private final PromotionService promotionService;
    @EventListener(condition = "#event.customer.newsletter")
    public void onRegisteredEvent(CustomerRegisteredEvent event){
        promotionService.applyPromotion(event.getCustomer());
    }
    @EventListener
    public void onOrderCompleted(OrderCompletedEvent event){
        promotionService.calculateRewardPoints(event.getOrder());
    }
}

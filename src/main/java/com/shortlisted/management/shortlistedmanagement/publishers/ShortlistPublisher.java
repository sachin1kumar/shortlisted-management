package com.shortlisted.management.shortlistedmanagement.publishers;

import com.shortlisted.management.shortlistedmanagement.messaging.MessagingConfig;
import com.shortlisted.management.shortlistedmanagement.entities.ShortlistDetails;
import com.shortlisted.management.shortlistedmanagement.entities.ShortlistedStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/shortlist")
public class ShortlistPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/book")
    public ShortlistedStatus addBookToShorList(@RequestBody ShortlistDetails shortlistDetails) {
        ShortlistedStatus shortlistedStatus = new ShortlistedStatus("Shortlisted Successfully!");
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, shortlistDetails);
        return shortlistedStatus;
    }
}

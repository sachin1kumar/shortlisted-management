package com.shortlisted.management.shortlistedmanagement.publishers;

import com.shortlisted.management.shortlistedmanagement.entities.ShortlistDetails;
import com.shortlisted.management.shortlistedmanagement.entities.ShortlistedStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shortlist")
public class ShortlistPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.addShortListedRoutingKey}")
    private String addShortListedRoutingKey;

    @Value("${spring.rabbitmq.removeShortListedRoutingKey}")
    private String removeShortListedRoutingKey;

    @PostMapping("/book")
    public ShortlistedStatus addBookToShorList(@RequestBody ShortlistDetails shortlistDetails) {
        ShortlistedStatus shortlistedStatus = new ShortlistedStatus("Shortlisted Successfully!");
        rabbitTemplate.convertAndSend(exchange, addShortListedRoutingKey, shortlistDetails);
        return shortlistedStatus;
    }

    @DeleteMapping("/removeBook/{shortlistedId}")
    public ShortlistedStatus removeBookFromShorList(@PathVariable Long shortlistedId) {
        ShortlistedStatus shortlistedStatus = new ShortlistedStatus("Deleted Successfully!");
        rabbitTemplate.convertAndSend(exchange, removeShortListedRoutingKey, shortlistedId);
        return shortlistedStatus;
    }
}

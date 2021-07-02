package com.shortlisted.management.shortlistedmanagement.proxy;

import com.shortlisted.management.shortlistedmanagement.entities.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "books-management")
public interface BookManagementProxy {

    @GetMapping("/getShortlistedBooks/{userId}")
    List<Books> retrieveExchangeValue(@PathVariable Long userId);
}

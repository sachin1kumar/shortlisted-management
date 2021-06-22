package com.shortlisted.management.shortlistedmanagement.entities;

public class ShortlistDetails {

    private Long userId;
    private Long bookId;

    public ShortlistDetails() {

    }

    public ShortlistDetails(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}

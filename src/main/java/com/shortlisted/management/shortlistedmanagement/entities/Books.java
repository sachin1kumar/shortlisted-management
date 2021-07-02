package com.shortlisted.management.shortlistedmanagement.entities;

public final class Books {

    private final Long bookId;

    private final Long titleId;

    private final Long authorId;

    private final Long publisherId;

    private final String description;

    private final Double price;

    public Books(Long bookId, Long titleId, Long authorId, Long publisherId, String description, Double price) {
        this.bookId = bookId;
        this.titleId = titleId;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.description = description;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}

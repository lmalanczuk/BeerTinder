package com.bt.beertinder.dto;

public class SwipeRequest {
    private Long userId;
    private Long beerId;
    private boolean liked;

    public SwipeRequest() {}

    public SwipeRequest(Long userId, Long beerId, boolean liked) {
        this.userId = userId;
        this.beerId = beerId;
        this.liked = liked;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBeerId() {
        return beerId;
    }

    public boolean isLiked() {
        return liked;
    }
}


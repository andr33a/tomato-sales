package com.tomato.tomatosalesanalysis.domain;

import java.util.UUID;

public class SaleInfo {

    private final UUID id;
    private final int size;
    private final String provider;
    private final Long date;

    public SaleInfo(UUID id, int size, String provider, Long date) {
        this.id = id;
        this.size = size;
        this.provider = provider;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public String getProvider() {
        return provider;
    }

    public Long getDate() {
        return date;
    }
}

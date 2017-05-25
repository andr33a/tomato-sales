package com.tomato.tomatosalesanalysis.domain;


import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class SaleInfoGenerator implements ISaleInfoGenerator{

    private static final int MIN = 1;
    private static final int MAX = 2000;
    private static final String[] PROVIDERS = {"Del Monte", "Heinz", "Le Ol' Granma", "Hunt's"};

    public List<SaleInfo> retrieveData(int size){
        LinkedList<SaleInfo> saleInfoList = new LinkedList<>();
        for (int i = 0; i < size; i++){
            int sales = generateSalesSize();
            SaleInfo info = new SaleInfo(generateUUID(), sales, pickProvider(sales), generateSalesDate());
            saleInfoList.add(info);
        }

        saleInfoList.sort(Comparator.comparing(SaleInfo::getDate));
        return saleInfoList;
    }

    private long generateSalesDate(){
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.withMonth(1).withDayOfMonth(1);

        long offset = Timestamp.valueOf(startTime).getTime();
        long end = Timestamp.valueOf(endTime).getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp.getTime();
    }

    private String pickProvider(int sales){
        int index = sales % PROVIDERS.length;
        return PROVIDERS[index];
    }

    private int generateSalesSize(){
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }

    private UUID generateUUID(){
        return UUID.randomUUID();
    }
}

package com.tomato.tomatosalesanalysis.controllers;

import com.tomato.tomatosalesanalysis.domain.ISaleInfoGenerator;
import com.tomato.tomatosalesanalysis.domain.SaleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TomatoSalesController {

    @Autowired
    ISaleInfoGenerator saleInfoGenerator;

    @RequestMapping("/sales/data")
    public List<SaleInfo> getSalesData(@RequestParam(name="size", required = false, defaultValue = "3") int size){
        return saleInfoGenerator.retrieveData(size);
    }
}

package com.tomato.tomatosalesanalysis.domain;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class SalesInfoGeneratorTest {

    @Tested
    public SaleInfoGenerator saleInfoGenerator;

    @Test
    public void SaleInfoGeneratorGeneratesCorrectNumberOfEntries(){
        int size = 3;
        List<SaleInfo> saleInfoList = saleInfoGenerator.retrieveData(size);

        assertEquals(size, saleInfoList.size());
    }
}

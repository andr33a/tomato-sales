package com.tomato.tomatosalesanalysis.domain;

import java.util.List;

public interface ISaleInfoGenerator {
    List<SaleInfo> retrieveData(int size);
}

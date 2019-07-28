package com.agileengine.search.chine.impl;

import com.agileengine.search.chine.SearchChinePart;

import org.jsoup.select.Elements;

public class AClassSuccessSearchChainPart extends SearchChinePart {

    private static final String A_CLASS_SUCCESS_QUERY = "a[class*=\"success\"]";

    @Override
    public Elements tryFindElements(String path) {
        return findElementsByQuery(path, A_CLASS_SUCCESS_QUERY);
    }
}

package com.agileengine.search.impl;

import com.agileengine.search.SearchEngine;
import com.agileengine.search.chine.SearchChinePart;
import com.agileengine.search.chine.impl.AClassSuccessSearchChainPart;
import com.agileengine.search.chine.impl.ATitleMakeSearchChinePart;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 *
 * @author Stanislav_Vorozhka
 */
public class SearchEngineImpl implements SearchEngine {

    @Override
    public Optional<Element> searchElement(String path) {
        List<SearchChinePart> searchChineParts = Arrays.asList(
            new AClassSuccessSearchChainPart(),
            new ATitleMakeSearchChinePart(),
            new AClassSuccessSearchChainPart());

        Optional<Elements> mostCompatibleElements = searchChineParts.stream()
            .map(chine -> chine.tryFindElements(path))
            .min(Comparator.comparingInt(List::size));

        return mostCompatibleElements.map(Elements::first);
    }
}

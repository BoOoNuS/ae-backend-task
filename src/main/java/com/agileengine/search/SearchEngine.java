package com.agileengine.search;

import org.jsoup.nodes.Element;

import java.util.Optional;

/**
 * Helps to find specific element.
 *
 * @author Stanislav_Vorozhka
 */
public interface SearchEngine {

    Optional<Element> searchElement(String path);
}

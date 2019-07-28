package com.agileengine.parser;

import org.jsoup.nodes.Element;

import java.util.Optional;

/**
 * Helps to get information from element.
 *
 * @author Stanislav_Vorozhka
 */
public interface ElementPathParser {

    /**
     * Gets full path to the specified element.
     *
     * @param element the found element
     * @return full path to input element
     */
    String getFullPath(Optional<Element> element);
}

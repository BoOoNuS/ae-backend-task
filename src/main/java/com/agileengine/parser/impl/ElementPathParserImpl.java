package com.agileengine.parser.impl;

import com.agileengine.parser.ElementPathParser;

import org.jsoup.nodes.Element;

import java.util.Optional;

/**
 * {@inheritDoc}
 *
 * @author Stanislav_Vorozhka
 */
public class ElementPathParserImpl implements ElementPathParser {

    private static final String PATH_SEPARATOR = " > ";

    @Override
    public String getFullPath(Optional<Element> element) {
        Element child = element.orElseThrow(() -> new IllegalArgumentException("element - cannot be null"));
        StringBuilder fullPath = new StringBuilder(child.tagName());


        for (Element parent : child.parents()) {
            fullPath.insert(0, getPathPart(child, parent));
            child = parent;
        }

        return fullPath.toString();
    }

    /**
     * Gets path part between parent and child.
     *
     * @param child  the specified current child of the parent
     * @param parent the specified parent
     * @return path part between the parent and the child
     */
    private String getPathPart(Element child, Element parent) {
        if (parent.children().size() > 1) {
            for (int i = 0; i < parent.childNodeSize(); i++) {
                if (parent.child(i).attributes().equals(child.attributes())) {
                    return parent.tagName() + "[" + i + "]" + PATH_SEPARATOR;
                }
            }
        } else if (parent.children().size() == 1) {
            return parent.tagName() + PATH_SEPARATOR;
        }
        return parent.tagName();
    }
}

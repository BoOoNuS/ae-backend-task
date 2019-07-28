package com.agileengine.search.chine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public abstract class SearchChinePart {

    private static Logger LOGGER = LoggerFactory.getLogger(SearchChinePart.class);

    private static String CHARSET_NAME = "utf8";

    public abstract Elements tryFindElements(String path);

    protected Elements findElementsByQuery(String strPath, String query) {
        File path = new File(strPath);
        try {
            Document doc = Jsoup.parse(
                path,
                CHARSET_NAME,
                path.getAbsolutePath());

            return doc.select(query);

        } catch (IOException e) {
            LOGGER.warn("Error reading [{}] file", path.getAbsolutePath(), e);
            throw new IllegalArgumentException("Cannot read from by specified path: " + path.getAbsolutePath());
        }
    }
}

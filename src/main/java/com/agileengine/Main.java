package com.agileengine;

import com.agileengine.output.ResultWriter;
import com.agileengine.output.impl.ResultWriterImpl;
import com.agileengine.parser.impl.ElementPathParserImpl;
import com.agileengine.search.impl.SearchEngineImpl;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * The entry point of the program.
 *
 * @author Stanislav_Vorozhka
 */
public class Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Runs the program.
     * Must be specified two arguments: inputFilePath, outputFilePath
     *
     * @param args the args, two of these are mandatory
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            LOGGER.warn("Must be specified two input parameters: inputFilePath, outputFilePath");
            throw new IllegalArgumentException("Must be specified two input parameters: inputFilePath, outputFilePath");
        }
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        SearchEngineImpl searchEngine = new SearchEngineImpl();
        Optional<Element> makeBtn = searchEngine.searchElement(inputFilePath);

        ElementPathParserImpl elementPathParserImpl = new ElementPathParserImpl();
        String makeBtnFullPath = elementPathParserImpl.getFullPath(makeBtn);

        ResultWriter resultWriterImpl = new ResultWriterImpl();
        resultWriterImpl.write(outputFilePath, makeBtnFullPath);
    }
}

package com.agileengine.output.impl;

import com.agileengine.output.ResultWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

/**
 * {@inheritDoc}
 *
 * @author Stanislav_Vorozhka
 */
public class ResultWriterImpl implements ResultWriter {

    private static Logger LOGGER = LoggerFactory.getLogger(ResultWriterImpl.class);

    @Override
    public void write(String path, String result) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(result);
        } catch (IOException e) {
            LOGGER.warn(e.getLocalizedMessage(), e);
        }
    }
}

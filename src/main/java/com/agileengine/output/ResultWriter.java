package com.agileengine.output;

/**
 * Helps to make output.
 *
 * @author Stanislav_Vorozhka
 */
public interface ResultWriter {

    /**
     * Writes the result by specified path.
     *
     * @param path   the path to output (result) file
     * @param result result which going to be written
     */
    void write(String path, String result);
}
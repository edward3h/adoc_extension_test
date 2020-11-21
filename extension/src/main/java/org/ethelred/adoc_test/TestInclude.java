package org.ethelred.adoc_test;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.IncludeProcessor;
import org.asciidoctor.extension.PreprocessorReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * TODO
 *
 * @author eharman
 * @since 2020-11-21
 */
public class TestInclude extends IncludeProcessor
{
    @Override
    public boolean handles(String target)
    {
        // TODO
        return true;
    }

    @Override
    public void process(Document document, PreprocessorReader reader, String target, Map<String, Object> attributes)
    {
        String data;
        try
        {
            data = Files.readAllLines(Paths.get(reader.getDir(), target)).get(0);
        } catch (IOException e) {
            data = e.toString();
        }
        reader.push_include(
            data,
            target, target,
            1,
                attributes
        );
    }
}

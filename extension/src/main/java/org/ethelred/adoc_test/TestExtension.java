package org.ethelred.adoc_test;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

/**
 * TODO
 *
 * @author eharman
 * @since 2020-11-21
 */
public class TestExtension implements ExtensionRegistry
{
    @Override
    public void register(Asciidoctor asciidoctor)
    {
        var registry = asciidoctor.javaExtensionRegistry();
        registry.includeProcessor(TestInclude.class);
    }
}

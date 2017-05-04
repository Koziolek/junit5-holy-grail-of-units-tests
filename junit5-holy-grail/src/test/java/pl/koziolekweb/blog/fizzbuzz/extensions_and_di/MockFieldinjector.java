package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.mockito.MockitoAnnotations;

/**
 * Created by BKuczynski on 2017-04-18.
 */
public class MockFieldInjector implements TestInstancePostProcessor {

	@Override
	public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
		MockitoAnnotations.initMocks(o);
	}
}

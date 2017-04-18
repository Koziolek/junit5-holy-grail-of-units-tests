package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by BKuczynski on 2017-04-18.
 */
public class CustomExtension implements TestTemplateInvocationContextProvider {


	@Override
	public boolean supports(ContainerExtensionContext context) {
		return context.getElement()
				.filter(e -> AnnotationUtils.isAnnotated(e, Integration.class))
				.map($ -> true)
				.orElse(false);
	}

	@Override
	public Stream<TestTemplateInvocationContext> provide(ContainerExtensionContext context) {
		TestTemplateInvocationContext context1 = new TestTemplateInvocationContext() {
			@Override
			public String getDisplayName(int invocationIndex) {
				Logger.getLogger("JUnit 4").info("-------------------------------+++------------------");
				return "Integration test";
			}

		};
		return Collections.singletonList(context1).stream();
	}
}

package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.platform.commons.util.AnnotationUtils.isAnnotated;

/**
 * Created by BKuczynski on 2017-03-21.
 */
public class IntegrationFilterExtension implements TestExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluate(TestExtensionContext context) {
		String ci_name = Optional.ofNullable(System.getenv("ci_name")).orElse("DEV");
		if (!ci_name.equals("CI")) {
			return context.getTestMethod()
					.filter(m-> isAnnotated(m, Integration.class))
					.map($ -> ConditionEvaluationResult.disabled("Not on CI"))
					.orElse(ConditionEvaluationResult.enabled(""));
		}
		return ConditionEvaluationResult.enabled("");
	}
}

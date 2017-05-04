package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Predicate;

import static java.lang.String.format;
import static org.junit.platform.commons.util.AnnotationUtils.isAnnotated;

/**
 * Created by BKuczynski on 2017-03-21.
 */
public class ContainerLevelIntegrationFilter implements ContainerExecutionCondition {

    private static final String CI_NAME = Optional.ofNullable(
            System.getenv("ci_name")
    )
            .orElse("DEV");

    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return context.getTestClass()
                .filter(m -> isAnnotated(m, Integration.class))
                .map(m -> m.getAnnotation(Integration.class).value())
                .filter(((Predicate<String>) s -> CI_NAME.equals(s)).or(s1 -> CI_NAME.equals("DEV")))
                .map($ -> ConditionEvaluationResult.enabled(""))
                .orElse(ConditionEvaluationResult.disabled(format("This test %s cannot be run on %s.", context.getTestMethod().map(Method::getName).get(), CI_NAME)));
    }

}

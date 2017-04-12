package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.logging.Logger;

/**
 * Created by BKuczynski on 2017-04-11.
 */
public class CustomTestExecutionListener implements TestExecutionListener {

	@Override
	public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
		Logger.getLogger("JUnit 4").info(
				String
						.format("***** Test %s finished with results: %s *****",
								testIdentifier.getDisplayName(),
								entry.getKeyValuePairs().toString()
						)
		);
	}
}

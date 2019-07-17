package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.qmetry.qaf.example.steps.StepsLibrary.searchFor;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SampleTest extends WebDriverTestCase {

	@Test(groups = { "P1", "storykey=ZAL-1","testcasekey=asd-1" })
	public void testGoogleSearch4() {
		get("/");
		searchFor("qaf github infostretch");
		verifyLinkWithPartialTextPresent("qaf");
	}
}

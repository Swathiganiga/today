package com.examples.genisys;

import org.junit.runner.RunWith;

import com.intuit.karate.junit4.Karate;


import com.intuit.karate.cucumber.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
@RunWith(Karate.class)
public class test{
	@Test
	public void test() {
		
	    String karateOutputPath="target/surefire-reports";
	    generateReport(karateOutputPath);
	}
	public static void generateReport(String karateOutputPath) {        
	    Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
	    List<String> jsonPaths = new ArrayList(jsonFiles.size());
	    jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
	    Configuration config = new Configuration(new File("target"), "demo");
	    ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
	    reportBuilder.generateReports();        
	}
}

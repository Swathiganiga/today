package com.examples.genisys;

import org.junit.runner.RunWith;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;

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

@CucumberOptions(plugin= {"html:target/test-report","junit:target/junit-xml-report.xml","json:target/json-report.json"})
@RunWith(Karate.class)
public class test {
 
    @Test
    public void testParallel() {
    	  String karateOutputPath="target/surefire-reports";
  	    generateReport(karateOutputPath);
    }
 
    private static void generateReport(String karateOutputPath) {
    	 Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
 	    List<String> jsonPaths = new ArrayList(jsonFiles.size());
 	    jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
 	    Configuration config = new Configuration(new File("target"), "demo");
 	    ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
 	    reportBuilder.generateReports();
    }
    
}

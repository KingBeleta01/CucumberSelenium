package com.cucumber.runner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CucumberMain {

	public void cucumberMain() {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("/config.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

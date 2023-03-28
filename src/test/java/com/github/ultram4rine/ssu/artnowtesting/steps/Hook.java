package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.TestRunner;
import io.cucumber.java.After;

public class Hook extends TestRunner {
    @After
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

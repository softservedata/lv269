package com.softserve.edu.opencart.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

import com.softserve.edu.opencart.data.applications.IApplicationSource;

public class ReporterWrapper {
    
    private enum ReporterTags {
        BR_DISPLAY("<br>[DISPLAY]"),
        BR_ERROR("<br>[ERROR]"),
        BR_WARNING("<br>[WARNING]"),
        BR_INFO("<br>[INFO]"),
        BR_DEBUG("<br>[DEBUG]");
        
        private String field;

        private ReporterTags(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
    
    private enum ReporterLevels {
        ERROR_LEVEL(3),
        WARNING_LEVEL(5),
        INFO_LEVEL(7),
        DEBUG_LEVEL(9);
        
        private int level;

        private ReporterLevels(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }
    }

    private final String TIME_TEMPLATE = "yyyy/MM/dd HH:mm:ss";
    private final String SPACE_SYMBOL = " ";
    private boolean consoleOutput;

    public ReporterWrapper(IApplicationSource applicationSource) {
        this.consoleOutput = applicationSource.getConsoleOutput();
        // TODO Set default verbose.
    }

    private String getCurrentTime() {
		return SPACE_SYMBOL + new SimpleDateFormat(TIME_TEMPLATE).format(new Date()) + SPACE_SYMBOL;
	}
    
    public void display(String message){
        Reporter.log(ReporterTags.BR_DISPLAY.toString()
                + getCurrentTime() + message, consoleOutput);
    }

    public void error(String message){
        Reporter.log(ReporterTags.BR_ERROR.toString()
                + getCurrentTime() + message,
                ReporterLevels.ERROR_LEVEL.getLevel(), consoleOutput);
    }

    public void warning(String message){
        Reporter.log(ReporterTags.BR_WARNING.toString()
                + getCurrentTime() + message,
                ReporterLevels.WARNING_LEVEL.getLevel(), consoleOutput);
    }

    public void info(String message){
        Reporter.log(ReporterTags.BR_INFO.toString()
                + getCurrentTime() + message,
                ReporterLevels.INFO_LEVEL.getLevel(), consoleOutput);
    }

    public void debug(String message){
        Reporter.log(ReporterTags.BR_DEBUG.toString()
                + getCurrentTime() + message,
                ReporterLevels.DEBUG_LEVEL.getLevel(), consoleOutput);
    }

}

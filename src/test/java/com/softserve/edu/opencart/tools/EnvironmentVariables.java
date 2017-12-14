package com.softserve.edu.opencart.tools;

import java.util.ArrayList;
import java.util.List;

public final class EnvironmentVariables {

    private interface IEnvironment {
        String getVariable(String variableName);
    }

    private static class SystemVariable implements IEnvironment {
        public String getVariable(String variableName) {
            return System.getenv(variableName);
        }
    }

    private static class MavenVariable implements IEnvironment {
        public String getVariable(String variableName) {
            return System.getProperty(variableName);
        }
    }

    // TODO get from Eclipse/IntelliJIdea, Server, File on local disk, Jenkins 
    public enum SystemVariableParameters {
        DATABASE_CONNECTION("database_connection", new SystemVariable(), new MavenVariable()),
        DATABASE_LOGIN("database_login", new SystemVariable(), new MavenVariable()),
        DATABASE_PASSWORD("database_password", new SystemVariable(), new MavenVariable());
        
        private String field;
        private List<String> variableNames;
        private List<IEnvironment> environments;

        private SystemVariableParameters(String field, IEnvironment... environments) {
            this.field = field;
            this.environments = new ArrayList<>();
            for (IEnvironment current : environments) {
                this.environments.add(current);
            }
            initVariableNames();
        }

        private void initVariableNames() {
            variableNames = new ArrayList<>();
            variableNames.add(field.toLowerCase());
            variableNames.add(field.toUpperCase());
            variableNames.add(field.toLowerCase().replace("_", "-"));
            variableNames.add(field.toUpperCase().replace("_", "-"));
            variableNames.add(field.toLowerCase().replace("_", "."));
            variableNames.add(field.toUpperCase().replace("_", "."));
        }
        
        public String getVariableParameter() {
            String result = null;
            boolean isFound = false;
            for (IEnvironment environment : environments) {
                for (String variableName : variableNames) {
                    result = environment.getVariable(variableName);
                    if ((result != null)
                            && (!result.isEmpty())
                            && (!result.equalsIgnoreCase("null"))) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    public String getVariableParameter(SystemVariableParameters systemVariableParameters) {
        // TODO If result null throw Exception
        return systemVariableParameters.getVariableParameter();
    }

    public String getDatabaseConnection() {
        return getVariableParameter(SystemVariableParameters.DATABASE_CONNECTION);
    }

    public String getDatabaseLogin() {
        return getVariableParameter(SystemVariableParameters.DATABASE_LOGIN);
    }

    public String getDatabasePassword() {
        return getVariableParameter(SystemVariableParameters.DATABASE_PASSWORD);
    }

}

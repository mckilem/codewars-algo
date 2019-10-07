package com.codewars;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator  {

    public static double evaluate(String input) {
        double result = 0;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            result =  Double.parseDouble(String.valueOf(engine.eval(input)));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}

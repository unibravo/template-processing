package com.aimprosoft.templateProcessor.evaluators;

import org.alfresco.web.evaluator.BaseEvaluator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Checks if the document has text and the value of the aspects property
 *
 * @see BaseEvaluator
 */
public class CheckAspectAndPropertyEvaluator extends BaseEvaluator {

    /* Aspect */
    private String aspect;
    /* Property */
    private String property;

    /**
     * Checks if the document has the aspect like a {@link CheckAspectAndPropertyEvaluator#aspect}
     * and the value of the aspects property like a {@link CheckAspectAndPropertyEvaluator#property}
     *
     * @param jsonObject object with properties
     * @return {@code true} if the aspect is present and the value of the aspects property is {@code false},
     * otherwise it returns {@code false}
     */
    @Override
    public boolean evaluate(JSONObject jsonObject) {
        JSONArray nodeAspects = getNodeAspects(jsonObject);
        return nodeAspects != null
                && nodeAspects.contains(aspect)
                && !Boolean.valueOf(getProperty(jsonObject, property).toString());
    }

    /* Setters*/
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }
    public void setProperty(String property) {
        this.property = property;
    }
}

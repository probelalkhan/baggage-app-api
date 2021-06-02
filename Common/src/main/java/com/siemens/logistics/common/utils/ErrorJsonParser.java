package com.siemens.logistics.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.siemens.logistics.common.models.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * This class is used to parse "userPrivilegeErrors.json" file stored in resources and provide the its values using appropriate methods
 */
public class ErrorJsonParser {

    private static Logger logger = LogManager.getLogger(ErrorJsonParser.class);

    public static ErrorResponse getErrorResponse(String errorsFileName, String language, int code, int subCode) {
        ErrorResponse errorResponse = new ErrorResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        //ResourceUtils.getFile("classpath:userPrivilegeErrors.json").exists();
        try {
            File errorsJson = ResourceUtils.getFile("classpath:"+errorsFileName+".json");
            ArrayNode errorTree = (ArrayNode) objectMapper.readTree(errorsJson);

            JsonNode node = getErrorTreeForLanguage(errorTree, language);
            if (node != null) {
                JsonNode errorNode = getErrorTreeForCodeAndSubCode(node, code, subCode);
                if (errorNode != null) {
                    ErrorResponse response = objectMapper.treeToValue(errorNode, ErrorResponse.class);
                    return response;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("Unable to parse userPrivilegeErrors.json");

        }
        return null;
    }

    private static JsonNode getErrorTreeForCodeAndSubCode(JsonNode node, int code, int subCode) {
        ArrayNode errorArray = (ArrayNode) node.get("errors");

        for (int i = 0; i < errorArray.size(); i++) {
            JsonNode error = errorArray.get(i);
            if (error.get("code").intValue() == code && error.get("subCode").intValue() == subCode) {
                return error;
            }
        }
        return null;
    }

    private static JsonNode getErrorTreeForLanguage(ArrayNode errorArray, String lng) {
        for (int i = 0; i < errorArray.size(); i++) {
            JsonNode node = errorArray.get(i);
            String language = node.get("lng").textValue();

            if (language.equalsIgnoreCase(lng)) {
                return node;
            }
        }
        return null;
    }
}

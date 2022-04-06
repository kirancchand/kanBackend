package com.project.kan.common.dao;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLSelectorWebService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SQLSelectorWebService.class);
    private static Map<String, String> queryMap = new HashMap<String, String>();
    private static final int SQL_KEYWORD_START_INDEX = 0;
    private static final String SQL_SELECT_KEYWORD = "SELECT";
    private static final String SQL_INSERT_KEYWORD = "INSERT";
    private static final String SQL_UPDATE_KEYWORD = "UPDATE";
    private static final String SQL_DELETE_KEYWORD = "DELETE";
    private static final String SQL_PROC_CALL_KEYWORD = "CALL";

    /**
     * 
     * constructor
     */
    public SQLSelectorWebService() {
    }

    static {
        try {
        	List<String> bundleNames = new ArrayList<String>();
            bundleNames.add("sql");
            //bundleNames.add("sql_intermediate");

            for (String bundleName : bundleNames) {
                ResourceBundle sqlQueries = ResourceBundle.getBundle(bundleName);
                Enumeration<String> bundleKeys = sqlQueries.getKeys();

                while (bundleKeys.hasMoreElements()) {
                    String key = bundleKeys.nextElement();
                    String value = sqlQueries.getString(key);
                    queryMap.put(key, value);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("Exception while reading sql.properties", ex);
        }
    }

    /**
     * method to get query based on query Id.
     * @param queryId
     * @return String
     */
    public static String getQuery(String queryId) {
        if (queryId == null || queryId.isEmpty()) {
            return null;
        }
        
        int sqlKeywordEndIndex = queryId.indexOf(" ");
        if (sqlKeywordEndIndex > 0) {
            String sqlKeyword = queryId.substring(SQL_KEYWORD_START_INDEX, sqlKeywordEndIndex);
            if (SQL_SELECT_KEYWORD.equalsIgnoreCase(sqlKeyword)
                    || SQL_INSERT_KEYWORD.equalsIgnoreCase(sqlKeyword)
                    || SQL_UPDATE_KEYWORD.equalsIgnoreCase(sqlKeyword)
                    || SQL_DELETE_KEYWORD.equalsIgnoreCase(sqlKeyword)
                    || SQL_PROC_CALL_KEYWORD.equalsIgnoreCase(sqlKeyword)) {
                return queryId;
            }
        }

        return queryMap.get(queryId);
    }
}

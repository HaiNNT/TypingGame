/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Date;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class QueryUtils {

    private final String tableName;
    private final Map<String, Object> params;

    public QueryUtils(Map<String, Object> params, String tableName) {
        this.params = params;
        this.tableName = tableName;
    }

    public Query getSelectQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM ");
        builder.append(tableName);
        builder.append(" WHERE 1 ");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            builder.append(" AND ");
            builder.append(entry.getKey());
            builder.append(" = ");
            builder.append(getValue(entry.getValue()));
        }
        return null;
    }

    private String getValue(Object object) {
        if (object instanceof String) {
            return " '" + (String) object + "' ";
        } else if (object instanceof Date) {
            java.text.SimpleDateFormat sdf
                    = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = sdf.format((Date)object);
            return " '" + dateTime + "' ";
        }else{
            return object.toString();
        }
    }
}

package com.obsqura.common;

import com.obsqura.utilities.MsSqUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SqlDB extends MsSqUtil{

    public static List<HashMap<String,String>> getQueryResultWithHeaders(String Queryinput){
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        try {
            //ResultSet rs = connect(Queryinput,"","","","","");
            ResultSet rs = Windows_Auth_connection(Queryinput,"DESKTOP-44FUJ6L");
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            String resultStr = "";
            while (rs.next()){
                HashMap<String,String> row = new HashMap<String,String>() ;
                for(int i =1; i<=columnCount; ++i){
                    row.put(metadata.getColumnName(i), rs.getString(i));
                }
                list.add(row);
            }
            close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


}

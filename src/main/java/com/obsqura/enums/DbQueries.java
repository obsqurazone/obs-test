package com.obsqura.enums;

public enum DbQueries {
    Get_SampleData_SampleTable1("select * from   where ='?'"),
    Get_SampleData_SampleTable("SELECT * FROM studentdetails");

    public String queryStr;

    DbQueries(final String queryStr) {
        this.queryStr = queryStr;
    }
}

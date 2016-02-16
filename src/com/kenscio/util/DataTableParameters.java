package com.kenscio.util;

import java.util.List;
import java.util.Map;

import javax.json.JsonObject;

import org.json.JSONObject;

import com.kenscio.to.Books;

public class DataTableParameters {
	
	int iTotalRecords;
    int iTotalDisplayRecords;
    String sEcho;
    String sColumns;
    JSONObject aaData;

    public int getiTotalRecords() {
            return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
            this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
            return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
            this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho() {
            return sEcho;
    }

    public void setsEcho(String sEcho) {
            this.sEcho = sEcho;
    }

    public String getsColumns() {
            return sColumns;
    }

    public void setsColumns(String sColumns) {
            this.sColumns = sColumns;
    }

    public JSONObject getAaData() {
            return aaData;
    }

    public  void setAaData(JSONObject aaData) {
            this.aaData = aaData;
    }

}

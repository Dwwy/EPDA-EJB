package com.example.demo1.Model;


public class GenericQuery {
    private String whereColumn;
    private Where whereCondition;
    private Object value;
    private Object value2; //optional
    private type type; //optional
    public enum type {
        timestamp,
        integer
    }
    public enum Where{
        id,
        like, //only string
        between, //type enum
        equal,
        greaterOrEqual, //type enum
        lesserOrEqual //type enum
    }

    public String getWhereColumn() {
        return whereColumn;
    }

    public void setWhereColumn(String whereColumn) {
        this.whereColumn = whereColumn;
    }

    public Where getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(Where whereCondition) {
        this.whereCondition = whereCondition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    public GenericQuery.type getType() {
        return type;
    }

    public void setType(GenericQuery.type type) {
        this.type = type;
    }
}

package com.jamesdube.scape.utils.enums;

public enum SubjectGrade {

    A("A",5),B("B",4),C("C",3)
    ,D("D,",2),E("E",1),O("O",0);

    private String symbol;

    private int points;

    SubjectGrade(String symbol, int points) {
        this.symbol = symbol;
        this.points = points;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPoints() {
        return points;
    }
}

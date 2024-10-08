package com.demosb.demo_sb_restapi.model;

import lombok.Getter;

@Getter
public enum MTRLine {
    // Island Line
    ISL("Island Line"),
    
    // Tsuen Wan Line
    TWL("Tsuen Wan Line"),
    
    // Kwun Tong Line
    KTL("Kwun Tong Line"),
    
    // Tung Chung Line
    TCL("Tung Chung Line"),
    
    // Disneyland Resort Line
    DRL("Disneyland Resort Line"),
    
    // Airport Express
    AEL("Airport Express"),
    
    // East Rail Line
    EAL("East Rail Line"),
    
    // Tuen Ma Line
    TML("Tuen Ma Line"),
    
    // South Island Line
    SIL("South Island Line");

    private final String lineName;

    MTRLine(String lineName) {
        this.lineName = lineName;
    }
}

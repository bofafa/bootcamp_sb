package com.demosb.demo_sb_restapi.model;


import lombok.Getter;

@Getter
public enum MTRStation {
    // Island Line
    HOK("Hong Kong"),
    CEN("Central"),
    ADM("Admiralty"),
    WCH("Wan Chai"),
    CWB("Causeway Bay"),
    TIN("Tin Hau"),
    FSS("Fortress Hill"),
    NOP("North Point"),
    QUB("Quarry Bay"),
    TIK("Tai Koo"),
    SWH("Shau Kei Wan"),
    HFC("Heng Fa Chuen"),
    CHW("Chai Wan"),

    // Tsuen Wan Line
    TSW("Tsuen Wan"),
    TWB("Tsuen Wan West"),
    TUC("Tuen Mun"),
    KOT("Kowloon Tong"),
    SSP("Sham Shui Po"),
    MOK("Mong Kok"),
    TST("Tsim Sha Tsui"),
    JOR("Jordan"),
    OLY("Olympic"),
    LAK("Lai King"),
    KWF("Kwai Fong"),
    KWH("Kwai Hing"),
   //TUC("Tung Chung"),

    // Kwun Tong Line
    WTS("Wong Tai Sin"),
    CHO("Choi Hung"),
    LWK("Lam Tin"),
    YMT("Yau Ma Tei"),
    HAH("Ho Man Tin"),
    KOB("Kowloon Bay"),
    NTK("Ngau Tau Kok"),
    KWT("Kwun Tong"),

    // Tung Chung Line
    //TUC("Tung Chung"),
    SUN("Sunny Bay"),
    //NOP("North Point"),

    // Disneyland Resort Line
    DIS("Disneyland Resort"),

    // Airport Express
    AWE("AsiaWorld-Expo"),
    AIR("Airport"),

    // East Rail Line
    HUH("Hung Hom"),
    MKK("Mong Kok East"),
    SHS("Sha Tin"),
    STW("Sheung Shui"),
    LOW("Lo Wu"),
    LMC("Lok Ma Chau"),

    // Tuen Ma Line
    TUM("Tuen Mun"),
    SIH("Siu Hong"),
    KSR("Kam Sheung Road"),
    TIS("Tai Wai"),

    // South Island Line
    OCP("Ocean Park"),
    //WCH("Wong Chuk Hang"),
    LHR("Lei Tung"),
    SOH("South Horizons");

    private final String stationName;

    MTRStation(String stationName) {
        this.stationName = stationName;
    }
}

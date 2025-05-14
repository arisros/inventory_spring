
package com.ubl.uas_jwp_2311510438.entity;

public enum KategoriBuah {
    BUAH_SEGAR("Buah segar"),
    BUAH_OLAHAN("Buah olahan"),
    BUAH_TROPIS("Buah tropis"),
    LAINNYA("Lainnya");

    private final String label;

    KategoriBuah(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

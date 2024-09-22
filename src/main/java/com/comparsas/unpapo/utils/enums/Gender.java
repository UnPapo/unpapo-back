package com.comparsas.unpapo.utils.enums;

public enum Gender {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    NAO_BINARIO("NÃO BINÁRIO"),
    BOYCETA("BOYCETA"),
    GENERO_FLUIDO("GENERO FLUIDO"),
    AGENERO("AGENERO"),
    BIGENERO("BIGENERO"),
    DEMIBOY("DEMIBOY"),
    DEMIGIRL("DEMIGIRL"),
    TRANSGENERO("TRANSGENERO"),
    OUTRO("OUTRO");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
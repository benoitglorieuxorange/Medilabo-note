package com.bgl.back_note.dto;

import com.bgl.back_note.enums.RiskState;

public record ProcessRequestDto(
        Long patientId,
        Integer height,
        Integer weight,
        boolean isSmoker,
        double hemoglobin,
        double cholesterol,
        double microalbumin,
        String patientNote,
        RiskState riskState
) {}

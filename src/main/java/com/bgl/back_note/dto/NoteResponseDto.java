package com.bgl.back_note.dto;

import com.bgl.back_note.enums.RiskState;

public record NoteResponseDto(
    String id,
    Long patientId,
    Integer height,
    Integer weight,
    boolean isSmoker,
    double hemoglobin,
    double cholesterol,
    double microalbumin,
    String patientNote
) {}

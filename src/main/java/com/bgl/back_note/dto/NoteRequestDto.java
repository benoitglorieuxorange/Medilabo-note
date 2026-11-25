package com.bgl.back_note.dto;


public record NoteRequestDto(
    Long patientId,
    Integer height,
    Integer weight,
    boolean isSmoker,
    double hemoglobin,
    double cholesterol,
    double microalbumin,
    String patientNote
) {}




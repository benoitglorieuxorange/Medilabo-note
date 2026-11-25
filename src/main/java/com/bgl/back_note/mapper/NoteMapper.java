package com.bgl.back_note.mapper;

import com.bgl.back_note.dto.NoteRequestDto;
import com.bgl.back_note.dto.NoteResponseDto;
import com.bgl.back_note.dto.ProcessRequestDto;
import com.bgl.back_note.entities.NoteEntity;

public class NoteMapper {

    public static NoteResponseDto toDto(NoteEntity note) {
        return new NoteResponseDto(
                note.getId(),
                note.getPatientId(),
                note.getHeight(),
                note.getWeight(),
                note.isSmoker(),
                note.getHemoglobin(),
                note.getCholesterol(),
                note.getMicroalbumin(),
                note.getPatientNote()
        );
    }

    public static NoteEntity toEntity(NoteRequestDto noteDto) {
        NoteEntity entity = new NoteEntity(
                null,
                noteDto.patientId(),
                noteDto.height(),
                noteDto.weight(),
                noteDto.isSmoker(),
                noteDto.hemoglobin(),
                noteDto.cholesterol(),
                noteDto.microalbumin(),
                noteDto.patientNote(),
                null
        );
        return entity;
    }

    public static void update(NoteRequestDto noteDto, NoteEntity entity) {
        entity.setPatientId(noteDto.patientId());
        entity.setHeight(noteDto.height());
        entity.setWeight(noteDto.weight());
        entity.setSmoker(noteDto.isSmoker());
        entity.setHemoglobin(noteDto.hemoglobin());
        entity.setCholesterol(noteDto.cholesterol());
        entity.setMicroalbumin(noteDto.microalbumin());
        entity.setPatientNote(noteDto.patientNote());
    }


    public static ProcessRequestDto toProcessRequestDto(NoteEntity note) {
        return new ProcessRequestDto(
                note.getPatientId(),
                note.getHeight(),
                note.getWeight(),
                note.isSmoker(),
                note.getHemoglobin(),
                note.getCholesterol(),
                note.getMicroalbumin(),
                note.getPatientNote(),
                note.getRiskState()
        );
    }
}
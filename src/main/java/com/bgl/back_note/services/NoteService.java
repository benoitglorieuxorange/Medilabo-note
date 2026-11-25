package com.bgl.back_note.services;


import com.bgl.back_note.dto.NoteRequestDto;
import com.bgl.back_note.dto.NoteResponseDto;
import com.bgl.back_note.dto.ProcessResponseDto;
import com.bgl.back_note.dto.ResponseRisk;
import com.bgl.back_note.entities.NoteEntity;
import com.bgl.back_note.mapper.NoteMapper;
import com.bgl.back_note.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ProcessClient processClient;

    public NoteService (NoteRepository noteRepository, ProcessClient processClient){
        this.noteRepository = noteRepository;
        this.processClient = processClient;
    }

    // GetAll Notes
    public List<NoteResponseDto> getAll() {
        return noteRepository.findAll().stream()
                .map(NoteMapper::toDto)
                .collect(Collectors.toList());
    }

    // Create Note
    public ResponseRisk create(NoteRequestDto noteRequestDto) {
        NoteEntity note = NoteMapper.toEntity(noteRequestDto);

        ProcessResponseDto processResponse =
                processClient.send(NoteMapper.toProcessRequestDto(note));

        note.setRiskState(processResponse.riskState());
        NoteEntity savedNote = noteRepository.save(note);

        return new ResponseRisk(NoteMapper.toDto(savedNote), processResponse);
    }

    // Get Note by ID
    public NoteResponseDto getById(String id) {
        NoteEntity note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        return NoteMapper.toDto(note);
    }

    // Update Note
    public NoteResponseDto update(String id, NoteRequestDto noteRequestDto) {
        NoteEntity existingNote = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        NoteMapper.update(noteRequestDto, existingNote);
        NoteEntity updatedNote = noteRepository.save(existingNote);
        return NoteMapper.toDto(updatedNote);
    }

    // Delete Note
    public void delete(String id) {
        NoteEntity existingNote = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(existingNote);
    }

}

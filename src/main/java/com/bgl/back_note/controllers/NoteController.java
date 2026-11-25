package com.bgl.back_note.controllers;

import com.bgl.back_note.dto.NoteRequestDto;
import com.bgl.back_note.dto.NoteResponseDto;
import com.bgl.back_note.dto.ProcessResponseDto;
import com.bgl.back_note.dto.ResponseRisk;
import com.bgl.back_note.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    //Get all notes
    @GetMapping
    public ResponseEntity<List<NoteResponseDto>> getAll() {
        return ResponseEntity.ok(noteService.getAll());
    }

    // Get Note by Id
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(noteService.getById(id));
    }

    // Create Note
    @PostMapping
    public ResponseEntity<ResponseRisk> create(@RequestBody NoteRequestDto noteRequestDto) {
        return ResponseEntity.ok(noteService.create(noteRequestDto));
    }

    // Update Note
    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDto> update(@PathVariable String id, @RequestBody NoteRequestDto noteRequestDto) {
        return ResponseEntity.ok(noteService.update(id, noteRequestDto));
    }

    // Delete Note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

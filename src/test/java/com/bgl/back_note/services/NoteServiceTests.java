package com.bgl.back_note.services;

import com.bgl.back_note.dto.NoteRequestDto;
import com.bgl.back_note.dto.NoteResponseDto;
import com.bgl.back_note.entities.NoteEntity;
import com.bgl.back_note.repository.NoteRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class NoteServiceTests {

    @Test
    void getAllReturnsMappedNotesInOrder() {
        NoteRepository repository = mock(NoteRepository.class);
        NoteService service = new NoteService(repository, mock(ProcessClient.class));
        NoteEntity first = new NoteEntity("first", 1L, 160, 60, true, 1, 2, 3, "First note", null);
        NoteEntity second = new NoteEntity("second", 4L, 175, 70, false, 7.1, 200, 30, "Second note", null);
        when(repository.findAll()).thenReturn(List.of(first, second));

        assertEquals(List.of(
                new NoteResponseDto("first", 1L, 160, 60, true, 1, 2, 3, "First note"),
                new NoteResponseDto("second", 4L, 175, 70, false, 7.1, 200, 30, "Second note")
        ), service.getAll());
    }

    @Test
    void getAllReturnsEmptyListWhenNoNotesExist() {
        NoteRepository repository = mock(NoteRepository.class);
        NoteService service = new NoteService(repository, mock(ProcessClient.class));
        when(repository.findAll()).thenReturn(List.of());

        assertEquals(List.of(), service.getAll());
    }

    @Test
    void updatePreservesIdAndUpdatesAllFields() {
        NoteRepository repository = mock(NoteRepository.class);
        NoteService service = new NoteService(repository, mock(ProcessClient.class));
        NoteEntity existing = new NoteEntity("note-id", 1L, 160, 60, true, 1, 2, 3, "Old note", null);
        NoteRequestDto request = new NoteRequestDto(4L, 175, 70, false, 7.1, 200, 30, "Updated note");
        when(repository.findById("note-id")).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

        NoteResponseDto response = service.update("note-id", request);

        assertEquals(new NoteResponseDto("note-id", 4L, 175, 70, false, 7.1, 200, 30, "Updated note"), response);
        verify(repository).save(same(existing));
    }

    @Test
    void updateMissingNoteDoesNotSave() {
        NoteRepository repository = mock(NoteRepository.class);
        NoteService service = new NoteService(repository, mock(ProcessClient.class));
        NoteRequestDto request = new NoteRequestDto(4L, 175, 70, false, 7.1, 200, 30, "Updated note");
        when(repository.findById("missing")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.update("missing", request));

        assertEquals("Note not found", exception.getMessage());
        verify(repository, never()).save(any(NoteEntity.class));
    }
}

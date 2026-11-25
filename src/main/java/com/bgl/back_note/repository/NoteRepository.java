package com.bgl.back_note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bgl.back_note.entities.NoteEntity;


public interface NoteRepository extends MongoRepository<NoteEntity, String> {

}

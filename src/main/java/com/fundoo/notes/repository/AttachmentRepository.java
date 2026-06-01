package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Attachment;
import com.fundoo.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    List<Attachment> findByNote(Note note);

    Optional<Attachment> findByIdAndNote(Long id, Note note);
}
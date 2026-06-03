package com.fundoo.notes.service;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.fundoo.notes.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note createNote(NoteRequest request, User user) {

        Note note = Note.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .reminderAt(request.getReminderAt())
                .user(user)
                .build();

        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(User user) {
return noteRepository.findByUserAndTrashedFalseAndArchivedFalse(user);
    }

    public Note getNoteById(Long id, User user) {
        return noteRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
    }

    public Note updateNote(Long id, NoteRequest request, User user) {

        Note note = getNoteById(id, user);

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setReminderAt(request.getReminderAt());

        return noteRepository.save(note);
    }

    public String deleteNote(Long id, User user) {

        Note note = getNoteById(id, user);

        noteRepository.delete(note);

        return "Note deleted permanently";
    }

    public Note pinNote(Long id, User user) {

        Note note = getNoteById(id, user);

        note.setPinned(!note.isPinned());

        return noteRepository.save(note);
    }

    public Note archiveNote(Long id, User user) {

        Note note = getNoteById(id, user);

        note.setArchived(!note.isArchived());

        if (note.isArchived()) {
            note.setPinned(false);
        }

        return noteRepository.save(note);
    }

    public Note trashNote(Long id, User user) {

        Note note = getNoteById(id, user);

        note.setTrashed(true);
        note.setPinned(false);
        note.setArchived(false);

        return noteRepository.save(note);
    }

    public Note restoreNote(Long id, User user) {

        Note note = getNoteById(id, user);

        note.setTrashed(false);

        return noteRepository.save(note);
    }

    public List<Note> getPinnedNotes(User user) {
        return noteRepository.findByUserAndPinnedTrueAndTrashedFalse(user);
    }

    public List<Note> getArchivedNotes(User user) {
        return noteRepository.findByUserAndArchivedTrueAndTrashedFalse(user);
    }

    public List<Note> getTrashNotes(User user) {
        return noteRepository.findByUserAndTrashedTrue(user);
    }

    public List<Note> searchNotes(String keyword, User user) {
        return noteRepository.searchNotes(user, keyword);
    }
}

package com.fundoo.notes.service;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.repository.LabelRepository;
import com.fundoo.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;
    private final NoteRepository noteRepository;

    public Label createLabel(LabelRequest request, User user) {

        if (labelRepository.existsByNameAndUser(request.getName(), user)) {
            throw new RuntimeException("Label already exists");
        }

        Label label = Label.builder()
                .name(request.getName())
                .user(user)
                .build();

        return labelRepository.save(label);
    }

    public List<Label> getAllLabels(User user) {
        return labelRepository.findByUser(user);
    }

    public Label updateLabel(Long id, LabelRequest request, User user) {

        Label label = getLabelById(id, user);

        label.setName(request.getName());

        return labelRepository.save(label);
    }

    public String deleteLabel(Long id, User user) {

        Label label = getLabelById(id, user);

        labelRepository.delete(label);

        return "Label deleted successfully";
    }

    public Note addLabelToNote(Long labelId, Long noteId, User user) {

        Label label = getLabelById(labelId, user);

        Note note = noteRepository.findByIdAndUser(noteId, user)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

        note.getLabels().add(label);

        return noteRepository.save(note);
    }

    public Note removeLabelFromNote(Long labelId, Long noteId, User user) {

        Label label = getLabelById(labelId, user);

        Note note = noteRepository.findByIdAndUser(noteId, user)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

        note.getLabels().remove(label);

        return noteRepository.save(note);
    }

    public List<Note> getNotesByLabel(Long labelId, User user) {

        Label label = getLabelById(labelId, user);

        return noteRepository.findByLabelsContainingAndUserAndTrashedFalse(label, user);
    }

    private Label getLabelById(Long id, User user) {
        return labelRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found with id: " + id));
    }
}
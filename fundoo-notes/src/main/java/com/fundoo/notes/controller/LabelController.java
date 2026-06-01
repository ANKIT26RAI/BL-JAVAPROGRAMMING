package com.fundoo.notes.controller;

import com.fundoo.notes.dto.LabelRequest;
import com.fundoo.notes.entity.Label;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.service.LabelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labels")
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @PostMapping
    public ResponseEntity<Label> createLabel(
            @Valid @RequestBody LabelRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.createLabel(request, user));
    }

    @GetMapping
    public ResponseEntity<List<Label>> getAllLabels(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.getAllLabels(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Label> updateLabel(
            @PathVariable Long id,
            @Valid @RequestBody LabelRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.updateLabel(id, request, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLabel(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.deleteLabel(id, user));
    }

    @PutMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<Note> addLabelToNote(
            @PathVariable Long labelId,
            @PathVariable Long noteId,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.addLabelToNote(labelId, noteId, user));
    }

    @DeleteMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<Note> removeLabelFromNote(
            @PathVariable Long labelId,
            @PathVariable Long noteId,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.removeLabelFromNote(labelId, noteId, user));
    }

    @GetMapping("/{labelId}/notes")
    public ResponseEntity<List<Note>> getNotesByLabel(
            @PathVariable Long labelId,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(labelService.getNotesByLabel(labelId, user));
    }
}
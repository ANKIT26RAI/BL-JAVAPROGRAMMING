package com.fundoo.notes.controller;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(
            @Valid @RequestBody NoteRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.createNote(request, user));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.getAllNotes(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.getNoteById(id, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.updateNote(id, request, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.deleteNote(id, user));
    }

    @PutMapping("/{id}/pin")
    public ResponseEntity<Note> pinNote(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.pinNote(id, user));
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<Note> archiveNote(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.archiveNote(id, user));
    }

    @PutMapping("/{id}/trash")
    public ResponseEntity<Note> trashNote(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.trashNote(id, user));
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<Note> restoreNote(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.restoreNote(id, user));
    }

    @GetMapping("/pinned")
    public ResponseEntity<List<Note>> getPinnedNotes(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.getPinnedNotes(user));
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Note>> getArchivedNotes(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.getArchivedNotes(user));
    }

    @GetMapping("/trash")
    public ResponseEntity<List<Note>> getTrashNotes(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.getTrashNotes(user));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(
            @RequestParam String keyword,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(noteService.searchNotes(keyword, user));
    }
}
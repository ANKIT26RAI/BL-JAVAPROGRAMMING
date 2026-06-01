package com.fundoo.notes.controller;

import com.fundoo.notes.entity.Attachment;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/notes/{noteId}")
    public ResponseEntity<Attachment> uploadFile(
            @PathVariable Long noteId,
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(attachmentService.uploadFile(noteId, file, user));
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByNote(
            @PathVariable Long noteId,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(attachmentService.getAttachmentsByNote(noteId, user));
    }

    @GetMapping("/download/{attachmentId}")
    public ResponseEntity<Resource> downloadAttachment(
            @PathVariable Long attachmentId,
            @AuthenticationPrincipal User user
    ) {
        Attachment attachment = attachmentService.getAttachmentById(attachmentId, user);

        Resource resource = attachmentService.downloadAttachment(attachmentId, user);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName() + "\""
                )
                .body(resource);
    }

    @DeleteMapping("/{attachmentId}")
    public ResponseEntity<String> deleteAttachment(
            @PathVariable Long attachmentId,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(attachmentService.deleteAttachment(attachmentId, user));
    }
}
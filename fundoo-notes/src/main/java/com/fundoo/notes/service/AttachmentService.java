package com.fundoo.notes.service;

import com.fundoo.notes.entity.Attachment;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.exception.ResourceNotFoundException;
import com.fundoo.notes.repository.AttachmentRepository;
import com.fundoo.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final NoteRepository noteRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public Attachment uploadFile(Long noteId, MultipartFile file, User user) {

        try {
            Note note = noteRepository.findByIdAndUser(noteId, user)
                    .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFileName = file.getOriginalFilename();

            String storedFileName = UUID.randomUUID() + "_" + originalFileName;

            Path filePath = uploadPath.resolve(storedFileName);

            Files.copy(file.getInputStream(), filePath);

            Attachment attachment = Attachment.builder()
                    .fileName(originalFileName)
                    .fileType(file.getContentType())
                    .filePath(filePath.toString())
                    .fileSize(file.getSize())
                    .note(note)
                    .build();

            return attachmentRepository.save(attachment);

        } catch (Exception e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }

    public List<Attachment> getAttachmentsByNote(Long noteId, User user) {

        Note note = noteRepository.findByIdAndUser(noteId, user)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + noteId));

        return attachmentRepository.findByNote(note);
    }

    public Resource downloadAttachment(Long attachmentId, User user) {

        try {
            Attachment attachment = attachmentRepository.findById(attachmentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Attachment not found with id: " + attachmentId));

            Note note = attachment.getNote();

            if (!note.getUser().getId().equals(user.getId())) {
                throw new RuntimeException("You are not allowed to download this attachment");
            }

            Path filePath = Paths.get(attachment.getFilePath());

            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                throw new ResourceNotFoundException("File not found on server");
            }

            return resource;

        } catch (Exception e) {
            throw new RuntimeException("File download failed: " + e.getMessage());
        }
    }

    public Attachment getAttachmentById(Long attachmentId, User user) {

        Attachment attachment = attachmentRepository.findById(attachmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found with id: " + attachmentId));

        if (!attachment.getNote().getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to access this attachment");
        }

        return attachment;
    }

    public String deleteAttachment(Long attachmentId, User user) {

        try {
            Attachment attachment = getAttachmentById(attachmentId, user);

            Path filePath = Paths.get(attachment.getFilePath());

            Files.deleteIfExists(filePath);

            attachmentRepository.delete(attachment);

            return "Attachment deleted successfully";

        } catch (Exception e) {
            throw new RuntimeException("File delete failed: " + e.getMessage());
        }
    }
}
package com.fundoo.notes.consumer;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReminderConsumer {

    private final NoteRepository noteRepository;
    private final EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveReminderMessage(Long noteId) {

        log.info("RabbitMQ Reminder Note ID Received: {}", noteId);

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + noteId));

        String userEmail = note.getUser().getEmail();

        emailService.sendReminderEmail(
                userEmail,
                note.getTitle(),
                note.getDescription()
        );

        log.info("Reminder email sent to user: {} for note id: {}", userEmail, noteId);
    }
}
package com.fundoo.notes.scheduler;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.service.ReminderProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReminderScheduler {

    private final NoteRepository noteRepository;
    private final ReminderProducer reminderProducer;

    @Scheduled(fixedRate = 60000)
    public void checkReminders() {

        LocalDateTime now = LocalDateTime.now();

        List<Note> reminderNotes =
                noteRepository.findByReminderAtBeforeAndReminderSentFalseAndTrashedFalse(now);

        for (Note note : reminderNotes) {

            reminderProducer.sendReminderMessage(note.getId());

            log.info("Reminder note id sent to RabbitMQ: {}", note.getId());

            note.setReminderSent(true);
            noteRepository.save(note);
        }
    }
}
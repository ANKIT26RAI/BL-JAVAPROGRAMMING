package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.fundoo.notes.entity.Label;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserAndTrashedFalse(User user);

    List<Note> findByUserAndPinnedTrueAndTrashedFalse(User user);

    List<Note> findByUserAndArchivedTrueAndTrashedFalse(User user);

    List<Note> findByUserAndTrashedTrue(User user);
    List<Note> findByLabelsContainingAndUserAndTrashedFalse(Label label, User user);

    Optional<Note> findByIdAndUser(Long id, User user);

    List<Note> findByReminderAtBeforeAndReminderSentFalseAndTrashedFalse(LocalDateTime now);

    @Query("""
            SELECT n FROM Note n
            WHERE n.user = :user
            AND n.trashed = false
            AND (
                LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(n.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
            )
            """)
    List<Note> searchNotes(User user, String keyword);
}
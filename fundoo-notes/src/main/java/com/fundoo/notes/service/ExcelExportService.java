package com.fundoo.notes.service;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelExportService {

    private final NoteRepository noteRepository;

    public byte[] exportNotesToExcel(User user) {

        List<Note> notes = noteRepository.findByUserAndTrashedFalse(user);

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Notes");

            Row headerRow = sheet.createRow(0);

            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Title");
            headerRow.createCell(2).setCellValue("Description");
            headerRow.createCell(3).setCellValue("Pinned");
            headerRow.createCell(4).setCellValue("Archived");
            headerRow.createCell(5).setCellValue("Trashed");
            headerRow.createCell(6).setCellValue("Reminder At");
            headerRow.createCell(7).setCellValue("Reminder Sent");
            headerRow.createCell(8).setCellValue("Created At");
            headerRow.createCell(9).setCellValue("Updated At");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            int rowIndex = 1;

            for (Note note : notes) {
                Row row = sheet.createRow(rowIndex++);

                row.createCell(0).setCellValue(note.getId());
                row.createCell(1).setCellValue(note.getTitle());
                row.createCell(2).setCellValue(note.getDescription());
                row.createCell(3).setCellValue(note.isPinned());
                row.createCell(4).setCellValue(note.isArchived());
                row.createCell(5).setCellValue(note.isTrashed());

                row.createCell(6).setCellValue(
                        note.getReminderAt() != null
                                ? note.getReminderAt().format(formatter)
                                : ""
                );

                row.createCell(7).setCellValue(note.isReminderSent());

                row.createCell(8).setCellValue(
                        note.getCreatedAt() != null
                                ? note.getCreatedAt().format(formatter)
                                : ""
                );

                row.createCell(9).setCellValue(
                        note.getUpdatedAt() != null
                                ? note.getUpdatedAt().format(formatter)
                                : ""
                );
            }

        // for (int i = 0; i <= 9; i++) {
        //   sheet.autoSizeColumn(i);
        //}

            workbook.write(outputStream);

            return outputStream.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Failed to export notes to Excel: " + e.getMessage());
        }
    }
}

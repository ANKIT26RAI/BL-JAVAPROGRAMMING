package com.fundoo.notes.controller;

import com.fundoo.notes.entity.User;
import com.fundoo.notes.service.ExcelExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/export")
@RequiredArgsConstructor
public class ExportController {

    private final ExcelExportService excelExportService;

    @GetMapping("/notes/excel")
    public ResponseEntity<byte[]> exportNotesToExcel(
            @AuthenticationPrincipal User user
    ) {
        byte[] excelFile = excelExportService.exportNotesToExcel(user);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=notes.xlsx")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                ))
                .body(excelFile);
    }
}
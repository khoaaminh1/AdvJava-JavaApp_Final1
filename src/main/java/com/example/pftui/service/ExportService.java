package com.example.pftui.service;

import com.example.pftui.model.Transaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ExportService {

    private final TransactionService transactionService;

    public ExportService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void exportTransactionsToCsv(String userId, Writer writer) throws IOException {
        List<Transaction> transactions = transactionService.getAllTransactionsByUser(userId);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("ID_GIAO_DICH", "NGAY_GIAO_DICH", "LOAI_GIAO_DICH", "TAI_KHOAN", "DANH_MUC", "SO_TIEN", "DON_VI", "NGUOI_BAN_DOI_TAC", "GHI_CHU", "GIAO_DICH_DINH_KY", "THOI_GIAN_TAO")
                .build();

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat)) {
            for (Transaction transaction : transactions) {
                csvPrinter.printRecord(
                        transaction.getId(),
                        transaction.getDate(),
                        transaction.getCategory() != null && transaction.getCategory().getType() != null ? transaction.getCategory().getType().name() : "",
                        transaction.getAccount() != null ? transaction.getAccount().getName() : "",
                        transaction.getCategory() != null ? transaction.getCategory().getName() : "",
                        transaction.getAmount(),
                        transaction.getAccount() != null ? transaction.getAccount().getCurrency() : "",
                        transaction.getMerchant(),
                        transaction.getNote(),
                        transaction.isRecurring() ? "Có" : "Không",
                        transaction.getCreatedAt()
                );
            }
        }
    }
}

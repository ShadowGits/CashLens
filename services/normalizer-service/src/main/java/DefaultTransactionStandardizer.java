

import com.aistuff.dto.StandardizedTransactionDTO;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;


public class DefaultTransactionStandardizer implements TransactionStandardizer {

    @Override
    public StandardizedTransactionDTO standardize(Map<String, String> rawRow, Map<String, String> schemaMapping) {
        try {
            String transactionId = getValue(rawRow, schemaMapping, "transaction_id");
            String dateRaw = getValue(rawRow, schemaMapping, "date");
            LocalDate date = LocalDate.parse(dateRaw);

            String description = getValue(rawRow, schemaMapping, "description");

            String amountRaw = getValue(rawRow, schemaMapping, "amount");
            double amount = Double.parseDouble(amountRaw);

            String typeRaw = getValue(rawRow, schemaMapping, "type").toLowerCase().trim();
            if (!typeRaw.equals("debit") && !typeRaw.equals("credit")) {
                throw new IllegalArgumentException("Invalid type: " + typeRaw);
            }

            String balanceRaw = getValue(rawRow, schemaMapping, "balance");
            double balance = Double.parseDouble(balanceRaw);

            String accountNo = getValue(rawRow, schemaMapping, "account_no");
            String bank = getValue(rawRow, schemaMapping, "bank");

            return new StandardizedTransactionDTO(
                    transactionId,
                    date,
                    description,
                    amount,
                    typeRaw,
                    balance,
                    accountNo,
                    bank
            );

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Amount or balance is not a valid number", e);
        }
    }

    /**
     * Resolves a canonical field's value from raw row based on schema mapping.
     * @param rawRow the input row map
     * @param schema the schema mapping (canonical → actual)
     * @param canonicalField the canonical field name
     * @return the resolved string value
     */
    private String getValue(Map<String, String> rawRow, Map<String, String> schema, String canonicalField) {
        String actualField = schema.get(canonicalField);
        if (actualField == null || !rawRow.containsKey(actualField)) {
            throw new IllegalArgumentException("Missing mapped field: " + canonicalField + " → " + actualField);
        }
        String value = rawRow.get(actualField);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty value for field: " + canonicalField);
        }
        return value.trim();
    }
}


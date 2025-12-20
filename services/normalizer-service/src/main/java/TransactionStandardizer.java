

import com.aistuff.dto.StandardizedTransactionDTO;

import java.util.Map;


public interface TransactionStandardizer {

    /**
     * Transforms a raw input row into a standardized TransactionDTO.
     *
     * @param rawRow a map of fieldName → stringValue from parsed CSV row
     * @param schemaMapping canonicalFieldName → actualFieldName in this bank's export
     * @return a fully standardized and validated TransactionDTO
     * @throws IllegalArgumentException if required fields are missing or malformed
     */
    StandardizedTransactionDTO standardize(Map<String, String> rawRow, Map<String, String> schemaMapping);
}

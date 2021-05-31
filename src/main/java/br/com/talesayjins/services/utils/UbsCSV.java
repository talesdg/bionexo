package br.com.talesayjins.services.utils;

import br.com.talesayjins.entities.Ubs;
import br.com.talesayjins.entities.enums.Score;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UbsCSV {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {
            "vlr_latitude", "vlr_longitude", "cod_munic", "cod_cnes", "nom_estab", "dsc_endereco",
            "dsc_bairro","dsc_cidade","dsc_telefone","dsc_estrut_fisic_ambiencia", "dsc_adap_defic_fisic_idosos",
            "dsc_equipamentos", "dsc_medicamentos"
    };


    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Ubs> csvToUbs(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Ubs> ubsList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                if(csvRecord.get("dsc_estrut_fisic_ambiencia").equals(Score.DESEMPENHO_ACIMA.getDescricao())){

                }
                Ubs ubs = new Ubs(
                        Double.parseDouble(csvRecord.get("vlr_latitude")),
                        Double.parseDouble(csvRecord.get("vlr_longitude")),
                        csvRecord.get("cod_munic"),
                        csvRecord.get("cod_cnes"),
                        csvRecord.get("nom_estab"),
                        csvRecord.get("dsc_endereco"),
                        csvRecord.get("dsc_bairro"),
                        csvRecord.get("dsc_cidade"),
                        csvRecord.get("dsc_telefone"),
                        Score.toEnum(csvRecord.get("dsc_estrut_fisic_ambiencia")),
                        Score.toEnum(csvRecord.get("dsc_adap_defic_fisic_idosos")),
                        Score.toEnum(csvRecord.get("dsc_equipamentos")),
                        Score.toEnum(csvRecord.get("dsc_medicamentos")),
                        csvRecord.get("vlr_latitude"),
                        csvRecord.get("vlr_longitude")
                );
                ubsList.add(ubs);
            }
            return ubsList;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao transformar o arquivo CSV: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream ubsToCSV(List<Ubs> ubsList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Ubs ubs : ubsList) {
                List<? extends Serializable> data = Arrays.asList(
                        String.valueOf(ubs.getId()),
                        ubs.getVlr_latitude(),
                        ubs.getVlr_longitude(),
                        ubs.getCod_munic(),
                        ubs.getCodCnes(),
                        ubs.getNom_estab(),
                        ubs.getDsc_endereco(),
                        ubs.getDsc_bairro(),
                        ubs.getDsc_cidade(),
                        ubs.getDsc_telefone(),
                        ubs.getDsc_estrut_fisic_ambiencia(),
                        ubs.getDsc_adap_defic_fisic_idosos(),
                        ubs.getDsc_equipamentos(),
                        ubs.getDsc_medicamentos(),
                        ubs.getLatitude(),
                        ubs.getLongitude()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao importar o arquivo CSV: " + e.getMessage());
        }
    }
}

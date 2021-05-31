package br.com.talesayjins.services;

import br.com.talesayjins.entities.Ubs;
import br.com.talesayjins.repositories.UbsRepository;
import br.com.talesayjins.services.utils.UbsCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class UbsService {
    @Autowired
    UbsRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Ubs> tutorials = UbsCSV.csvToUbs(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o arquivo csv: " + e.getMessage());
        }
    }


    public Page<Ubs> search(String query, Integer page, Integer linesPerPage) {
        PageRequest pageRequest = PageRequest.of(page - 1, linesPerPage);
        String[] geocode = query.split(",");
        return repository.findAllByLatitudeAndLongitude(geocode[0],geocode[1],pageRequest);
    }


    public ByteArrayInputStream load() {
        List<Ubs> tutorials = repository.findAll();

        ByteArrayInputStream in = UbsCSV.ubsToCSV(tutorials);
        return in;
    }

}


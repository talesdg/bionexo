package br.com.talesayjins.controllers;

import br.com.talesayjins.controllers.response.ResponseMessage;
import br.com.talesayjins.controllers.response.ResponsePagination;
import br.com.talesayjins.dto.UbsDTO;
import br.com.talesayjins.entities.Ubs;
import br.com.talesayjins.services.utils.UbsCSV;
import br.com.talesayjins.services.UbsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin
@RestController
@Controller
@RequestMapping("/api/v1")
public class UbsController {

    @Autowired
    UbsService fileService;

    @ApiOperation(value = "Importando arquivo ubs para o banco H2")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestPart("file") MultipartFile file) {
        String message = "";

        if (UbsCSV.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded do arquivo com sucesso: " + file.getOriginalFilename();

                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/csv/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
            } catch (Exception e) {
                message = "Não foi possível realizar o upload do arquivo: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
            }
        }

        message = "Por favor, escolha o arquivo usb.csv!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
    }

    @ApiOperation(value = "Realizando o download do banco para um arquivo.csv")
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        InputStreamResource file = new InputStreamResource(fileService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @ApiOperation(value = "Realizar pesquisa pela latitude e longitude")
    @GetMapping("/find_ubs")
    public ResponseEntity<ResponsePagination<Page<UbsDTO>>> findUbs(
            @RequestParam(value="query", defaultValue="-,-") String query,
            @RequestParam(value="page", defaultValue="1") Integer page,
            @RequestParam(value="perPage", defaultValue="10") Integer perPage) {
        Page<Ubs> list = fileService.search(query, page, perPage);
        Page<UbsDTO> listDto = list.map(obj -> new UbsDTO(obj));
        return ResponseEntity.ok().body(new ResponsePagination(listDto));
    }
}

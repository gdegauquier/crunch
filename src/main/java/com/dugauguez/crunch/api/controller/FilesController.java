package com.dugauguez.crunch.api.controller;

import com.dugauguez.crunch.api.Endpoints;
import com.dugauguez.crunch.backend.model.Task;
import com.dugauguez.crunch.backend.service.FilesService;
import com.dugauguez.crunch.backend.utils.FilesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@Api(value = FilesController.GROUP_FILES,
        produces = MediaType.APPLICATION_JSON_VALUE,
        tags = {FilesController.GROUP_FILES})
public class FilesController {

    public static final String GROUP_FILES = "Files";

    @Autowired
    FilesService filesService;

    @ApiOperation(value = "Create Files",
            nickname = "Create Files",
            tags = {FilesController.GROUP_FILES})
    @GetMapping(value = Endpoints.FILES,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> createFiles(

            @ApiParam(value = "Type")
            @RequestParam(value = "type") String type,

            @ApiParam(value = "Year")
            @RequestParam(value = "year") String year,

            @ApiParam(value = "Department")
            @RequestParam(value = "department") String department

    ) throws IOException {


        if (!FilesUtils.isValidType(type)) {
            // TODO: handle badrequest
        }

        // TODO: valid year

        // TODO: department

        filesService.createFiles(type, year, department);

        return ResponseEntity.ok(Task.builder()
                                     .name(type)
                                     .status(HttpStatus.CONTINUE.toString())
                                     .build());
    }

}

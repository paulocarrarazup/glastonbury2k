package br.com.zup.inventory.controller;

import br.com.zup.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.inventory.controller.request.BookRequest;

@RestController
@RequestMapping("/inventory")
public class InventoryController implements InventoryApi{

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void book(@RequestBody BookRequest request) {
        System.out.println(request.getItems());
    }
}

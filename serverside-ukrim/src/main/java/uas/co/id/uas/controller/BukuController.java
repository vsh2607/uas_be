package uas.co.id.uas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uas.co.id.uas.model.Buku;
import uas.co.id.uas.service.BukuService;

@RestController
@RequestMapping("/buku")
public class BukuController {

    private BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

   
    @GetMapping
    public List<Buku> getAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities()                );
        return bukuService.getAll();
    }

    @GetMapping("/{id}")
    public Buku getById(@PathVariable Long id) {
        return bukuService.getById(id);
    }

  
    @PostMapping
    public Buku create(@RequestBody Buku buku) {
        return bukuService.create(buku);
    }

  
    @PutMapping("/{id}")
    public Buku update(@PathVariable Long id, @RequestBody Buku buku) {
        return bukuService.update(id, buku);
    }

    @DeleteMapping("/{id}")
    public Buku delete(@PathVariable Long id) {
        return bukuService.delete(id);
    }
}

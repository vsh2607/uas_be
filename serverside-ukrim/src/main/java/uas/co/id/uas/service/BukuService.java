package uas.co.id.uas.service;

import java.util.List;
import lombok.AllArgsConstructor;
import uas.co.id.uas.model.Buku;
import uas.co.id.uas.repository.BukuRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class BukuService {

    private BukuRepository bukuRepository;

    public List<Buku> getAll() {
        return bukuRepository.findAll();
    }

    public Buku getById(Long id) {
        return bukuRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku not found")
                );
    }

    public Buku create(Buku buku) {
        if (buku.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Buku already exists"
            );
        }
        if (bukuRepository.existsByName( buku.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "buku name already exists");
        }
        return bukuRepository.save(buku);
    }

    public Buku update(Long id, Buku buku) {
        getById(id);
        buku.setId(id);
        return bukuRepository.save(buku);
    }

    public Buku delete(Long id) {
        Buku buku = getById(id);
        bukuRepository.delete(buku);
        return buku;
    }
}

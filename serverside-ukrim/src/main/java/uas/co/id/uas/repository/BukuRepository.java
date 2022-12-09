package uas.co.id.uas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uas.co.id.uas.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    Boolean existsByName(String name);
}

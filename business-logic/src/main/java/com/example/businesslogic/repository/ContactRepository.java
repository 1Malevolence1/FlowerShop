package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.suppliers.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

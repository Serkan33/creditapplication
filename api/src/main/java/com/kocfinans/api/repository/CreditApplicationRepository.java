package com.kocfinans.api.repository;

import com.kocfinans.api.model.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, UUID> {
}

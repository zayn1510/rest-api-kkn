package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Log,Integer> { }

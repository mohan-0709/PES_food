package com.pes_food.repository;

import com.pes_food.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findByEmail(String email);

	public CurrentUserSession findByPrivateKey(String key);
}

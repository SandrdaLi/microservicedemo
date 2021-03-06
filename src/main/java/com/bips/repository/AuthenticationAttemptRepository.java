package com.bips.repository;

import com.bips.model.AuthenticationAttempt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ahadcse on 26/04/16.
 */
public interface AuthenticationAttemptRepository extends CrudRepository<AuthenticationAttempt, Long> {

    public List<AuthenticationAttempt> findByUsername(String username);

    public List<AuthenticationAttempt> findByUsernameAndAuthAttemptResult(String username, AuthenticationAttempt.AuthAttemptResult result);

    public Page<AuthenticationAttempt> findByUsernameAndAuthAttemptResult(String username, AuthenticationAttempt.AuthAttemptResult result, Pageable pageable);

    public List<AuthenticationAttempt> deleteByUsername(String username);
}

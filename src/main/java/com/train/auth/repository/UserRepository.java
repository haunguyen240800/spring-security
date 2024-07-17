package com.train.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.auth.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	boolean existsByEmail(String email);
	
	Optional<User> findByUserUid(Long userUid);
	
	
	/*
	 * @Query(value = "CALL proc_gen_id(:seqName, @result);", nativeQuery = true)
	 * Object setSeq(@Param("seqName") String seqName) throws SQLException;
	 * 
	 * @Query(value = "SELECT @result", nativeQuery = true) String getSeq() throws
	 * SQLException;
	 */
	
}

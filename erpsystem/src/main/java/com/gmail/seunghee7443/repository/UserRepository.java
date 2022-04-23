/*
 * User Entity에서 생성한 DB를 접근하기 위한 Method들을 사용하기 위한 Interface
 */

package com.gmail.seunghee7443.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gmail.seunghee7443.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("select * from erp_user_info where user_id = :user_id")
	Optional<User> findUserId(String id);
}

/*
 * Client Entity에서 생성한 DB를 접근하기 위한 Method들을 사용하기 위한 Interface
 */

package com.gmail.seunghee7443.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.gmail.seunghee7443.entity.Client;

// 동적 처리를 위해 querydsl를 build.gradle에 사전등록 해놓음
public interface ClientRepository extends JpaRepository<Client, String>, QuerydslPredicateExecutor<Client> {

}

package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.TUser;

@Repository
public interface UserRepository extends PagingAndSortingRepository<TUser,Long>{

}

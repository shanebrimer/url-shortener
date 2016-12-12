package com.craft.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.craft.demo.model.UrlMapping;

@Repository
public interface UrlMappingRepository extends CrudRepository<UrlMapping, String> {
}

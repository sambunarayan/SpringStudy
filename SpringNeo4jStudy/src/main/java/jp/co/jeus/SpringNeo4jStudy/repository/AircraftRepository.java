package jp.co.jeus.SpringNeo4jStudy.repository;

import org.springframework.data.repository.CrudRepository;

import jp.co.jeus.SpringNeo4jStudy.domain.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long>{

}

package jp.co.jeus.SpringMongoStudy.repository;

import org.springframework.data.repository.CrudRepository;

import jp.co.jeus.SpringMongoStudy.domain.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, String> {

}

package jp.co.jeus.SpringBootMvcStudy.repository;

import org.springframework.data.repository.CrudRepository;

import jp.co.jeus.SpringBootMvcStudy.domain.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}

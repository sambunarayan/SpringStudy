package jp.co.jeus.SpringDataStudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.jeus.SpringDataStudy.entity.Aircraft;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}

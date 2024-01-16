package jp.co.SpringWebSocketStudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.SpringWebSocketStudy.entity.Aircraft;



@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}

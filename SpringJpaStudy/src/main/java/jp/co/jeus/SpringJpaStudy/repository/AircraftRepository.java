package jp.co.jeus.SpringJpaStudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.jeus.SpringJpaStudy.entity.Aircraft;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long>{

}

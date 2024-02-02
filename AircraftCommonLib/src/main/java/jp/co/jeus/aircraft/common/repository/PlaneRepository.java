package jp.co.jeus.aircraft.common.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import jp.co.jeus.aircraft.common.entity.Aircraft;

public interface PlaneRepository extends ReactiveCrudRepository<Aircraft, String>{

}

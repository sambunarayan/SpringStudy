package jp.co.jeus.SpringBootReactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import jp.co.jeus.SpringBootReactive.entity.Aircraft;

public interface PlaneRepository extends ReactiveCrudRepository<Aircraft, String>{

}

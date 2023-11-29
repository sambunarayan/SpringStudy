package jp.co.jeus.springbootstudy.repository;

import org.springframework.data.repository.CrudRepository;

import jp.co.jeus.springbootstudy.entity.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}

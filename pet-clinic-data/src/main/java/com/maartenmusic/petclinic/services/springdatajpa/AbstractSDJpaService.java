package com.maartenmusic.petclinic.services.springdatajpa;

import com.maartenmusic.petclinic.model.BaseEntity;
import com.maartenmusic.petclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSDJpaService<T extends BaseEntity, R extends CrudRepository<T, Long>>
        implements CrudService<T, Long> {

    protected R repository;

    public AbstractSDJpaService() {
    }

    public AbstractSDJpaService(R repository) {
        this.repository = repository;
    }

    @Override
    public Set<T> findAll() {
        Set<T> set = new HashSet<>();
        repository.findAll().forEach(set::add);

        return set;
    }

    @Override
    public T findById(Long id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

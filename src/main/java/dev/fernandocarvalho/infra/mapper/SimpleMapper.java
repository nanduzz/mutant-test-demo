package dev.fernandocarvalho.infra.mapper;

public interface SimpleMapper<D,E> {

    E toEntity(D d);

    D toDto(E d);
}

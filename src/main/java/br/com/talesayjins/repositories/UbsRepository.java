package br.com.talesayjins.repositories;

import br.com.talesayjins.entities.Ubs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UbsRepository extends JpaRepository<Ubs, Integer> {
    @Transactional(readOnly=true)
    @Query(value = "select u from Ubs u where u.latitude like CONCAT('%',:lat,'%') and u.longitude like CONCAT('%',:lng,'%')")
    Page<Ubs> findAllByLatitudeAndLongitude(@Param("lat") String lat, @Param("lng") String lng, Pageable pageable);


}



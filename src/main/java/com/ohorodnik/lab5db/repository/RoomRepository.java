package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Query("SELECT 100-count(t.idRoom) " +
            "FROM Room t WHERE t.dataOfEviction < :data")
    List<Long> countFreeRoomForThisPeriod(@Param("data")LocalDate data);

    @Query("SELECT count(room.idRoom) FROM Room room WHERE room.building.idBuilding=:building")
    List<Long>countFreeRoomForSpecifiedCharacteristicForThisPeriod(@Param("building") int building);

    @Query("SELECT 100-count(t.idRoom) " +
            "FROM Room t WHERE t.dataOfEviction < :data")
    List<Long> countFreeRoomGeneral(@Param("data")LocalDate data);


            /*
             @Query("select c from Consumer c where c.phonenumber.street.mtc_id = :mtc_id")
    List<Consumer> getConsumersByPhonenumberStreetMtc_Id(@Param("mtc_id") long mtc_id);

    @Query("select count(c) from Consumer c where c.phonenumber.street.mtc_id = :mtc_id")
    int countConsumersByPhonenumberStreetMtc_Id(@Param("mtc_id") long mtc_id);

    @Query("select count(c) from Consumer c where c.beneficiary = true")
    int countConsumersByBeneficiaryIsTrue();

    @Query("select count(c) from Consumer c where c.age between :firstAge and :lastAge")
    int countConsumersByAgeIsBetween(@Param("firstAge") int firstAge,@Param("lastAge") int lastAge);
            */
}

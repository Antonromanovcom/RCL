package ru.reso.calclogcompare.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ru.reso.calclogcompare.model.WsCalcLogsNew;

import java.util.List;

public interface WsCalcLogsNewDAO extends JpaRepository<WsCalcLogsNew, Long> {

    @Procedure(name = "in_only_test")
    List<WsCalcLogsNew> inOnlyTest(@Param("v_calcId") Integer inParam1);
    //void inOnlyTest(@Param("inParam1") String inParam1);


}

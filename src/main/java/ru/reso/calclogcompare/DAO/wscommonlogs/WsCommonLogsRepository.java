package ru.reso.calclogcompare.DAO.wscommonlogs;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.reso.calclogcompare.model.WsCommonLogs;

public interface WsCommonLogsRepository extends JpaRepository<WsCommonLogs, Long> {
}

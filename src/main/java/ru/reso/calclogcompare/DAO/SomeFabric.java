package ru.reso.calclogcompare.DAO;

import ru.reso.calclogcompare.model.LoggingEntity;
import ru.reso.calclogcompare.service.factories.AbstractFactory;

public interface SomeFabric {

    LoggingEntity getEntity(Long calcId);
}

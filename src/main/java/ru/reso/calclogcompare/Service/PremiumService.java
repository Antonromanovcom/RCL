package ru.reso.calclogcompare.Service;

import ru.reso.calclogcompare.model.Premium;

import java.util.List;

public interface PremiumService {

    Premium getPremById(Long id);

    List<Premium> getAllInString();

    Premium getPremById2(Integer id);

}

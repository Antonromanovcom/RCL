package ru.reso.calclogcompare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reso.calclogcompare.DAO.PremiumDAO;
import ru.reso.calclogcompare.model.Premium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class PremiumServiceImpl implements PremiumService {

   @Autowired
    private PremiumDAO DAORepository;

    public Premium getPremById(Long id) {
        return DAORepository.findOne(id);
    }

    @Override
    public List<Premium> getAllInString() {
        List<Premium> result = new ArrayList<>();


        for (String name : DAORepository.getAllSerials()) {
            result.add(new Premium(name));
        }

        return result;
    }

    @Override
    public Premium getPremById2(Integer id) {
        return DAORepository.getPremiumById(Long.valueOf(1));
    }
}

package ru.reso.calclogcompare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reso.calclogcompare.DAO.PremiumDAO;
import ru.reso.calclogcompare.model.Premium;

@Service
public class PremiumServiceImpl implements PremiumService {

   @Autowired
    private PremiumDAO DAORepository;


   /* @Autowired
    public PremiumServiceImpl(PremiumDAO DAORepository) {
        this.DAORepository = DAORepository;
    }*/


    public Premium getPremById(Long id) {
        //return DAORepository.getPremiumByID(id);
     //   return DAORepository.getPremiumByID(id);
        return DAORepository.findOne(id);
    }

}

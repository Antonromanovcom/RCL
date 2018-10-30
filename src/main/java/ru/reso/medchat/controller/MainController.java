package ru.reso.medchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.reso.medchat.model.ComparableValues;
import ru.reso.medchat.service.ResoComparator;
import ru.reso.medchat.model.CalcID;
import java.util.LinkedHashMap;

/**
 * @author ROMAB
 * <p>
 * Это основной контроллер, который как раз и обрабатывает все перемещения по страничкам сервиса.
 */
@Controller
public class MainController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        return "start";
    }


    /**
     * Основной по сути метод, выдающий собственно результаты...
     *
     * @param calcID - класс, инкапсулирующий calcid 1 и calcid 2
     * @param result
     * @param model  - модель - связующее звено между сервером и контентом JSP-страницы.
     * @return - а возвращаем мы собственно ссылку на страницу как редирект.
     */
    @RequestMapping(value = "/he", method = RequestMethod.POST)
    public String submit(@ModelAttribute("CalcId") CalcID calcID, BindingResult result, ModelMap model) {

        String returnURL = "result"; // изначальная ссылка на страницу

        model.addAttribute("calcid1", calcID.getCalcId());
        model.addAttribute("calcid2", calcID.getCalcIdSecond());
        model.addAttribute("type", calcID.getType()); // тип отчета, который хотим увидеть

        if ((calcID.getType() == null) || (calcID.getCalcId() == null) || (calcID.getCalcIdSecond() == null)) { // проверка чтобы был выбран ТИП и calcid (оба) не были пустыми
            return "error1"; // если пустые, то переадресовываем на страничку ошибки.
        } else {


            /**
             * В этом коммите (и последующих) я убрал Light-версию отчета, ибо как оказалось, показывать просто результат сравнения без занчений не нужно.
             */

            ResoComparator resoComparator = new ResoComparator();

            // Смотрим какой тип отчета выбран:
            switch (calcID.getType()) {
                case 1:
                    // Проверяем не больше ли у нас значений в коэфициентах по calcid 2 чем по calcid 1. Если больше, меняем местами....
                    if ((resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond())) == 2) {
                        model.addAttribute("calcid1", calcID.getCalcIdSecond());
                        model.addAttribute("calcid2", calcID.getCalcId());
                    }

                    // Наполняем ХэшМеп WsCalcLog
                    LinkedHashMap<String, ComparableValues> fullCompareResult = resoComparator.wsCalcLogsNewCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);
                    // Наполняем ХэшМеп Коэфициентов
                    LinkedHashMap<String, ComparableValues> fullCoefsCompareResult = resoComparator.coeffCompare2(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

                    // Проверяем не пустой ли ХэшМеп
                    if (fullCoefsCompareResult.isEmpty()) {
                        fullCoefsCompareResult.clear();
                    }

                    // Наполняем Премии
                    LinkedHashMap<String, ComparableValues> bonuses = resoComparator.bonusesCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

                    if (bonuses.isEmpty()) {
                        bonuses.clear();
                    }

                    // Наполняем Водителей
                    LinkedHashMap<String, ComparableValues> drivers = resoComparator.driversCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

                    if (drivers.isEmpty()) {
                        drivers.clear();
                    }

                    // Наполняем Партнеров
                    LinkedHashMap<String, ComparableValues> partners = resoComparator.partnersCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

                    if (partners.isEmpty()) {
                        partners.clear();
                    }


                    // Наполняем Common Logs
                    LinkedHashMap<String, ComparableValues> commonLogs = resoComparator.commonLogsCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 1);

                    if (commonLogs.isEmpty()) {
                        commonLogs.clear();
                    }

                    // А дальше все это заливаем в Model для, собственно, отражения на Моделе
                    model.addAttribute("map", fullCompareResult);
                    model.addAttribute("coefs", fullCoefsCompareResult);
                    model.addAttribute("bonuses", bonuses);
                    model.addAttribute("drivers", drivers);
                    model.addAttribute("partners", partners);
                    model.addAttribute("commonLogs", commonLogs);


                    returnURL = "fullreport";
                    break;


                case 2: // отображдение только несоответствий

                    // Так же меняем местами в случае несоответствия записей для коэфициентов по кальк-айди
                    if ((resoComparator.checkMoreOrLess(calcID.getCalcId(), calcID.getCalcIdSecond())) == 2) {
                        model.addAttribute("calcid1", calcID.getCalcIdSecond());
                        model.addAttribute("calcid2", calcID.getCalcId());
                    }

                    // наполняем ХэшМепы
                    LinkedHashMap<String, ComparableValues> fullCompareResultButOnlyDifferences = resoComparator.wsCalcLogsNewCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);
                    LinkedHashMap<String, ComparableValues> fullCoefsCompareResultButOnlyDifferences = resoComparator.coeffCompare2(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);
                    LinkedHashMap<String, ComparableValues> bonusesOnlyDifference = resoComparator.bonusesCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);
                    LinkedHashMap<String, ComparableValues> driversOnlyDifference = resoComparator.driversCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);


                    if (driversOnlyDifference.isEmpty()) {
                        driversOnlyDifference.clear();
                    }


                    LinkedHashMap<String, ComparableValues> partnersOnlyDifference = resoComparator.partnersCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);

                    if (partnersOnlyDifference.isEmpty()) {
                        partnersOnlyDifference.clear();
                    }

                    LinkedHashMap<String, ComparableValues> commonLogsOnlyDifference = resoComparator.commonLogsCompare(calcID.getCalcId(), calcID.getCalcIdSecond(), 2);

                    model.addAttribute("map", fullCompareResultButOnlyDifferences);
                    model.addAttribute("coefs", fullCoefsCompareResultButOnlyDifferences);
                    model.addAttribute("bonuses", bonusesOnlyDifference);
                    model.addAttribute("drivers", driversOnlyDifference);
                    model.addAttribute("partners", partnersOnlyDifference);
                    model.addAttribute("commonLogs", commonLogsOnlyDifference);
                    returnURL = "fullreport";
                    break;
            }
        }

        return returnURL;
    }

    //Переход на страницу ввода calc id и выбора типа отчетов
    @RequestMapping(value = "/ho", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "CalcId", new CalcID());
    }


}

package ru.reso.calclogcompare.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedHashMap;


@Entity
@Table(name = "WS_CALC_LOGS_NEW_TEMP_COPY")
public class WsCalcLogsNew implements LoggingEntity {
    /**
     * CalcID - ID расчета.
     */
    @Id
    @Column(name = "CALCID", nullable = false)
    @Getter
    @Setter
    private long calcid;



    /**
     * Признак не применять коммерческие программы при расчете премии.
     */
    @Getter
    @Setter
    private String notapplyspecprogdiscount;

    /**
     * Название компании, для которой делается расчет.
     */
    @Getter
    @Setter
    private String targetcompany;

    /**
     * Код страхователя в системе.
     */
    @Getter
    @Setter
    private Integer insurantid;

    /**
     * Код собственника ТС в системе.
     */
    @Getter
    @Setter
    private Integer carownerid;

    /**
     * Название марки ТС.
     */
    @Getter
    @Setter
    private String carbrandname;

    /**
     * Название модели ТС.
     */
    @Getter
    @Setter
    private String carmodelname;

    /**
     * Тип ТС КАСКО.
     */
    @Getter
    @Setter
    private String cartype;

    /**
     * Номер кузова ТС.
     */
    @Getter
    @Setter
    private String carbodynumber;

    /**
     * Номер шасси ТС.
     */
    @Getter
    @Setter
    private String carchassisnumber;

    /**
     * ТС находится в залоге.
     */
    @Getter
    @Setter
    private String creditauto;

    /**
     * Код кредитной организации.
     */
    @Getter
    @Setter
    private Integer lenderid;

    /**
     * Пробег менее 1000 км (новое ТС).
     */
    @Getter
    @Setter
    private String autorace;

    /**
     * Вид ТС (3 - пасажирские авто).
     */
    @Getter
    @Setter
    private Long carkind;

    /**
     * Тип производства ТС (иностранное/отечественное).
     */
    @Getter
    @Setter
    private Long carvendortype;

    /**
     * Цена ТС в руб.
     */
    @Getter
    @Setter
    private Long carprice;

    /**
     * Руль находится с правой стороны.
     */
    @Getter
    @Setter
    private String rightwheel;

    /**
     * Код спутниковой противоугонной системы.
     */
    @Getter
    @Setter
    private Long antitheftsystem;

    /**
     * Механическое противоугонное устройство.
     */
    @Getter
    @Setter
    private String thfmechdevice;

    /**
     * Дата приобретения ТС.
     */
    @Getter
    @Setter
    private Time carpurchasedate;

    /**
     * Кол-во ТС в парке.
     */
    @Getter
    @Setter
    private Integer carparkcount;

    /**
     * Мощность ТС, л.с.
     */
    @Getter
    @Setter
    private Integer powerauto;

    /**
     * ТС используется с прицепом.
     */
    @Getter
    @Setter
    private String carusedtrailer;

    /**
     * НС страховая сумма за одно место в ТС.
     */
    @Getter
    @Setter
    private Long caraccidentplaceinssum;

    /**
     * НС система страхования.
     */
    @Getter
    @Setter
    private Long caraccidentplacekind;

    /**
     * НС кол-во страхуемых мест.
     */
    @Getter
    @Setter
    private Integer caraccidentplacenum;

    /**
     * ДО страховая сумма.
     */
    @Getter
    @Setter
    private Long carextequipmentinssum;

    /**
     * ОСАГО I Период использования ТС с.
     */
    @Getter
    @Setter
    private Time insfromdate1;

    /**
     * ОСАГО I Период использования ТС по.
     */
    @Getter
    @Setter
    private Time instodate1;

    /**
     * ОСАГО II Период использования ТС с.
     */
    @Getter
    @Setter
    private Time insfromdate2;

    /**
     * ОСАГО II Период использования ТС по.
     */
    @Getter
    @Setter
    private Time instodate2;

    /**
     * ОСАГО III Период использования ТС с.
     */
    @Getter
    @Setter
    private Time insfromdate3;

    /**
     * ОСАГО III Период использования ТС по.
     */
    @Getter
    @Setter
    private Time instodate3;

    /**
     * ОСАГО Регион использования ТС.
     */
    @Getter
    @Setter
    private Integer caruseregion;

    /**
     * ОСАГО Регион использование ТС, код КЛАДР.
     */
    @Getter
    @Setter
    private String caruseregionkladr;

    /**
     * ОСАГО Категория ТС.
     */
    @Getter
    @Setter
    private Long carcategory;

    /**
     * ОСАГО Период использования ТС.
     */
    @Getter
    @Setter
    private Long perioduse;

    /**
     * ОСАГО Тип использования ТС.
     */
    @Getter
    @Setter
    private String carvehicletypeosago;

    /**
     * ДГО Страховая сумма.
     */
    @Getter
    @Setter
    private Long inssumdgo;

    /**
     * ДГО с учетом износа.
     */
    @Getter
    @Setter
    private String withweardgo;

    /**
     * Неизвестное поле, связанное с кбм.
     */
    @Getter
    @Setter
    private String kbmcheckcardiagnisticcard;

    /**
     * Наличие риска "Каско".
     */
    @Getter
    @Setter
    private String casco;

    /**
     * Наличие риска "Ущерб".
     */
    @Getter
    @Setter
    private String damage;

    /**
     * Наличие риска "Хищение".
     */
    @Getter
    @Setter
    private String theft;

    /**
     * Наличие риска "Ресо Автопомощь".
     */
    @Getter
    @Setter
    private String help;

    /**
     * Наличие риска "Гап".
     */
    @Getter
    @Setter
    private String gap;

    /**
     * Наличие риска "Несчастный Случай".
     */
    @Getter
    @Setter
    private String accident;

    /**
     * Наличие риска "Доп Оборудование".
     */
    @Getter
    @Setter
    private String equipment;

    /**
     * Наличие риска "Осаго".
     */
    @Getter
    @Setter
    private String osago;

    /**
     * Наличие риска "ДГО".
     */
    @Getter
    @Setter
    private String dgo;

    /**
     * Номер бланка возобновляемого (пролонгируемого) полиса.
     */
    @Getter
    @Setter
    private String pnumber;

    /**
     * ID типа программы скидок применяемой при расчете полиса.
     */
    @Getter
    @Setter
    private Integer commercprogrammid;

    /**
     * ID тип собственника тс.
     */
    @Getter
    @Setter
    private Long carownertypeid;

    /**
     * ID тип страхователя.
     */
    @Getter
    @Setter
    private Long insuranttypeid;

    /**
     * Количество убытков (указал пользователь).
     */
    @Getter
    @Setter
    private Byte cardamagequanitymanual;

    /**
     * Страхователь перешел из другой СК.
     */
    @Getter
    @Setter
    private String isanothersk;

    /**
     * Код страховой компании , из которой перешел страхователь.
     */
    @Getter
    @Setter
    private Long insurer;

    /**
     * Регион места жительства собственика КАСКО.
     */
    @Getter
    @Setter
    @Column(name = "OWNER_REGION", nullable = true, precision = 0)
    private Long ownerRegion;

    /**
     * Тип списка лиц допущенных к управлению.
     */
    @Getter
    @Setter
    private String driverlisttype;

    /**
     * Код модели ТС.
     */
    @Getter
    @Setter
    private Long carmodelcode;

    /**
     * Номер полиса, в котором производился расчет.
     */
    @Getter
    @Setter
    private Integer policy;

    /**
     * Тип списка лиц допущенных к управлению ОСАГО.
     */
    @Getter
    @Setter
    private String driverlisttypeosago;

    /**
     * Год выпуска ТС.
     */
    @Getter
    @Setter
    private Integer caryear;

    /**
     * Имя пользователя, который осуществлял расчет из программы полисы.
     */
    @Getter
    @Setter
    private String admuser;

    /**
     * Наличие риска "СТОЛКНОВЕНИЕ".
     */
    @Getter
    @Setter
    private String crash;

    /**
     * Идентификатор страхователя в системе Equifax.
     */
    @Getter
    @Setter
    private Long holderrequestid;

    /**
     * Идентификатор собственника в системе Equifax.
     */
    @Getter
    @Setter
    private Long ownerrequestid;

    /**
     * скоринг балл   в системе Equifax.
     */
    @Getter
    @Setter
    private Integer equifaxscore;

    /**
     * Ошибка EquiFax.
     */
    @Getter
    @Setter
    private String equifaxerrmsg;

    /**
     * Тип полиса (0 - первоначальный, 1 - пролонгация).
     */
    @Getter
    @Setter
    private Boolean policytype;

    /**
     * Тип полиса (0 - первоначальный, 1 - пролонгация).
     */
    @Getter
    @Setter
    private Long customkb;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WsCalcLogsNew that = (WsCalcLogsNew) o;

        if (calcid != that.calcid) return false;
        if (notapplyspecprogdiscount != null ? !notapplyspecprogdiscount.equals(that.notapplyspecprogdiscount) : that.notapplyspecprogdiscount != null)
            return false;
        if (targetcompany != null ? !targetcompany.equals(that.targetcompany) : that.targetcompany != null)
            return false;
        if (insurantid != null ? !insurantid.equals(that.insurantid) : that.insurantid != null) return false;
        if (carownerid != null ? !carownerid.equals(that.carownerid) : that.carownerid != null) return false;
        if (carbrandname != null ? !carbrandname.equals(that.carbrandname) : that.carbrandname != null) return false;
        if (carmodelname != null ? !carmodelname.equals(that.carmodelname) : that.carmodelname != null) return false;
        if (cartype != null ? !cartype.equals(that.cartype) : that.cartype != null) return false;
        if (carbodynumber != null ? !carbodynumber.equals(that.carbodynumber) : that.carbodynumber != null)
            return false;
        if (carchassisnumber != null ? !carchassisnumber.equals(that.carchassisnumber) : that.carchassisnumber != null)
            return false;
        if (creditauto != null ? !creditauto.equals(that.creditauto) : that.creditauto != null) return false;
        if (lenderid != null ? !lenderid.equals(that.lenderid) : that.lenderid != null) return false;
        if (autorace != null ? !autorace.equals(that.autorace) : that.autorace != null) return false;
        if (carkind != null ? !carkind.equals(that.carkind) : that.carkind != null) return false;
        if (carvendortype != null ? !carvendortype.equals(that.carvendortype) : that.carvendortype != null)
            return false;
        if (carprice != null ? !carprice.equals(that.carprice) : that.carprice != null) return false;
        if (rightwheel != null ? !rightwheel.equals(that.rightwheel) : that.rightwheel != null) return false;
        if (antitheftsystem != null ? !antitheftsystem.equals(that.antitheftsystem) : that.antitheftsystem != null)
            return false;
        if (thfmechdevice != null ? !thfmechdevice.equals(that.thfmechdevice) : that.thfmechdevice != null)
            return false;
        if (carpurchasedate != null ? !carpurchasedate.equals(that.carpurchasedate) : that.carpurchasedate != null)
            return false;
        if (carparkcount != null ? !carparkcount.equals(that.carparkcount) : that.carparkcount != null) return false;
        if (powerauto != null ? !powerauto.equals(that.powerauto) : that.powerauto != null) return false;
        if (carusedtrailer != null ? !carusedtrailer.equals(that.carusedtrailer) : that.carusedtrailer != null)
            return false;
        if (caraccidentplaceinssum != null ? !caraccidentplaceinssum.equals(that.caraccidentplaceinssum) : that.caraccidentplaceinssum != null)
            return false;
        if (caraccidentplacekind != null ? !caraccidentplacekind.equals(that.caraccidentplacekind) : that.caraccidentplacekind != null)
            return false;
        if (caraccidentplacenum != null ? !caraccidentplacenum.equals(that.caraccidentplacenum) : that.caraccidentplacenum != null)
            return false;
        if (carextequipmentinssum != null ? !carextequipmentinssum.equals(that.carextequipmentinssum) : that.carextequipmentinssum != null)
            return false;
        if (insfromdate1 != null ? !insfromdate1.equals(that.insfromdate1) : that.insfromdate1 != null) return false;
        if (instodate1 != null ? !instodate1.equals(that.instodate1) : that.instodate1 != null) return false;
        if (insfromdate2 != null ? !insfromdate2.equals(that.insfromdate2) : that.insfromdate2 != null) return false;
        if (instodate2 != null ? !instodate2.equals(that.instodate2) : that.instodate2 != null) return false;
        if (insfromdate3 != null ? !insfromdate3.equals(that.insfromdate3) : that.insfromdate3 != null) return false;
        if (instodate3 != null ? !instodate3.equals(that.instodate3) : that.instodate3 != null) return false;
        if (caruseregion != null ? !caruseregion.equals(that.caruseregion) : that.caruseregion != null) return false;
        if (caruseregionkladr != null ? !caruseregionkladr.equals(that.caruseregionkladr) : that.caruseregionkladr != null)
            return false;
        if (carcategory != null ? !carcategory.equals(that.carcategory) : that.carcategory != null) return false;
        if (perioduse != null ? !perioduse.equals(that.perioduse) : that.perioduse != null) return false;
        if (carvehicletypeosago != null ? !carvehicletypeosago.equals(that.carvehicletypeosago) : that.carvehicletypeosago != null)
            return false;
        if (inssumdgo != null ? !inssumdgo.equals(that.inssumdgo) : that.inssumdgo != null) return false;
        if (withweardgo != null ? !withweardgo.equals(that.withweardgo) : that.withweardgo != null) return false;
        if (kbmcheckcardiagnisticcard != null ? !kbmcheckcardiagnisticcard.equals(that.kbmcheckcardiagnisticcard) : that.kbmcheckcardiagnisticcard != null)
            return false;
        if (casco != null ? !casco.equals(that.casco) : that.casco != null) return false;
        if (damage != null ? !damage.equals(that.damage) : that.damage != null) return false;
        if (theft != null ? !theft.equals(that.theft) : that.theft != null) return false;
        if (help != null ? !help.equals(that.help) : that.help != null) return false;
        if (gap != null ? !gap.equals(that.gap) : that.gap != null) return false;
        if (accident != null ? !accident.equals(that.accident) : that.accident != null) return false;
        if (equipment != null ? !equipment.equals(that.equipment) : that.equipment != null) return false;
        if (osago != null ? !osago.equals(that.osago) : that.osago != null) return false;
        if (dgo != null ? !dgo.equals(that.dgo) : that.dgo != null) return false;
        if (pnumber != null ? !pnumber.equals(that.pnumber) : that.pnumber != null) return false;
        if (commercprogrammid != null ? !commercprogrammid.equals(that.commercprogrammid) : that.commercprogrammid != null)
            return false;
        if (carownertypeid != null ? !carownertypeid.equals(that.carownertypeid) : that.carownertypeid != null)
            return false;
        if (insuranttypeid != null ? !insuranttypeid.equals(that.insuranttypeid) : that.insuranttypeid != null)
            return false;
        if (cardamagequanitymanual != null ? !cardamagequanitymanual.equals(that.cardamagequanitymanual) : that.cardamagequanitymanual != null)
            return false;
        if (isanothersk != null ? !isanothersk.equals(that.isanothersk) : that.isanothersk != null) return false;
        if (insurer != null ? !insurer.equals(that.insurer) : that.insurer != null) return false;
        if (ownerRegion != null ? !ownerRegion.equals(that.ownerRegion) : that.ownerRegion != null) return false;
        if (driverlisttype != null ? !driverlisttype.equals(that.driverlisttype) : that.driverlisttype != null)
            return false;
        if (carmodelcode != null ? !carmodelcode.equals(that.carmodelcode) : that.carmodelcode != null) return false;
        if (policy != null ? !policy.equals(that.policy) : that.policy != null) return false;
        if (driverlisttypeosago != null ? !driverlisttypeosago.equals(that.driverlisttypeosago) : that.driverlisttypeosago != null)
            return false;
        if (caryear != null ? !caryear.equals(that.caryear) : that.caryear != null) return false;
        if (admuser != null ? !admuser.equals(that.admuser) : that.admuser != null) return false;
        if (crash != null ? !crash.equals(that.crash) : that.crash != null) return false;
        if (holderrequestid != null ? !holderrequestid.equals(that.holderrequestid) : that.holderrequestid != null)
            return false;
        if (ownerrequestid != null ? !ownerrequestid.equals(that.ownerrequestid) : that.ownerrequestid != null)
            return false;
        if (equifaxscore != null ? !equifaxscore.equals(that.equifaxscore) : that.equifaxscore != null) return false;
        if (equifaxerrmsg != null ? !equifaxerrmsg.equals(that.equifaxerrmsg) : that.equifaxerrmsg != null)
            return false;
        if (policytype != null ? !policytype.equals(that.policytype) : that.policytype != null) return false;
        if (customkb != null ? !customkb.equals(that.customkb) : that.customkb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (calcid ^ (calcid >>> 32));
        result = 31 * result + (notapplyspecprogdiscount != null ? notapplyspecprogdiscount.hashCode() : 0);
        result = 31 * result + (targetcompany != null ? targetcompany.hashCode() : 0);
        result = 31 * result + (insurantid != null ? insurantid.hashCode() : 0);
        result = 31 * result + (carownerid != null ? carownerid.hashCode() : 0);
        result = 31 * result + (carbrandname != null ? carbrandname.hashCode() : 0);
        result = 31 * result + (carmodelname != null ? carmodelname.hashCode() : 0);
        result = 31 * result + (cartype != null ? cartype.hashCode() : 0);
        result = 31 * result + (carbodynumber != null ? carbodynumber.hashCode() : 0);
        result = 31 * result + (carchassisnumber != null ? carchassisnumber.hashCode() : 0);
        result = 31 * result + (creditauto != null ? creditauto.hashCode() : 0);
        result = 31 * result + (lenderid != null ? lenderid.hashCode() : 0);
        result = 31 * result + (autorace != null ? autorace.hashCode() : 0);
        result = 31 * result + (carkind != null ? carkind.hashCode() : 0);
        result = 31 * result + (carvendortype != null ? carvendortype.hashCode() : 0);
        result = 31 * result + (carprice != null ? carprice.hashCode() : 0);
        result = 31 * result + (rightwheel != null ? rightwheel.hashCode() : 0);
        result = 31 * result + (antitheftsystem != null ? antitheftsystem.hashCode() : 0);
        result = 31 * result + (thfmechdevice != null ? thfmechdevice.hashCode() : 0);
        result = 31 * result + (carpurchasedate != null ? carpurchasedate.hashCode() : 0);
        result = 31 * result + (carparkcount != null ? carparkcount.hashCode() : 0);
        result = 31 * result + (powerauto != null ? powerauto.hashCode() : 0);
        result = 31 * result + (carusedtrailer != null ? carusedtrailer.hashCode() : 0);
        result = 31 * result + (caraccidentplaceinssum != null ? caraccidentplaceinssum.hashCode() : 0);
        result = 31 * result + (caraccidentplacekind != null ? caraccidentplacekind.hashCode() : 0);
        result = 31 * result + (caraccidentplacenum != null ? caraccidentplacenum.hashCode() : 0);
        result = 31 * result + (carextequipmentinssum != null ? carextequipmentinssum.hashCode() : 0);
        result = 31 * result + (insfromdate1 != null ? insfromdate1.hashCode() : 0);
        result = 31 * result + (instodate1 != null ? instodate1.hashCode() : 0);
        result = 31 * result + (insfromdate2 != null ? insfromdate2.hashCode() : 0);
        result = 31 * result + (instodate2 != null ? instodate2.hashCode() : 0);
        result = 31 * result + (insfromdate3 != null ? insfromdate3.hashCode() : 0);
        result = 31 * result + (instodate3 != null ? instodate3.hashCode() : 0);
        result = 31 * result + (caruseregion != null ? caruseregion.hashCode() : 0);
        result = 31 * result + (caruseregionkladr != null ? caruseregionkladr.hashCode() : 0);
        result = 31 * result + (carcategory != null ? carcategory.hashCode() : 0);
        result = 31 * result + (perioduse != null ? perioduse.hashCode() : 0);
        result = 31 * result + (carvehicletypeosago != null ? carvehicletypeosago.hashCode() : 0);
        result = 31 * result + (inssumdgo != null ? inssumdgo.hashCode() : 0);
        result = 31 * result + (withweardgo != null ? withweardgo.hashCode() : 0);
        result = 31 * result + (kbmcheckcardiagnisticcard != null ? kbmcheckcardiagnisticcard.hashCode() : 0);
        result = 31 * result + (casco != null ? casco.hashCode() : 0);
        result = 31 * result + (damage != null ? damage.hashCode() : 0);
        result = 31 * result + (theft != null ? theft.hashCode() : 0);
        result = 31 * result + (help != null ? help.hashCode() : 0);
        result = 31 * result + (gap != null ? gap.hashCode() : 0);
        result = 31 * result + (accident != null ? accident.hashCode() : 0);
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (osago != null ? osago.hashCode() : 0);
        result = 31 * result + (dgo != null ? dgo.hashCode() : 0);
        result = 31 * result + (pnumber != null ? pnumber.hashCode() : 0);
        result = 31 * result + (commercprogrammid != null ? commercprogrammid.hashCode() : 0);
        result = 31 * result + (carownertypeid != null ? carownertypeid.hashCode() : 0);
        result = 31 * result + (insuranttypeid != null ? insuranttypeid.hashCode() : 0);
        result = 31 * result + (cardamagequanitymanual != null ? cardamagequanitymanual.hashCode() : 0);
        result = 31 * result + (isanothersk != null ? isanothersk.hashCode() : 0);
        result = 31 * result + (insurer != null ? insurer.hashCode() : 0);
        result = 31 * result + (ownerRegion != null ? ownerRegion.hashCode() : 0);
        result = 31 * result + (driverlisttype != null ? driverlisttype.hashCode() : 0);
        result = 31 * result + (carmodelcode != null ? carmodelcode.hashCode() : 0);
        result = 31 * result + (policy != null ? policy.hashCode() : 0);
        result = 31 * result + (driverlisttypeosago != null ? driverlisttypeosago.hashCode() : 0);
        result = 31 * result + (caryear != null ? caryear.hashCode() : 0);
        result = 31 * result + (admuser != null ? admuser.hashCode() : 0);
        result = 31 * result + (crash != null ? crash.hashCode() : 0);
        result = 31 * result + (holderrequestid != null ? holderrequestid.hashCode() : 0);
        result = 31 * result + (ownerrequestid != null ? ownerrequestid.hashCode() : 0);
        result = 31 * result + (equifaxscore != null ? equifaxscore.hashCode() : 0);
        result = 31 * result + (equifaxerrmsg != null ? equifaxerrmsg.hashCode() : 0);
        result = 31 * result + (policytype != null ? policytype.hashCode() : 0);
        result = 31 * result + (customkb != null ? customkb.hashCode() : 0);
        return result;
    }
}

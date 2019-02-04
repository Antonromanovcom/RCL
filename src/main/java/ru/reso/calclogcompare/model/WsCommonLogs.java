package ru.reso.calclogcompare.model;

import javax.persistence.*;
import java.sql.Time;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WS_COMMON_LOGS")
public class WsCommonLogs implements LoggingEntity {

    /**
     * CalcID - ID расчета.
     */
    @Id
    @Column(name = "CALCID", nullable = false)
    @Getter
    @Setter
    private long calcid;


    /**
     * ID Агента.
     */
    @Getter
    @Setter
    private Integer agentid;

    /**
     * ID Агентства.
     */
    @Getter
    @Setter
    private Integer agencyid;

    /**
     * Запрос на расчет полиса.
     */
    @Getter
    @Setter
    @Column(name = "REQUESTMESSAGE", nullable = true, columnDefinition="clob")
    private String requestmessage;

    /**
     * Дата оформления полиса.
     */
    @Getter
    @Setter
    private Time pdate;

    /**
     * Дата начала действия полиса.
     */
    @Getter
    @Setter
    private Time fromdate;

    /**
     * Дата окончания действия полиса.
     */
    @Getter
    @Setter
    private Time todate;

    /**
     * Период оплаты (Единовременно / Ежеквартально /...)
     */
    @Getter
    @Setter
    private Integer payperiod;

    /**
     * Регион приобретения полиса.
     */
    @Getter
    @Setter
    private String purchaseregion;

    /**
     * Территория страхования.
     */
    @Getter
    @Setter
    private Integer insuranceregion;


    /**
     * Вариант оплаты страхового возмещения.
     */
    @Getter
    @Setter
    private Integer damageprogrammstoa;

    /**
     * Вариант оплаты страхового возмещения.
     */
    @Getter
    @Setter
    private String officialstoa;

    /**
     * Рег.номер ТС.
     */
    @Getter
    @Setter
    private String carregnumber;

    /**
     * VIN ТС.
     */
    @Getter
    @Setter
    private String carvin;

    /**
     * Вес, ТС.
     */
    @Getter
    @Setter
    private Integer carweight;

    /**
     * Грузоподъемность ТС.
     */
    @Getter
    @Setter
    private Integer cartonnage;

    /**
     * Кол-во мест в ТС, т.
     */
    @Getter
    @Setter
    private Integer carseats;

    /**
     * ОСАГО Тип использования ТС.
     */
    @Getter
    @Setter
    private Long carusetype;

    /**
     * ОСАГО Регион использования ТС (Регион
     * местажительства собственника).
     */
    @Getter
    @Setter
    private Integer caruseregion;

    /**
     * КБМ РСА Класс.
     */
    @Getter
    @Setter
    private Integer kbmclassfinalosago;

    /**
     * КБМ РСА ИД запроса.
     */
    @Getter
    @Setter
    private Long kbmidrequestrsafinalosago;

    /**
     * КБМ РСА ИД источника получения.
     */
    @Getter
    @Setter
    private Integer kbmidsourcefinalosago;

    /**
     * ХЗ.
     */
    @Getter
    @Setter
    private Long kbmcoefffinalosago;

    /**
     * Примари Кей для таблицы.
     */
    @Getter
    @Setter
    private long id;

    /**
     * Тип запроса (calc, save).
     */
    @Getter
    @Setter
    @Column(name = "REQUESTTYPE", nullable = true, length = 5, columnDefinition = "nvarchar2 (5)")
    private String requesttype;

    /**
     * Ответ.
     */
    @Getter
    @Setter
    @Column(name = "RESPONSEMESSAGE", nullable = true, columnDefinition="clob")
    private String responsemessage;

    /**
     * Программа с представительством.
     */
    @Getter
    @Setter
    @Column(name = "SP_PROGRAMM", nullable = true, precision = 0)
    private Integer spProgramm;

    /**
     * Сервер, с которого пришел запрос.
     */
    @Getter
    @Setter
    private String server;

    /**
     * IP адрес клиента, от которого приходит запрос.
     */
    @Getter
    @Setter
    @Column(name = "CLIENT_IP", nullable = true, length = 15)
    private String clientIp;

    /**
     * ID источника запроса на рассчет премии.
     */
    @Getter
    @Setter
    private Long calcreqsourcetypeid;

    /**
     * ID сессии.
     */
    @Getter
    @Setter
    private String sessionid;

    /**
     * Дата и время отправки запроса.
     */
    @Getter
    @Setter
    private Time admdate;

    /**
     * ....
     */
    @Getter
    @Setter
    @Column(name = "INPUT_MODE", nullable = true, precision = 0)
    private Integer inputMode;

    /**
     * Ошибка при расчете.
     */
    @Getter
    @Setter
    private String error;

    /**
     * Основной номер полиса.
     */
    @Getter
    @Setter
    @Column(name = "MAIN_PNUMBER", nullable = true, length = 255)
    private String mainPnumber;

    /**
     * Дата расчета из ЕИС.
     */
    @Getter
    @Setter
    private Time rasdate;

    /**
     * поле из ЕИС 1.
     */
    @Getter
    @Setter
    @Column(name = "CREATE_MODE", nullable = true, precision = 0)
    private Integer createMode;

    /**
     * поле из ЕИС 2.
     */
    @Getter
    @Setter
    @Column(name = "POLICY_HEADER", nullable = true, precision = 0)
    private Long policyHeader;

    /**
     * поле из ЕИС 3.
     */
    @Getter
    @Setter
    @Column(name = "POLICY_STATE", nullable = true, precision = 0)
    private Integer policyState;

    /**
     * поле из ЕИС 4.
     */
    @Getter
    @Setter
    @Column(name = "PARENT_STATE", nullable = true, precision = 0)
    private Integer parentState;

    /**
     * Номер телефона клиента.
     */
    @Getter
    @Setter
    @Column(name = "CLIENT_PHONE", nullable = true, length = 12)
    private String clientPhone;

    /**
     * Скидка/надбавка за счет комиссионного вознаграждения.
     */
    @Getter
    @Setter
    private Long commission;

   /* @Basic
    @Column(name = "CALCID", nullable = false, precision = 0)
    public long getCalcid() {
        return calcid;
    }

    public void setCalcid(long calcid) {
        this.calcid = calcid;
    }

    @Basic
    @Column(name = "AGENTID", nullable = true, precision = 0)
    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    @Basic
    @Column(name = "AGENCYID", nullable = true, precision = 0)
    public Integer getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(Integer agencyid) {
        this.agencyid = agencyid;
    }

    @Basic
    @Column(name = "REQUESTMESSAGE", nullable = true)
    public String getRequestmessage() {
        return requestmessage;
    }

    public void setRequestmessage(String requestmessage) {
        this.requestmessage = requestmessage;
    }

    @Basic
    @Column(name = "PDATE", nullable = true)
    public Time getPdate() {
        return pdate;
    }

    public void setPdate(Time pdate) {
        this.pdate = pdate;
    }

    @Basic
    @Column(name = "FROMDATE", nullable = true)
    public Time getFromdate() {
        return fromdate;
    }

    public void setFromdate(Time fromdate) {
        this.fromdate = fromdate;
    }

    @Basic
    @Column(name = "TODATE", nullable = true)
    public Time getTodate() {
        return todate;
    }

    public void setTodate(Time todate) {
        this.todate = todate;
    }

    @Basic
    @Column(name = "PAYPERIOD", nullable = true, precision = 0)
    public Integer getPayperiod() {
        return payperiod;
    }

    public void setPayperiod(Integer payperiod) {
        this.payperiod = payperiod;
    }

    @Basic
    @Column(name = "PURCHASEREGION", nullable = true, length = 255)
    public String getPurchaseregion() {
        return purchaseregion;
    }

    public void setPurchaseregion(String purchaseregion) {
        this.purchaseregion = purchaseregion;
    }

    @Basic
    @Column(name = "INSURANCEREGION", nullable = true, precision = 0)
    public Integer getInsuranceregion() {
        return insuranceregion;
    }

    public void setInsuranceregion(Integer insuranceregion) {
        this.insuranceregion = insuranceregion;
    }

    @Basic
    @Column(name = "DAMAGEPROGRAMMSTOA", nullable = true, precision = 0)
    public Integer getDamageprogrammstoa() {
        return damageprogrammstoa;
    }

    public void setDamageprogrammstoa(Integer damageprogrammstoa) {
        this.damageprogrammstoa = damageprogrammstoa;
    }

    @Basic
    @Column(name = "OFFICIALSTOA", nullable = true, length = 1)
    public String getOfficialstoa() {
        return officialstoa;
    }

    public void setOfficialstoa(String officialstoa) {
        this.officialstoa = officialstoa;
    }

    @Basic
    @Column(name = "CARREGNUMBER", nullable = true, length = 30)
    public String getCarregnumber() {
        return carregnumber;
    }

    public void setCarregnumber(String carregnumber) {
        this.carregnumber = carregnumber;
    }

    @Basic
    @Column(name = "CARVIN", nullable = true, length = 30)
    public String getCarvin() {
        return carvin;
    }

    public void setCarvin(String carvin) {
        this.carvin = carvin;
    }

    @Basic
    @Column(name = "CARWEIGHT", nullable = true, precision = 0)
    public Integer getCarweight() {
        return carweight;
    }

    public void setCarweight(Integer carweight) {
        this.carweight = carweight;
    }

    @Basic
    @Column(name = "CARTONNAGE", nullable = true, precision = 0)
    public Integer getCartonnage() {
        return cartonnage;
    }

    public void setCartonnage(Integer cartonnage) {
        this.cartonnage = cartonnage;
    }

    @Basic
    @Column(name = "CARSEATS", nullable = true, precision = 0)
    public Integer getCarseats() {
        return carseats;
    }

    public void setCarseats(Integer carseats) {
        this.carseats = carseats;
    }

    @Basic
    @Column(name = "CARUSETYPE", nullable = true, precision = 0)
    public Long getCarusetype() {
        return carusetype;
    }

    public void setCarusetype(Long carusetype) {
        this.carusetype = carusetype;
    }

    @Basic
    @Column(name = "CARUSEREGION", nullable = true, precision = 0)
    public Integer getCaruseregion() {
        return caruseregion;
    }

    public void setCaruseregion(Integer caruseregion) {
        this.caruseregion = caruseregion;
    }

    @Basic
    @Column(name = "KBMCLASSFINALOSAGO", nullable = true, precision = 0)
    public Integer getKbmclassfinalosago() {
        return kbmclassfinalosago;
    }

    public void setKbmclassfinalosago(Integer kbmclassfinalosago) {
        this.kbmclassfinalosago = kbmclassfinalosago;
    }

    @Basic
    @Column(name = "KBMIDREQUESTRSAFINALOSAGO", nullable = true, precision = 4)
    public Long getKbmidrequestrsafinalosago() {
        return kbmidrequestrsafinalosago;
    }

    public void setKbmidrequestrsafinalosago(Long kbmidrequestrsafinalosago) {
        this.kbmidrequestrsafinalosago = kbmidrequestrsafinalosago;
    }

    @Basic
    @Column(name = "KBMIDSOURCEFINALOSAGO", nullable = true, precision = 0)
    public Integer getKbmidsourcefinalosago() {
        return kbmidsourcefinalosago;
    }

    public void setKbmidsourcefinalosago(Integer kbmidsourcefinalosago) {
        this.kbmidsourcefinalosago = kbmidsourcefinalosago;
    }

    @Basic
    @Column(name = "KBMCOEFFFINALOSAGO", nullable = true, precision = 4)
    public Long getKbmcoefffinalosago() {
        return kbmcoefffinalosago;
    }

    public void setKbmcoefffinalosago(Long kbmcoefffinalosago) {
        this.kbmcoefffinalosago = kbmcoefffinalosago;
    }

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REQUESTTYPE", nullable = true, length = 5)
    public String getRequesttype() {
        return requesttype;
    }

    public void setRequesttype(String requesttype) {
        this.requesttype = requesttype;
    }

    @Basic
    @Column(name = "RESPONSEMESSAGE", nullable = true)
    public String getResponsemessage() {
        return responsemessage;
    }

    public void setResponsemessage(String responsemessage) {
        this.responsemessage = responsemessage;
    }

    @Basic
    @Column(name = "SP_PROGRAMM", nullable = true, precision = 0)
    public Integer getSpProgramm() {
        return spProgramm;
    }

    public void setSpProgramm(Integer spProgramm) {
        this.spProgramm = spProgramm;
    }

    @Basic
    @Column(name = "SERVER", nullable = true, length = 10)
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Basic
    @Column(name = "CLIENT_IP", nullable = true, length = 15)
    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @Basic
    @Column(name = "CALCREQSOURCETYPEID", nullable = true, precision = 0)
    public Long getCalcreqsourcetypeid() {
        return calcreqsourcetypeid;
    }

    public void setCalcreqsourcetypeid(Long calcreqsourcetypeid) {
        this.calcreqsourcetypeid = calcreqsourcetypeid;
    }

    @Basic
    @Column(name = "SESSIONID", nullable = true, length = 255)
    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    @Basic
    @Column(name = "ADMDATE", nullable = true)
    public Time getAdmdate() {
        return admdate;
    }

    public void setAdmdate(Time admdate) {
        this.admdate = admdate;
    }

    @Basic
    @Column(name = "INPUT_MODE", nullable = true, precision = 0)
    public Integer getInputMode() {
        return inputMode;
    }

    public void setInputMode(Integer inputMode) {
        this.inputMode = inputMode;
    }

    @Basic
    @Column(name = "ERROR", nullable = true, length = 1024)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Basic
    @Column(name = "MAIN_PNUMBER", nullable = true, length = 255)
    public String getMainPnumber() {
        return mainPnumber;
    }

    public void setMainPnumber(String mainPnumber) {
        this.mainPnumber = mainPnumber;
    }

    @Basic
    @Column(name = "RASDATE", nullable = true)
    public Time getRasdate() {
        return rasdate;
    }

    public void setRasdate(Time rasdate) {
        this.rasdate = rasdate;
    }

    @Basic
    @Column(name = "CREATE_MODE", nullable = true, precision = 0)
    public Integer getCreateMode() {
        return createMode;
    }

    public void setCreateMode(Integer createMode) {
        this.createMode = createMode;
    }

    @Basic
    @Column(name = "POLICY_HEADER", nullable = true, precision = 0)
    public Long getPolicyHeader() {
        return policyHeader;
    }

    public void setPolicyHeader(Long policyHeader) {
        this.policyHeader = policyHeader;
    }

    @Basic
    @Column(name = "POLICY_STATE", nullable = true, precision = 0)
    public Integer getPolicyState() {
        return policyState;
    }

    public void setPolicyState(Integer policyState) {
        this.policyState = policyState;
    }

    @Basic
    @Column(name = "PARENT_STATE", nullable = true, precision = 0)
    public Integer getParentState() {
        return parentState;
    }

    public void setParentState(Integer parentState) {
        this.parentState = parentState;
    }

    @Basic
    @Column(name = "CLIENT_PHONE", nullable = true, length = 12)
    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Basic
    @Column(name = "COMMISSION", nullable = true, precision = 0)
    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WsCommonLogs that = (WsCommonLogs) o;

        if (calcid != that.calcid) return false;
        if (id != that.id) return false;
        if (agentid != null ? !agentid.equals(that.agentid) : that.agentid != null) return false;
        if (agencyid != null ? !agencyid.equals(that.agencyid) : that.agencyid != null) return false;
        if (requestmessage != null ? !requestmessage.equals(that.requestmessage) : that.requestmessage != null)
            return false;
        if (pdate != null ? !pdate.equals(that.pdate) : that.pdate != null) return false;
        if (fromdate != null ? !fromdate.equals(that.fromdate) : that.fromdate != null) return false;
        if (todate != null ? !todate.equals(that.todate) : that.todate != null) return false;
        if (payperiod != null ? !payperiod.equals(that.payperiod) : that.payperiod != null) return false;
        if (purchaseregion != null ? !purchaseregion.equals(that.purchaseregion) : that.purchaseregion != null)
            return false;
        if (insuranceregion != null ? !insuranceregion.equals(that.insuranceregion) : that.insuranceregion != null)
            return false;
        if (damageprogrammstoa != null ? !damageprogrammstoa.equals(that.damageprogrammstoa) : that.damageprogrammstoa != null)
            return false;
        if (officialstoa != null ? !officialstoa.equals(that.officialstoa) : that.officialstoa != null) return false;
        if (carregnumber != null ? !carregnumber.equals(that.carregnumber) : that.carregnumber != null) return false;
        if (carvin != null ? !carvin.equals(that.carvin) : that.carvin != null) return false;
        if (carweight != null ? !carweight.equals(that.carweight) : that.carweight != null) return false;
        if (cartonnage != null ? !cartonnage.equals(that.cartonnage) : that.cartonnage != null) return false;
        if (carseats != null ? !carseats.equals(that.carseats) : that.carseats != null) return false;
        if (carusetype != null ? !carusetype.equals(that.carusetype) : that.carusetype != null) return false;
        if (caruseregion != null ? !caruseregion.equals(that.caruseregion) : that.caruseregion != null) return false;
        if (kbmclassfinalosago != null ? !kbmclassfinalosago.equals(that.kbmclassfinalosago) : that.kbmclassfinalosago != null)
            return false;
        if (kbmidrequestrsafinalosago != null ? !kbmidrequestrsafinalosago.equals(that.kbmidrequestrsafinalosago) : that.kbmidrequestrsafinalosago != null)
            return false;
        if (kbmidsourcefinalosago != null ? !kbmidsourcefinalosago.equals(that.kbmidsourcefinalosago) : that.kbmidsourcefinalosago != null)
            return false;
        if (kbmcoefffinalosago != null ? !kbmcoefffinalosago.equals(that.kbmcoefffinalosago) : that.kbmcoefffinalosago != null)
            return false;
        if (requesttype != null ? !requesttype.equals(that.requesttype) : that.requesttype != null) return false;
        if (responsemessage != null ? !responsemessage.equals(that.responsemessage) : that.responsemessage != null)
            return false;
        if (spProgramm != null ? !spProgramm.equals(that.spProgramm) : that.spProgramm != null) return false;
        if (server != null ? !server.equals(that.server) : that.server != null) return false;
        if (clientIp != null ? !clientIp.equals(that.clientIp) : that.clientIp != null) return false;
        if (calcreqsourcetypeid != null ? !calcreqsourcetypeid.equals(that.calcreqsourcetypeid) : that.calcreqsourcetypeid != null)
            return false;
        if (sessionid != null ? !sessionid.equals(that.sessionid) : that.sessionid != null) return false;
        if (admdate != null ? !admdate.equals(that.admdate) : that.admdate != null) return false;
        if (inputMode != null ? !inputMode.equals(that.inputMode) : that.inputMode != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        if (mainPnumber != null ? !mainPnumber.equals(that.mainPnumber) : that.mainPnumber != null) return false;
        if (rasdate != null ? !rasdate.equals(that.rasdate) : that.rasdate != null) return false;
        if (createMode != null ? !createMode.equals(that.createMode) : that.createMode != null) return false;
        if (policyHeader != null ? !policyHeader.equals(that.policyHeader) : that.policyHeader != null) return false;
        if (policyState != null ? !policyState.equals(that.policyState) : that.policyState != null) return false;
        if (parentState != null ? !parentState.equals(that.parentState) : that.parentState != null) return false;
        if (clientPhone != null ? !clientPhone.equals(that.clientPhone) : that.clientPhone != null) return false;
        if (commission != null ? !commission.equals(that.commission) : that.commission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (calcid ^ (calcid >>> 32));
        result = 31 * result + (agentid != null ? agentid.hashCode() : 0);
        result = 31 * result + (agencyid != null ? agencyid.hashCode() : 0);
        result = 31 * result + (requestmessage != null ? requestmessage.hashCode() : 0);
        result = 31 * result + (pdate != null ? pdate.hashCode() : 0);
        result = 31 * result + (fromdate != null ? fromdate.hashCode() : 0);
        result = 31 * result + (todate != null ? todate.hashCode() : 0);
        result = 31 * result + (payperiod != null ? payperiod.hashCode() : 0);
        result = 31 * result + (purchaseregion != null ? purchaseregion.hashCode() : 0);
        result = 31 * result + (insuranceregion != null ? insuranceregion.hashCode() : 0);
        result = 31 * result + (damageprogrammstoa != null ? damageprogrammstoa.hashCode() : 0);
        result = 31 * result + (officialstoa != null ? officialstoa.hashCode() : 0);
        result = 31 * result + (carregnumber != null ? carregnumber.hashCode() : 0);
        result = 31 * result + (carvin != null ? carvin.hashCode() : 0);
        result = 31 * result + (carweight != null ? carweight.hashCode() : 0);
        result = 31 * result + (cartonnage != null ? cartonnage.hashCode() : 0);
        result = 31 * result + (carseats != null ? carseats.hashCode() : 0);
        result = 31 * result + (carusetype != null ? carusetype.hashCode() : 0);
        result = 31 * result + (caruseregion != null ? caruseregion.hashCode() : 0);
        result = 31 * result + (kbmclassfinalosago != null ? kbmclassfinalosago.hashCode() : 0);
        result = 31 * result + (kbmidrequestrsafinalosago != null ? kbmidrequestrsafinalosago.hashCode() : 0);
        result = 31 * result + (kbmidsourcefinalosago != null ? kbmidsourcefinalosago.hashCode() : 0);
        result = 31 * result + (kbmcoefffinalosago != null ? kbmcoefffinalosago.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (requesttype != null ? requesttype.hashCode() : 0);
        result = 31 * result + (responsemessage != null ? responsemessage.hashCode() : 0);
        result = 31 * result + (spProgramm != null ? spProgramm.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + (calcreqsourcetypeid != null ? calcreqsourcetypeid.hashCode() : 0);
        result = 31 * result + (sessionid != null ? sessionid.hashCode() : 0);
        result = 31 * result + (admdate != null ? admdate.hashCode() : 0);
        result = 31 * result + (inputMode != null ? inputMode.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (mainPnumber != null ? mainPnumber.hashCode() : 0);
        result = 31 * result + (rasdate != null ? rasdate.hashCode() : 0);
        result = 31 * result + (createMode != null ? createMode.hashCode() : 0);
        result = 31 * result + (policyHeader != null ? policyHeader.hashCode() : 0);
        result = 31 * result + (policyState != null ? policyState.hashCode() : 0);
        result = 31 * result + (parentState != null ? parentState.hashCode() : 0);
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        return result;
    }


}

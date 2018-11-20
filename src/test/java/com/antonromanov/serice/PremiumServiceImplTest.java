package com.antonromanov.serice;

import com.antonromanov.springhibernate.DAO.PremiumDAO;
import com.antonromanov.springhibernate.model.Premium;
import com.antonromanov.springhibernate.service.PremiumServiceImpl;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;
import java.util.Collections;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class PremiumServiceImplTest extends EasyMockSupport {

    @Rule
    public EasyMockRule em = new EasyMockRule(this);

    @Mock
    private PremiumDAO dao;

    @TestSubject
    private PremiumServiceImpl testedObject = new PremiumServiceImpl();

    @Test
    public void testNoPremiums() {
        expect(dao.getPremiumList()).andReturn(Collections.EMPTY_LIST);

        replayAll();

        assertThat(testedObject.getOne(), is("No greets"));
    }


    @Test
    public void testGreets() {
        Premium expected = new Premium();
        expected.setName("TEST");
        expect(dao.getPremiumList()).andReturn(Collections.singletonList(expected));

        replayAll();

        assertThat(testedObject.getOne(), is("TEST"));
    }





}

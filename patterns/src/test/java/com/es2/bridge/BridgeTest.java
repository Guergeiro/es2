package com.es2.bridge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BridgeTest {
    @Test(expected = ServiceNotFoundException.class)
    public void testServiceNotFoundExceptionThrown() throws ServiceNotFoundException {
        APIRequest req = new APIRequest();
        req.getContent("abc", "12");
    }

    @Test
    public void testRequestReturnsNull() throws ServiceNotFoundException {
        APIRequest req = new APIRequest();
        String idService = req.addService(new APIMoodle());
        assertNull(req.getContent(idService, "12"));
    }

    @Test
    public void testContentPreviouslyAdded() throws ServiceNotFoundException {
        APIRequest req = new APIRequest();
        String idService = req.addService(new APIMoodle());
        String idContent = req.setContent(idService, "12");
        assertEquals(req.getContent(idService, idContent), "12");
    }

    @Test
    public void testAggregatedContent() throws ServiceNotFoundException {
        APIRequest req = new APIRequestContentAggregator();
        String idService = req.addService(new APIMoodle());
        req.setContent(idService, "Eu vou");
        req.setContent(idService, " a Viseu");
        req.setContent(idService, " estudar");
        assertEquals(req.getContent(idService, "0"), "Eu vou a Viseu estudar");
    }
}

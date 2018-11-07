package lv.javaguru.java2.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// @RunWith(MockitoJUnitRunner.class)
public class AddProductServiceTest {

    //@Mock
    private ProductRepositoryMock repositoryMock = new ProductRepositoryMock();

    //@InjectMocks
    private AddProductService service;

    @Before
    public void init() {
        repositoryMock = new ProductRepositoryMock();
        service = new AddProductService(repositoryMock);
    }

    @Test
    public void test() {
        assertFalse(repositoryMock.isProductSaved());
        service.add("title", "description");
        assertTrue(repositoryMock.isProductSaved());
    }


}
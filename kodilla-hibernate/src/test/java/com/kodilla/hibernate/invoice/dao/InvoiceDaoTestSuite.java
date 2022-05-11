package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice1 = new Invoice("6789");

        Item item1 = new Item(BigDecimal.valueOf(3), 5, new Product("lasagne"));
        Item item2 = new Item(BigDecimal.valueOf(4), 6, new Product("bread"));
        Item item3 = new Item(BigDecimal.valueOf(2), 4, new Product("spaghetti"));

        invoice1.addItem(item1);
        invoice1.addItem(item2);
        invoice1.addItem(item3);

        //When
        invoiceDao.save(invoice1);

        //Then
        Assert.assertNotEquals(0,invoice1);

        //CleanUp
        invoiceDao.delete(invoice1);

    }
}

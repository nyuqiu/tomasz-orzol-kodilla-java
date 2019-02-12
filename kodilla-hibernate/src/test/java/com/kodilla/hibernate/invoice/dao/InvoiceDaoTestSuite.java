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
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Item item = new Item(BigDecimal.valueOf(2), 4);
        Item item1 = new Item(BigDecimal.valueOf(3), 5);
        Item item2 = new Item(BigDecimal.valueOf(4),6);
        Product product = new Product("bread");
        Product product1 = new Product("lasagne");
        Invoice invoice = new Invoice("2345");
        Invoice invoice1 = new Invoice("6789");
        item.setProduct(product);
        item1.setProduct(product);
        item2.setProduct(product1);
        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice1);

        //When
        productDao.save(product);
        int productId = product.getId();
        productDao.save(product1);
        int product1Id = product1.getId();
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        //Then
        Assert.assertNotEquals(0,invoiceId);
        Assert.assertNotEquals(0,invoice1Id);
        Assert.assertNotEquals(0,productId);
        Assert.assertNotEquals(0,product1Id);

        //CleanUp
        productDao.delete(productId);
        productDao.delete(product1Id);
        invoiceDao.delete(invoiceId);
        invoiceDao.delete(invoice1Id);
        }
}

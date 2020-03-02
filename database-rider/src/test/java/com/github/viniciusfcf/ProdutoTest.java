
package com.github.viniciusfcf;

import java.util.List;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTestResource(DatabaseDockerInicializer.class)
@QuarkusTest
public class ProdutoTest {

    @Test
    @DataSet("produtos1.yml")
    public void primeiroTeste() {
       Assert.assertEquals(2, Produto.count());
    }

    @Test
    @DataSet("produtos2.yml")
    public void segundoTeste() {
       Assert.assertEquals(1, Produto.count());
       Produto p = (Produto) Produto.listAll().get(0);
       Assert.assertEquals("Feijao", p.nome);
    }

    @Test
    @DataSet({"produtos2.yml", "outro"})
    public void segundoTeste2() {
       Assert.assertEquals(1, Produto.count());
       List<Produto> produtos = Produto.listAll();
       Produto p = produtos.get(0);
       Assert.assertEquals("Feijao", p.nome);
    }

}